#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#include "../utils.c"

void move(int xy[2], char c) {
    if(c == '<') {
        xy[0]--;
    } else if(c == '>') {
        xy[0]++;
    } else if(c == '^') {
        xy[1]++;
    } else if(c == 'v') {
        xy[1]--;
    }
}

int main(int argc, char *argv[]) {
    char* input = read_input("input/day_3");
    int xy[] = { 0, 0 };
    char* inputStart = input;

    char c = *inputStart;

    // tracking how far the coordinates go from input
    int x_max = 0;
    int y_max = 0;

    while (c != '\0') {
        move(xy, c);

        if(abs(xy[0]) > x_max) {
            x_max = abs(xy[0]);
        }
        if(abs(xy[1]) > y_max) {
            y_max = abs(xy[1]);
        }

        c = *++inputStart;
    }

    int x_size = x_max * 2 + 1;
    int y_size = y_max * 2 + 1;

    int matrix[x_size][y_size];
    memset(matrix, 0, sizeof(matrix));

    int xy_pos[] = { x_size / 2, y_size / 2 };

    inputStart = input;
    c = *inputStart;

    while (c != '\0') {
        matrix[xy_pos[0]][xy_pos[1]]++;
        move(xy_pos, c);
        c = *++inputStart;
    }

    int gifted_houses = 0;
    for (int i = 0; i < x_size; i++) {
        for (int j = 0; j < y_size; j++) {
            if(matrix[i][j] > 0) gifted_houses++;
        }
    }

    printf("Part one answer: %d", gifted_houses);

    free(input);

    return 0;
}
