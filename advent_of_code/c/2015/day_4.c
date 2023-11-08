#include <openssl/types.h>
#include <stdio.h>
#include <openssl/evp.h>
#include <string.h>

char* string_to_md5(const char *str) {
    EVP_MD_CTX *md_context = EVP_MD_CTX_new();
    const EVP_MD *md = EVP_md5();
    unsigned char md_value[EVP_MAX_MD_SIZE];
    unsigned int md_len;
    EVP_DigestInit_ex(md_context, md, NULL);
    EVP_DigestUpdate(md_context, str, strlen(str));
    EVP_DigestFinal(md_context, md_value, &md_len);
    EVP_MD_CTX_free(md_context);

    char* buf = malloc(33); // 32 chars + null terminator
    for(unsigned int i = 0; i < md_len; i++) {
        snprintf(&buf[i * 2], 16 * 2, "%02x", md_value[i]);
    }

    return buf;
}

// returns the string to format what's going to be placed in the digits buffer
char* digit_format_str(int len) {
    // max size of hash (32) + other characters and null terminator
    char* format = malloc(7);
    sprintf(format, "%%.%.2ds", len);
    format[6] = '\0';
    return format;
}

long count_digits_for_hash(char* hash_start, const char* secret_key) {
    char str[12];
    char h_start_len = strlen(hash_start);
    int count = 0;

    while(1) {
        // write current count as string into buffer str
        snprintf(str, 12, "%d", count);

        // write key and count string into a
        char a[20];
        strcpy(a, secret_key);
        strcat(a, str);

        // generate hash from a
        char* md5_hash = string_to_md5(a);

        // store first digits of hash
        char digits[h_start_len + 1];
        char* format_str = digit_format_str(h_start_len);
        snprintf(digits, h_start_len + 1, format_str, md5_hash);

        free(format_str);
        free(md5_hash);

        // break if hash start and digits are equal
        if(strcmp(digits, hash_start) == 0) {
            break;
        }
        count++;
    }

    return count;
}

int main(int argc, char *argv[]) {
    const char *secret_key =  "iwrupvqb";

    long d1_answer = count_digits_for_hash("00000", secret_key);
    printf("Part one answer: %ld\n", d1_answer);
    long d2_answer = count_digits_for_hash("000000", secret_key);
    printf("Part two answer: %ld\n", d2_answer);

    return 0;
}
