#include <stdio.h>

//Agregamos biblioteca omp.h para habilitar programación paralela
#include <omp.h>

int main(){
	int i;
	
	//Usamos la función omp_set_num_theads para definir cuántos hilos del procesador queremos usar en las próximas regiones paralelas
	omp_set_num_threads(4);
	
	#pragma omp parallel private(i)
	{
		printf("Hola mundo!\n");
		for(i = 0; i < 10; i++)
			printf("Iteracion: %d\n", i);
	}
	printf("Adios\n");
	return 0;
}