#include <stdio.h>
#include <string.h>
#include <stdbool.h>

#include "../utils.c"

bool is_str_nice(char* str) {
    char c = *str;
    char last_c = 0;
    int vowel_count = 0;
    bool repeat = false;

    while(c != '\0') {
        if(c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
            vowel_count++;
        }
        if(last_c != 0) {
            if((last_c == 'a' && c == 'b')
               || (last_c == 'c' && c == 'd')
               || (last_c == 'p' && c == 'q')
               || (last_c == 'x' && c == 'y')) {
                return false;
            }
            if(c == last_c) repeat = true;
        }
        last_c = c;
        c = *++str;
    }

    return vowel_count > 2 && repeat;
}

int main(int argc, char *argv[]) {
    char *input = read_input("input/day_5");
    char* str = strtok(input, "\n");

    int nice_strings = 0;
    while(str != NULL) {
        if(is_str_nice(str)) nice_strings += 1;
        str = strtok(NULL, "\n");
    }

    printf("Part one answer: %d\n", nice_strings);

    free(input);
    return 0;
}
