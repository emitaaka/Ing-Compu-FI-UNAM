#include <stdio.h>
#include <omp.h>

int main(){
	int i;

	#pragma omp parallel private(i) num_threads(4)
	{
		printf("Hola mundo!\n");
		for(i = 0; i < 10; i++)
			printf("Iteracion: %d\n", i);
	}
	printf("Adios\n");
	return 0;
}