#include <stdio.h>
#include <stdlib.h>
#include <time.h>

#define FILAS 6
#define COLUMNAS 10

void menu(){
    printf("--- CINE ---\n\n");
    printf("%cA donde quieres ir?\n", 168);
    printf("1. Taquilla.\n");
    printf("2. Dulceria.\n");
    printf("3. Cafeteria.\n");
    printf("4. Pagar.\n");
    printf("%c ", 254);
}

void menuDul(){
    printf("\n%cQue vas a querer?\n", 168);
    printf("1. Refresco - $28.\n");
    printf("2. Palomitas - $25.\n");
    printf("3. Combo (palomitas + refresco) - $50.\n");
    printf("4. Salir de la dulceria.\n");
    printf("%c ", 254);
}

void menuCoffee(){
    printf("\n%cQue vas a querer?\n", 168);
    printf("1. Americano - $20.\n");
    printf("2. Capuchino - $35.\n");
    printf("3. Crepa - $40\n");
    printf("4. Combo (Capuchino + Crepa) - $75.\n");
    printf("5. Salir de la cafeteria.\n");
    printf("%c ", 254);
}

void lugaresRandom(int sala[FILAS][COLUMNAS]){
    int num1, num2, i;
    
    srand(time(NULL));

    for(i = 0; i < 23; i++){
        num1 = rand() % FILAS;
        num2 = rand() % COLUMNAS;
        sala[num1][num2] = 1;
    }
}

void mostrarSala(int sala[FILAS][COLUMNAS]){
    int i, j;
    
    for(j = 0; j < COLUMNAS; j++){
        printf("%d | ", j);
    }
    printf("\n- - - - - - - - - - - - - - - - - - - -\n");
    for(i = 0; i < FILAS; i++){
        for(j = 0; j < COLUMNAS; j++){
            printf("%d | ", sala[i][j]);
        }
        printf("%d ", i);
        printf("\n");
    }

    printf("  ----------- PANTALLA -----------\n\n");
}

void escogerLugares(int sala[FILAS][COLUMNAS]){
    int hor, vert, val = 0;

    while(val == 0){
        do{
            printf("%cEn que fila (horizontal) te quieres sentar?: ", 168);
            scanf("%d", &hor);
            printf("%cQue numero de asiento (vertical) escoges?: ", 168);
            scanf("%d", &vert);

            if(hor < 0 || hor > (FILAS - 1) || vert < 0 || vert > (COLUMNAS - 1)){
                printf("\nAlguno de los valores es invalido, vuelve a ingresar tu asiento, por favor.\n");
            }
        }while(hor < 0 || hor > (FILAS -1) || vert < 0 || vert > (COLUMNAS - 1));

        if(sala[hor][vert] == 0){
            sala[hor][vert] = 1;
            val = 1;
        }else{
            printf("El asiento %d, %d esta ocupado, elija otro por favor.\n", hor, vert);
        }
    }

    printf("\nElegiste la fila %d y el asiento %d \n", hor, vert);
}

void opciones(int sala[FILAS][COLUMNAS]){
    int temp, opc;
    double total = 0, t;

    lugaresRandom(sala);

    do{
        menu();
        scanf("%d", &opc);

        printf("\n");

        switch (opc){
            case 1:
                printf("Elegiste taquilla.\n\n");

                printf("Los boletos cuestan 75 pesos.\n");
                printf("Hora de elegir tu asiento.\n");
                printf("Los asientos con un 0 estan vacios, los que tienen un 1 estan ocupados.\n\n");

                mostrarSala(sala);
                
                escogerLugares(sala);
                total += 75;

                printf("\nSe agregaron $75 al total de tu cuenta.\n\n");

                break;
            case 2:
                printf("Elegiste Dulceria.\n");

                menuDul();
                scanf("%d", &temp);
                printf("\n");

                if(temp == 1){
                    printf("Toma tu refresco.");
                    total += 28;
                    printf("\nSe agregaron $28 al total de tu cuenta.");
                }else if(temp == 2){
                    printf("Toma tus palomitas.");
                    total += 25;
                    printf("\nSe agregaron $25 al total de tu cuenta.");
                }else if(temp == 3){
                    printf("Toma tu combo.");
                    total += 50;
                    printf("\nSe agregaron $50 al total de tu cuenta.");
                }else if(temp == 4){
                    printf("Nos vemos!");
                }else{
                    printf("Opcion invalida.");
                }

                printf("\n\n");

                break;
            case 3:
                printf("Elegiste Cafeteria.\n");

                menuCoffee();
                scanf("%d", &temp);
                printf("\n");

                if(temp == 1){
                    printf("Toma tu americano.");
                    total += 20;
                    printf("\nSe agregaron $20 al total de tu cuenta.");
                }else if(temp == 2){
                    printf("Toma tu capuchino.");
                    total += 35;
                    printf("\nSe agregaron $35 al total de tu cuenta.");
                }else if(temp == 3){
                    printf("Toma tu crepa.");
                    total += 40;
                    printf("\nSe agregaron $40 al total de tu cuenta.");
                }else if(temp == 4){
                    printf("Toma tu combo.");
                    total += 75;
                    printf("\nSe agregaron $75 al total de tu cuenta.");
                }else if(temp == 5){
                    printf("Nos vemos!");
                }else{
                    printf("Opcion invalida.");
                }

                printf("\n\n");
                break;
            case 4:

                printf("--- CAJA ---\n\n");

                printf("El total de tu compra es: %.2lf\n", total);

                printf("Con cuanto dinero vas a pagar?: ");
                scanf("%lf", &t);

                printf("\n");
                if(t >= total){
                    printf("Tu cambio es de $%.2lf pesos.", t - total);
                }else if(t < total){
                    printf("Te faltan $%.2lf pesos.", total - t);
                    
                    printf("\nVas a pagarlos?\n");
                    printf("1. Si.\n");
                    printf("2. No.\n%c", 254);
                    scanf("%d", &temp);
                    
                    printf("\n");

                    if(temp == 1){
                        printf("Muchas gracias :D");
                    }else if(temp == 2){
                        printf("Ratero.");
                    }
                }

                printf("\n\nGracias por visitarnos. Hasta luego!");
                break;
            default:
                printf("Opcion invalida.\n\n");
                break;
        }

    }while(opc != 4);
}

int main(){
    int sala[FILAS][COLUMNAS] = {0}, i, j;
    double total;

    opciones(sala);

    return 0;
}