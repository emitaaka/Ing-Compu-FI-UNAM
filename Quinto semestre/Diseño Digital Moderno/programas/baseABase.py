#**Tarea**: Programa que convierta números de cualquiera base a otra base cualquiera xd yy palique complemento a 2(?) <---- solo cuando es binario?
#ruta absoluta: cd downloads/ing-compu-fi-unam/quinto semestre/diseño digital moderno/programas
letrasxd = ('A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'Ñ', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z')

#Convertir parte entera a base 10
def entDec(num, base):
    total = 0
    alreves = num[::-1]
    for i in range(len(num)):
        total += int(alreves[i]) * base**i
    return total

#Convertir parte decimal (depsués del punto) a base 10
def decDiez(num, base):
    total = 0
    for i in range(len(num)):
        potencia = -(i + 1)
        total += int(num[i]) * base**potencia
    return total

#Convierte cualquier letra de letrasxd en un valor decimal
def letrasANumeros(letra):
    if letra in letrasxd:
        return letrasxd.index(letra) + 10
    else:
        return -1

def numerosALetras(numero):
    if numero - 1 < 37:
        return letrasxd[numero - 10]
    else: 
        print("no puede entrar aquí el if, no? jaajaj")

def decEnteroACualquier(num, base):
    valor = ""
    while num > 0:
        residuo = num%base
        num = num//base
        if residuo > 9:
            valor += numerosALetras(residuo)
        else:
            valor += str(residuo)
    return valor[::-1]

def decFraccionACualquier(num, base):
    num = num/ 10 ** len(str(num))
    valor = ""
    cont = 0
    while cont < 5:
        if num >= 1:
            num = (num % 1) * base
        else: 
            num = num * base
        ent = int(num//1)
        if ent > 9:
            valor += numerosALetras(ent)
        else:
            valor += str(ent)
        cont += 1
    return valor

def validarBinario(binario):
    for i in range(len(binario)):
        try:
            if int(binario[i]) > 1:
                print(f"El número {binario} es inválido.")
                break
        except ValueError:
            print("Error al revisar el código")

def tienePunto(numero):
    punto = numero.find('.')

    ent = ""
    dec = ""

    if punto != -1:
        ent += numero[:punto]
        dec += numero[punto + 1:]
    else:
        ent = numero

    return ent, dec

opc = 0

while opc != 3:
    print("\nBienvenido al conversor de bases, ¿qué deseas hacer?")
    print("1. Convertir un número de cualquier base a cualquier base.")
    print("2. Sumar (o restar) números (solo en binario).")
    print("3. Salir")
    opc = int(input())

    if opc == 1:
        print(f'Elegiste la opción {opc}: Convertir números.')
        #Guardar número a convertir
        numAConv = input("Ingresa el numero a covertir: ")

        #Validamos que la base sea un número entero (entero?)
        try:
            baseOri = int(input("Ingresa la base de ese número: "))
        except ValueError:
            baseOri = int(input("Ingresa una base válida, por favor: "))

        nuevoNumAConv = list(numAConv)
        for i in range(len(numAConv)):
            if numAConv[i] != '.':
                caracter = numAConv[i].upper()
                if caracter in letrasxd:
                    nuevoNumAConv[i] = letrasANumeros(caracter)
                elif caracter.isdigit():
                    nuevoNumAConv[i] = int(caracter)
                else:
                    print(f'{caracter} no es un dígito válido.')
                    break
                if int(nuevoNumAConv[i]) > baseOri - 1:
                    print(f"{caracter} no es un dígito válido.")
                
        try:
            baseConv = int(input("Ingresa la base a la que quieres convertir el número: "))
        except:
            print("Ingresa una base válida, por favor")

        tam = len(nuevoNumAConv)
        entero = ""
        decimal = ""
        total = ""

        #Separando entero de decimal y convirtiendo la base
        posPunto = numAConv.find('.')
        if posPunto != -1:
            entero = nuevoNumAConv[:posPunto]
            decimal = nuevoNumAConv[posPunto + 1:]
            total += str(entDec(entero, baseOri) + decDiez(decimal, baseOri))
        else:
            entero = nuevoNumAConv
            total += str(entDec(entero, baseOri))

        if baseConv == 10:
            print(f"El numero convertido a base 10 es: {total}")
        else:
            posPunto2 = total.find(".")
            aConv = total
            if posPunto2 != -1:
                entero = int(aConv[:posPunto2])
                decimal = int(aConv[posPunto2 + 1:])
                total = str(decEnteroACualquier(entero, baseConv)) + '.' + (decFraccionACualquier(decimal, baseConv))
                print(f'El número {numAConv} convertido a base {baseConv} es: {total}')
            else:
                entero = int(aConv)
                total = decEnteroACualquier(entero, baseConv)
                print(f'El número {numAConv} convertido a base {baseConv} es: {total}')
    elif opc == 2:
        print(f'Elegiste la opción {opc}: Suma de números binarios.\nTen en cuenta que el bit más significativo será considerado el bit de signo.\n')

        binario1 = input("Ingresa el primer número en binario: ")
        binario2 = input("Ingresa el segundo número en binario: ")

        entBinario1, decBinario1 = tienePunto(binario1)
        entBinario2, decBinario2 = tienePunto(binario2)

        lenBin1 = len(binario1)
        lenBin2 = len(binario2)

        if lenBin1 != lenBin2:
            print("los numeros son de diferente longitud, ahorita lo arreglamos")
            dif = lenBin1 - lenBin2
            ceros = ""
            if dif < 0:
                dif *= -1
            for i in range(dif):
                ceros += "0"
            if lenBin1 < lenBin2:
                temp = binario1[1:]
                binario1 = binario1[:1] + ceros + temp
                print(f"actualizamos binario1 y quedó así: {binario1}, temp vale {temp} y ceros vale {ceros}")
            else: 
                temp = binario2[1:]
                binario2 = binario2[:1] + ceros + temp
                print(f"actualizamos binario2 y quedó así: {binario2}, temp vale {temp} y ceros vale {ceros}")

        if binario2[0] == '1':
            print("es negativo :D")
            for i in range(len(binario2) - 1, 0, -1):
                print(f'{binario2[i]}')

    elif opc == 3:
        print("Adiós!")
    else:
        print("Ingresa un número válido por favor")




### Ideas ideas ideas
#- en python
#- primero pedir el número
#- luego pedir la base en que está
#- luego pedir la base a convertir
#- si es de cualquier base a decimal, aplicar la fórmula de la sumatoria
#- ¿cómo? primero dividimos el número (agarramos cada carácter. ocupando la string como arreglo(???)), luego lo convertimos a entero, usamos un for que se repita la cantidad de caracteres que tenga (longitud de la cadena), multiplicamos el primer valor d la cadena por la base potenciada al valor de su posición menos 1 (me entiendo yo) y guardamos ese valor en una variable llamada enteros
#- por qué se llama enteros? por si el número tiene decimal, en este caso dividimos el número en dos cachos, parte entera y parte decimal
#- para la parte entera, una vez que haya acabado de hacer la suma, entonces invierta la cadena y ya quedó convertido
#- para la parte decimal, solo añade los números y ya queda en orden
#- validar que sí sean números los que ingrese el usuario
#- validar que el número sea válido en la base


#IP 132.248.67.26 (cambia esta)
#132.248.204.1
#132.248.10.2
#132.248.67.254
#mascaras 255*3