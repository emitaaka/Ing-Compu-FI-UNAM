/*
  Autores: Cuéllar Jiménez Luis Armando y Pérez Takayanagui Louis Emilio
  Fecha: 12/04/2026
  Descripción: Implementación del método de Bisección
*/

import kotlin.math.exp

 // Función a evaluar (e^x - 2)
fun funcExponencial(x: Double): Double {
    return exp(x) - 2.0
}

fun biseccion() {
    print("Ingresa el límite inferior (a) del intervalo: ")
    var a = readln().toDouble()

    print("Ingresa el límite superior (b) del intervalo: ")
    var b = readln().toDouble()

    // Verificamos el cambio de signo
    if (funcExponencial(a) * funcExponencial(b) < 0) {
        print("Ingresa el número máximo de iteraciones a realizar: ")
        val maxIteraciones = readln().toInt()

        print("Ingresa la tolerancia: ")
        val tolerancia = readln().toDouble()

        var c = 0.0
        var iteracionFinal = 0

        for (i in 0 until maxIteraciones) {
            c = (a + b) / 2.0

            if (funcExponencial(a) * funcExponencial(c) < 0) {
                b = c
            } else if (funcExponencial(c) * funcExponencial(b) < 0) {
                a = c
            } else {
                break
            }

        if (c == 0.0 || c == a) {
            iteracionFinal = i
            continue
        }

        var er = ((c - a) / c) * 100.0
        // Cálculo del valor absoluto
        if (er < 0) {
            er *= -1.0
        }

        iteracionFinal = i
        if (er < tolerancia) {
            break
        }
    }
    println("La raíz aproximada es $c y se obtuvo con ${iteracionFinal + 1} iteraciones")
 } else {
    println("El intervalo $a $b no tiene un cambio de signo, no hay raíz")
    }
}

fun main(){
    print("holaaa")
}