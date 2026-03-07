#include <stdio.h>
#include <stdlib.h>
#include <omp.h>

void countingSort(int arr[], int n) {
    int i;

    // Necesitamos saber esto para crear el arreglo de conteo del tamaño correcto.
    int max = 0;
    for (i = 0; i < n; i++) {
        if (arr[i] > max)
            max = arr[i];
    }

    // Usamos calloc para que todo se inicialice en 0 automáticamente.
    int *count = (int *)calloc(max + 1, sizeof(int));
    if (count == NULL) {
        printf("Error de memoria\n");
        return;
    }

    // Aquí contamos cuántas veces aparece cada número.
    for (i = 0; i < n; i++) {
        count[arr[i]]++;
    }

    // Leemos el arreglo 'count' y reescribimos en 'arr'.
    int index = 0;
    for (i = 0; i <= max; i++) {
        while (count[i] > 0) {
            arr[index++] = i;
            count[i]--;
        }
    }

    // Liberar memoria auxiliar
    free(count);
}

// Función auxiliar para imprimir
void printArray(int arr[], int n) {
	int i;
    for (i = 0; i < n; i++)
        printf("%d ", arr[i]);
    printf("\n");
}

int main() {
    int n = 50;
	int *arr = (int*)malloc(n * sizeof(int));
    
    for(int i=0; i<n; i++) {
        arr[i] = rand() % 100; 
    }

    printf("Arreglo original: \n");
    printArray(arr, n);
    
    double start = omp_get_wtime();
    countingSort(arr, n);
    double end = omp_get_wtime();

    printf("\nArreglo ordenado: \n");
    printArray(arr, n);
    printf("Ordenado en %f segundos.\n", end - start); 

    return 0;
}