class Nodo:
    def __init__(self, t):
        self.hijos = [None] * (2 * t + 1)
        self.llaves = [None] * (2 * t)
        self.hoja = 1
        self.n = 0
        for k in range(2*t):
            self.llaves.append([None])
        for k in range(2*t+1):
            self.hijos.append([None])

class ArbolB:
    def __init__(self, gradoMinimo):
        self.t = gradoMinimo
        self.raiz = None
        self.bTreeCreate()

    def bTreeCreate(self):
        if(self.raiz == None):
            self.raiz = Nodo(self.t)
        return self.raiz

    def bTreeSplitShild(self, x, i):
        t = self.t
        z = Nodo(t)
        y = x.hijos[i]
        z.hoja = y.hoja
        z.n = self.t - 1

        for j in range(1, t):
            z.llaves[j] = y.llaves[j + t]
            y.llaves[j + t]
            
        if y.hoja == 0:
            for j in range(1, t + 1):
                z.hijos[j] = y.hijos[j + t]
                y.hijos[j + t] = None
        
        y.n = t - 1
        
        for j in range(x.n, i - 1, -1):
            x.hijos[j + 1] = x.hijos[j]
        x.hijos[i + 1] = z

        for j in range(x.n, i - 1, -1):
            x.llaves[j + 1] = x.llaves[j]

        x.llaves[i] = y.llaves[t]
        y.llaves[t] = None
        x.n += 1

    def bTreeInsertNonFull(self, x,  k):
        t = self.t
        i = x.n

        if x.hoja:
            while(i >= 1) and (k < x.llaves[i]):
                x.llaves[i + 1] = x.llaves[i]
                i -= 1
            x.llaves[i + 1] = k
            x.n += 1
        else:
            while(i >= 1) and (k < x.llaves[i]):
                i -= 1
            i += 1
            
            if x.hijos[i].n == 2 * t - 1:
                self.bTreeSplitShild(x, i)
                if k > x.llaves[i]:
                    i += 1

            self.bTreeInsertNonFull(x.hijos[i], k)

    def bTreeInsert(self, nodo, k):
        t = self.t
        r = self.raiz

        if r.n == 2 * t - 1:
            s = Nodo(t)
            self.raiz = s 
            s.hoja = False
            s.n = 0
            s.hijos[1] = r
            self.bTreeSplitShild(s, 1)
            self.bTreeInsertNonFull(s, k)
        else:
            self.bTreeInsertNonFull(r, k)

    def imprimeNodo(self, nodo):
        if not nodo:
            print("El nodo está vacío.")
            return

        letras_del_nodo = []

        for i in range(1, nodo.n + 1):
            
            llave_numerica = nodo.llaves[i]
            letra = chr(llave_numerica)
            letras_del_nodo.append(letra)
        
        print(letras_del_nodo)
    
#    def print_tree(self, nodo, l=0):
#        if nodo:
#            print("  " * l, end="")
#            self.imprimeNodo(nodo)
#            if not nodo.hoja:
#                for i in range(1, nodo.n + 2):
#                    self.print_tree(nodo.hijos[i], l + 1)

class Controladora:
    def main(self):
        BT = ArbolB(2)

        actual = BT.bTreeCreate()

        print("Se insertará B")
        BT.bTreeInsert(actual, ord("B"))

        print("Se insertará T")
        BT.bTreeInsert(actual, ord("T"))
        
        print("Se insertará H")
        BT.bTreeInsert(actual, ord("H"))
        
        print("Imprime raíz")
        BT.imprimeNodo(BT.raiz)

        print("Se insertará M")
        BT.bTreeInsert(actual, ord("M"))

        BT.imprimeNodo(BT.raiz)
        BT.imprimeNodo(BT.raiz.hijos[1])
        BT.imprimeNodo(BT.raiz.hijos[2])

        print("Se insertará O")
        BT.bTreeInsert(actual, ord("O"))

        print("Se insertará C")
        BT.bTreeInsert(actual, ord("C"))

        BT.imprimeNodo(BT.raiz)
        BT.imprimeNodo(BT.raiz.hijos[1])
        BT.imprimeNodo(BT.raiz.hijos[2])

        print("Se insertará Z")
        BT.bTreeInsert(actual, ord("Z"))

        BT.imprimeNodo(BT.raiz)
        BT.imprimeNodo(BT.raiz.hijos[1])
        BT.imprimeNodo(BT.raiz.hijos[2])
        BT.imprimeNodo(BT.raiz.hijos[3])

xd = Controladora()

xd.main()