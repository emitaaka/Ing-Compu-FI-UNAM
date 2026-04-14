/*
  Autores: Cuéllar Jiménez Luis Armando y Pérez Takayanagui Louis Emilio
  Fecha: 12/04/2026
  Descripción: Implementación del método de Interpolación Lineal
*/

import kotlin.math.exp
import kotlin.math.abs

// Función a evaluar (e^x - 2)
fun funcExponencial(x: Double): Double {
    return exp(x) - 2.0
}

fun interpolacion_lineal(a: Double, b: Double, iteraciones: Int, tolerancia: Double) {
    var a1 = a
    var b1 = b
    // Verificamos el cambio de signo

    //var er = abs((c - a1) / c) * 100.0
    if (funcExponencial(a) * funcExponencial(b) < 0) {

        var c = 0.0
        var iteracionFinal = 0

        //Para calcular el error relativo
        var cTemp = 0.0

        var er = 100.0

        for (i in 0 until iteraciones) {
            //Cálculo de la interpolación lineal
            c = a1 + ((a1 - b1) * funcExponencial(a1))/(funcExponencial(b1) - funcExponencial(a1))

            //Cálculo error relativo
            er = abs((c - cTemp) / c) * 100.0
    
            println("Iteración ${i + 1} a: $a c: $c| Error = $er%")

            if (funcExponencial(a1) * funcExponencial(c) < 0) {
                b1 = c
            } else if (funcExponencial(c) * funcExponencial(b1) < 0) {
                a1 = c
            } else {
                break
            }

        cTemp = c

        if (c == 0.0 || c == a1) {
            iteracionFinal = i
            continue
        }

        iteracionFinal = i
        if (er < tolerancia) {
            break
        }
    }
    println("La raíz aproximada es $c, se obtuvo con ${iteracionFinal + 1} iteraciones y con error relativo de $er%")
 } else {
    println("El intervalo $a $b no tiene un cambio de signo, no hay raíz")
    }
}

fun main(){
    //print("vamos a llamar a la funcion interpolacion lineal")

    print("Dame el intervalo de la función separados por un espacio: ")
    var (x, y) = readln().split(" ")
    var a = x.toDouble()
    var b = y.toDouble()

    while(a > b){
        print("Intervalo no válido, por favor vuelva a ingresarlo: ")
        val entrada = readln().split(" ")
        a = entrada[0].toDouble() // Actualizamos las variables de afuera
        b = entrada[1].toDouble()
    }

    print("Ahora dame la cantidad de iteraciones máxima: ")
    val it = readln().toInt()

    print("Y por último ingresa la tolerancia: ")
        val tolerancia = readln().toDouble()

    interpolacion_lineal(a, b, it, tolerancia)

    //validar que el usuario dé intervalos válidos (límite inferior no puede ser mayor que el superior)
    //Mostrar error relativo

}