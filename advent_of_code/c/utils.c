#include <stdio.h>

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
