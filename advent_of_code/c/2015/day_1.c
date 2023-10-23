#include <stdio.h>
#include <stdlib.h>
#include "../utils.c"

enum { FALSE, TRUE };

int main(int argc, char *argv[]) {

    char *input = read_input("input/day_1");

    int i = 0;
    int j = 0;
    int enteredBasement = FALSE;
    char *c;

    for (c = input; *c != '\0'; c++) {
        if (*c == ')') {
            i--;
        } else if (*c == '('){
            i++;
        }
        if (!enteredBasement) {
            if (i == -1)
                enteredBasement = TRUE;
            j++;
        }
    }

    printf("Part one answer: %d\n", i);
    printf("Part two answer: %d\n", j);

    return 0;
}
