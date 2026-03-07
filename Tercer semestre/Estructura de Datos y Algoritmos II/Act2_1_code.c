#include <stdio.h>
int main(){
	int i;
	
	//Imprimimos "Hola munndo!" y 10 iteraciones con cada hilo que tiene el procesador
	
	#pragma omp parallel private(i)
	{
		printf("Hola mundo!\n");
		for(i = 0; i < 10; i++)
			printf("Iteracion: %d\n", i);
	}
	printf("Adios\n");
	return 0;
}