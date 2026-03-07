class Nodo:
    def __init__(self, valor):
        self.hijoIzq = None
        self.hijoDer = None
        self.val = valor
    
class Arbol:
    def __init__(self):
        self.raiz = None

    def obtenerRaiz(self):
        return self.raiz

    def agregar(self, val):
        if(self.raiz == None):
            self.raiz = Nodo(val)
        else:
            self.agregarNodo(val, self.raiz)

    def agregarNodo(self, val, nodo):
        if(val < nodo.val):
            if(nodo.hijoIzq != None):
                self.agregarNodo(val, nodo.hijoIzq)
            else:
                nodo.hijoIzq = Nodo(val)
        else:
            if(nodo.hijoDer != None):
                self.agregarNodo(val, nodo.hijoDer)
            else:
                nodo.hijoDer = Nodo(val)
    
    def _inOrden(self, nodo):
        if(nodo != None):
            self ._inOrden(nodo.hijoIzq)
            print(str(nodo.val))
            self ._inOrden(nodo.hijoDer)
            
    def imprimeInOrden(self):
        if(self.raiz != None):
            self._inOrden(self.raiz)

    def _posOrden(self, nodo):
        if(nodo != None):
            self._posOrden(nodo.hijoIzq)
            self._posOrden(nodo.hijoDer)
            print(str(nodo.val))

    def imprimePosOrden(self):
        if(self.raiz != None):
            self._posOrden(self.raiz)

class Controladora:
    def main(self):
        nodos = [8, 10, 3, 1, 6, 4, 7, 14, 13]
        arbol = Arbol()

        for i in nodos:
            arbol.agregar(i)

        print("Recorrido Inorden: ")
        arbol.imprimePosOrden()

c = Controladora()
c.main()