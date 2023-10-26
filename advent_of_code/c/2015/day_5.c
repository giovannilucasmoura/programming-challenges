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

bool is_str_really_nice(char* str) {
    bool pair_repeat = false;
    bool sandwich = false;
    int length = strlen(str);

    for (int i = 1; i < length - 2; i++) {
        if(pair_repeat) {
            break;
        };
        char pair[] = { str[i - 1], str[i] };

        for(int j = i + 2; j < length; j++) {
            char pair_cmp[] = { str[j - 1], str[j] };

            if(pair[0] == pair_cmp[0] && pair[1] == pair_cmp[1]) {
                pair_repeat = true;
                break;
            }
        }
    }

    if(!pair_repeat) return false; // stopping early

    for(int i = 1; i < length - 1; i++) {
        char trio[] = { str[i - 1], str[i], str[i + 1] };
        if(trio[0] == trio[2]) {
            sandwich = true;
            break;
        }
    }
    return pair_repeat && sandwich;
}

int main(int argc, char *argv[]) {
    char *input = read_input("input/day_5");
    char* str = strtok(input, "\n");

    int nice_strings = 0;
    while(str != NULL) {
        if(is_str_nice(str)) nice_strings += 1;
        str = strtok(NULL, "\n");
    }

    free(input);
    input = read_input("input/day_5");
    str = strtok(input, "\n");

    int really_nice_strings = 0;
    while(str != NULL) {
        if(is_str_really_nice(str)) really_nice_strings += 1;
        str = strtok(NULL, "\n");
    }

    printf("Part one answer: %d\n", nice_strings);
    printf("Part two answer: %d\n", really_nice_strings);

    free(input);
    return 0;
}
