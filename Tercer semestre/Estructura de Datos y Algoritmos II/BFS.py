class Vertice:
    def __init__(self, n):
        self.nombre = n 
        self.vecinos = list()
        self.distancia = 0
        self.color = 'white'
        self.pred = -1
    
    def agregarVecino(self, v):
        if v not in self.vecinos:
            self.vecinos.append(v)
            self.vecinos.sort()

class Grafo:
    vertices = {}

    def agregarVertice(self, vertice):
        if isinstance(vertice, Vertice) and vertice.nombre not in self.vertices:
            self.vertices[vertice.nombre] = vertice
            return True
        else:
            return False
    
    def agregarArista(self, u, v):
        if u in self.vertices and v in self.vertices:
            for key, value in self.vertices.items():
                if key == u:
                    value.agregarVecino(v)
                if key == v:
                    value.agregarVecino(u)
            return True
        else:
            return False
    
    def bfs(self, vert):
        vert.distancia = 0
        vert.color = 'gris'
        vert.pred = -1
        q = list()

        q.append(vert.nombre)


        while len(q) > 0:
            u = q.pop(0)

            node_u = self.vertices[u]
            for v in node_u.vecinos:
                node_v = self.vertices[v]
                if node_v.color == 'white':
                    node_v.color = 'gris'
                    node_v.distancia = node_u.distancia + 1
                    node_v.pred = node_u.nombre
                    q.append(v)
                self.vertices[u].color = 'black'

    def imprimeGrafo(self):
        print("- GRAFO 5 -")
        for key in sorted(list(self.vertices.keys())):
            print("Vertices " +  key + ". Sus vecinos son " + str(self.vertices[key].vecinos))
            print("Vertices " + key + ". El predecesor es " + str(self.vertices[key].pred))
            print("La distancia de 'a' a " + key + " es: " + str(self.vertices[key].distancia))

class Controladora:
    def main(self):
        g = Grafo()

        a = Vertice('a')

        g.agregarVertice(a)

        for i in range(ord('a'), ord('u')):
            g.agregarVertice(Vertice(chr(i)))
        
        edges = ['ab', 'ad', 'af', 'bc', 'bg', 'cg', 'de', 'dh', 'ef', 'ei', 'eh', 'fj', 'fl', 'gl', 'he', 'hn', 'hs', 'in', 'io', 'jk', 'jo', 'kp', 'kq', 'lm', 'mr', 'no', 'ns', 'ot', 'pq', 'pt', 'qr', 'st']

        for edge in edges:
            g.agregarArista(edge[:1], edge[1:])

        for i in range(ord('a'), ord('u')):
            g.bfs(Vertice(chr(i)))

        g.imprimeGrafo()

obj = Controladora()
obj.main()