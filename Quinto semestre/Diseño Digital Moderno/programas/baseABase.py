#**Tarea**: Programa que convierta números de cualquiera base a otra base cualquiera xd yy palique complemento a 2(?) <---- solo cuando es binario?
#ruta absoluta: cd downloads/ing_compu/ing-compu-fi-unam/quinto semestre/diseño digital moderno/programas
letrasxd = ('A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'Ñ', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z')

#Convertir parte entera a decimal
def entDec(num, base):
    total = 0
    alreves = num[::-1]
    for i in range(len(num)):
        total += int(alreves[i]) * base**i
    return total

def decDiez(num, base):
    total = 0
    for i in range(len(num)):
        potencia = -(i + 1)
        #print(f"Num: {num[i]}, base: {base}, i: {i}, total: {total}, suma: {int(num[i]) * base**i}")
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
#Guardar número a convertir
numAConv = input("Ingresa el numero a covertir: ")

try:
    baseOri = int(input("Ingresa la base de ese número: "))
except ValueError:
    print("Ingresa una base válida, por favor")

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

#Separando entero de decimal
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