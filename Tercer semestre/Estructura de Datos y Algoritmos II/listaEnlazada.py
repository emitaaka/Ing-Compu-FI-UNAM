class Nodo:
    def __init__(self):
        self.nombre = None
        self.edad = 0
        self.siguiente = None

class Lista: 
    def __init__(self):
        self.raiz = Nodo()

    def insertar(self, nodo):
        if self.raiz.nombre == None:
            self. raiz = nodo
        else:
            aux = self.raiz
            while True:
                if aux.siguiente == None:
                    aux.siguiente = nodo
                    break
                else: 
                    aux = aux.siguiente

    def consultar(self):
        aux = self.raiz
        if aux.nombre == None:
            print("La lista está vacía")
        else:
            print("Nombre: ", aux.nombre, "Edad: ", aux.edad)
            while aux.siguiente != None:
                aux = aux.siguiente
                print("Nombre: ", aux.nombre, "Edad: ", aux.edad)

    def eliminar(self):
        aux = self.raiz
        aux2 = self.raiz
        if aux.nombre == None:
            print("No hay elementos que se puedan eliminar")
        else:
            elemento = input("Escriba el nombre a eliminar: ")
            if aux.nombre == elemento:
                if aux.siguiente == None:
                    self.raiz = Nodo()
                else:
                    self.raiz= aux.siguiente
            else:
                t = True
                while aux.siguiente != None and t:
                    aux = aux.siguiente
                    if aux.nombre == elemento:
                        aux2.siguiente = aux.siguiente
                        aux = None
                        t = False
                        break
                    aux2 = aux2.siguiente
                if t == True:
                    print("Nombre no encontrado")

class Principal:
    lista = Lista()
    while True:
        print("***Menu***")
        print("1.- Insertar")
        print("2.- Consultar")
        print("3.- Eliminar")
        print("4.- Salir")
        try:
            opcion = int(input("Elige tu opción: "))
            if opcion == 1:
                nodo = Nodo()
                nodo.nombre = input("Escribe tu nombre: ")
                nodo.edad = input("Escribe tu edad: ")
                lista.insertar(nodo)
            elif opcion == 2:
                lista.consultar()
            elif opcion == 3:
                lista.eliminar()
            elif opcion == 4:
                break
        except:
            orint("Ocurrió un error")