pila = []

def insertar(elemento):
    pila.append(elemento)

def eliminar():
    pila.pop()

def consultar():
    for indice in range(1, len(pila) + 1):
        print(pila[-indice])

while True:
    print("***Menu***")
    print("* 1.- Insertar *")
    print("* 2.- Eliminar *")
    print("* 3.- Consultar *")
    print("* 4.- Salir *")
    print("*************")
    opcion = int(input("Qué quieres hacer?: "))
    if opcion == 1:
        elemento = input("Inserta el nuevo elemento: ")
        insertar(elemento)
    elif opcion == 2:
        eliminar()
    elif opcion == 3:
        consultar()
    else:
        break


