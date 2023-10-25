#include <stdio.h>
#include <stdlib.h>

// from what i've read this probably only works on linux
char* read_input(char* filename) {
    char * buffer = 0;
    long length;
    FILE * f = fopen (filename, "r");

    if (f) {
        // move indicator to end of file
        fseek (f, 0, SEEK_END);
        // return current indicator position
        length = ftell (f);
        // back to beginning of file
        fseek (f, 0, SEEK_SET);

        buffer = malloc (length);

        if (buffer) {
            fread (buffer, 1, length, f);
        }

        fclose (f);
    }

    return buffer;
}

void swap(int* arr, int n, int m) {
    int aux = arr[m];
    arr[m] = arr[n];
    arr[n] = aux;
}

void print_array(int* arr, int n) {
    for (int i = 0; i < n; i ++) {
        printf("%d ", arr[i]);
    }
    printf("\n");
}

void print_matrix(int n, int m, int mat[n][m]) {
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < m; j++) {
            printf("%d ", mat[i][j]);
        }
        printf("\n");
    }
}

int insertion_sort(int* arr, int n) {
    int key = 1;

    while(key < n) {
        int prev_key = key;

        while(prev_key > 0 && arr[prev_key - 1] > arr[prev_key]){
            swap(arr, prev_key, prev_key - 1);
            prev_key -= 1;
        }

        key += 1;
    }

    return 0;
}
