#include "../utils.h"
#include <limits.h>
#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int smallest_side_area(int length, int width, int height) {
    int sides[] = { length * height, height * width, length * width };

    int min = INT_MAX;
    for (int i = 0; i < 3; i++) {
        if (sides[i] < min)
            min = sides[i];
    }

    return min;
}

int ft_of_ribbon(int length, int width, int height) {
    int dimensions[] = { length, height, width };
    insertion_sort(dimensions, 3);

    int wrap_ft = 2 * (dimensions[0] + dimensions[1]);
    int bow_ft = length * width * height;

    return wrap_ft + bow_ft;
}

int main(int argc, char *argv[]) {
    char* input = read_input("input/day_2");
    char* ptr;

    int total_sfc_area = 0;
    int total_ribbon_ft = 0;
    char* token = strtok_r(input, "\n", &ptr);
    while(token != NULL) {
        char *str = malloc(strlen(token) + 1);

        strcpy(str, token);

        int l = atoi(strtok(str, "x"));
        int w = atoi(strtok(NULL, "x"));
        int h = atoi(strtok(NULL, "x"));

        int sfc_area = 2 * ((l * h) + (w * h) + (w * l));
        total_sfc_area += sfc_area + smallest_side_area(l, w, h);
        total_ribbon_ft += ft_of_ribbon(l, w, h);

        free(str);

        token = strtok_r(NULL, "\n", &ptr);
    }

    free(input);

    printf("Part one answer: %d\n", total_sfc_area);
    printf("Part two answer: %d\n", total_ribbon_ft);

    return 0;
}
