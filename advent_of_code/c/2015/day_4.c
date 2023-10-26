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

int main(int argc, char *argv[]) {
    char str[12];

    int i = 0;
    while(1) {
        snprintf(str, 12, "%d", i);
        char a[19] = "iwrupvqb";
        strcat(a, str);
        char* md5_hash = string_to_md5(a);
        char digits[6];
        snprintf(digits, 6, "%.05s", md5_hash);
        free(md5_hash);
        if(strcmp(digits, "00000") == 0) {
            break;
        }
        i++;
    }

    int j = 0;
    while(1) {
        snprintf(str, 12, "%d", j);
        char a[19] = "iwrupvqb";
        strcat(a, str);
        char* md5_hash = string_to_md5(a);
        char digits[7];
        snprintf(digits, 7, "%.06s", md5_hash);
        free(md5_hash);
        if(strcmp(digits, "000000") == 0) {
            break;
        }
        j++;
    }

    printf("Part one answer: %d\n", i);
    printf("Part two answer: %d\n", j);

    return 0;
}
