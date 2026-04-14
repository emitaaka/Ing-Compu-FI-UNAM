/*
  Autores: Cuéllar Jiménez Luis Armando y Pérez Takayanagui Louis Emilio
  Fecha: 13/04/2026
  Descripción: Implementación del método de Newton - Raphson
*/


import kotlin.math.exp
import kotlin.math.pow
import kotlin.math.abs

// Función original f(x) = e^x - 2
fun funcionOriginal(x: Double): Double {
    return exp(x) - 2.0
}

// Primera derivada f’(x) = e^x
fun primeraDerivada(x: Double): Double {
    return exp(x)
}

// Segunda derivada f’’(x) = e^x
fun segundaDerivada(x: Double): Double{
    return exp(x)
}

fun newton_raphson(func: Double, derivada: Double, estInic: Double, tolerancia: Double, maxIteraciones: Int) {
    var xn = 0.0
    var iteracionFinal = 0

    var estimacionInicial = estInic

    //Utilizamos el criterio de convergencia para ver si se puede continuar utilizanco el método
    val criterioConvergencia = abs((funcionOriginal(estimacionInicial)*segundaDerivada(estimacionInicial))/(primeraDerivada(estimacionInicial).pow(2.0)))

    if (criterioConvergencia >= 1){
        print("No se puede continuar con el método debido al criterio de convergencia")
        return
    }

    for (i in 0 until maxIteraciones) {
        xn = estimacionInicial - (funcionOriginal(estimacionInicial) / primeraDerivada(estimacionInicial))

        var er = ((xn - estimacionInicial) / xn) * 100.0
        if (er < 0) {
            er *= -1.0
        }

        iteracionFinal = i
        if (er < tolerancia) {
            break
        }
        estimacionInicial = xn
    }

    println("La raíz aproximada es xn = $xn y se obtuvo con ${iteracionFinal + 1} iteraciones")
}

fun main(){

    //Pedimos al usuario el valor inicial y la tolerancia
    print("Ingresa el valor inicial de x_0 y la tolerancia, separados por espacios: ")
    var (x, y) = readln().split(" ")
    var estimacionInicial = x.toDouble()
    var tolerancia = y.toDouble()

    //Le pedimos al usuario el número máximo de iteraciones
    print("Ahora dame el número máximo de iteraciones: ")
    var iteraciones = readln().toInt()

    //Invocamos a la función con los valores enviados como parámetros
    newton_raphson(funcionOriginal(estimacionInicial), primeraDerivada(estimacionInicial), estimacionInicial, tolerancia, iteraciones)
}