#include <stdio.h>
#include <stdlib.h>
#include <omp.h> //Agregamos biblioteca para programación paralela

void countingSortParallel(int arr[], int n) {
    int i;
    int max = 0;

    // Encontramos el Max (Paralelizado) 
	// 'reduction(max: max)': Cada hilo busca su propio máximo local,  y al final OpenMP compara todos y dejar el ganador en 'max'.
    #pragma omp parallel for reduction(max: max)
    for (i = 0; i < n; i++) {
        if (arr[i] > max)
            max = arr[i];
    }

    // Inicializamos count (Paralelizado)
    // Cada hilo inicializa una parte del arreglo a 0.
    int *count = (int *)malloc((max + 1) * sizeof(int));
    if (count == NULL) return;

    #pragma omp parallel for
    for (i = 0; i <= max; i++) {
        count[i] = 0;
    }

    // Contamos frecuencias (Paralelizado con ATOMIC)
    // Varios hilos podrían intentar sumar al mismo número,, 'atomic' asegura que solo un hilo escriba en esa casilla de memoria a la vez.
    #pragma omp parallel for
    for (i = 0; i < n; i++) {
        #pragma omp atomic
        count[arr[i]]++;
    }

    // Reconstruimos
    // Paralelizar esto es difícil porque necesitamos saber en qué posición (index) escribir, y eso depende de cuántos números escribieron los hilos anteriores.
    int index = 0;
    for (i = 0; i <= max; i++) {
        while (count[i] > 0) {
            arr[index++] = i;
            count[i]--;
        }
    }

    free(count);
}

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

    omp_set_num_threads(4);
    
    printf("Arreglo original:\n");
    printArray(arr, n);

    double start = omp_get_wtime(); 
    countingSortParallel(arr, n);
    double end = omp_get_wtime();

	printf("\nArreglo ordenado:\n");
	printArray(arr, n);
    printf("Ordenado en %f segundos.\n", end - start); 
    return 0;
}