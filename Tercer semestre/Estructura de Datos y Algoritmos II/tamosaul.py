class Vertice:
    def __init__(self, n):
        self.nombre = n
        self.vecinos = list()
        self.d = 0
        self.f = 0
        self.color = 'white'
        self.pred = None

    def agregarVecino(self, v):
        if v not in self.vecinos:
            self.vecinos.append(v)
            self.vecinos.sort()

class Grafo:
    def __init__(self):
        self.vertices = {}
        self.tiempo = 0

    def agregarVertice(self, vertice):
        if isinstance(vertice, Vertice) and vertice.nombre not in self.vertices:
            self.vertices[vertice.nombre] = vertice
            return True
        else:
            return False

    def agregarArista(self, u, v):
        if u in self.vertices and v in self.vertices:
            self.vertices[u].agregarVecino(v)
            self.vertices[v].agregarVecino(u)
            return True
        else:
            return False

    def imprimeGrafo(self):
        for key in sorted(list(self.vertices.keys())):
            print("Vertice " + key)
            print("Descubrimiento/Termino: " + str(self.vertices[key].d) + "/" + str(self.vertices[key].f))

    def dfs(self, start_node):  # Added start_node argument
        global tiempo
        tiempo = 0

        # Reset colors and predecessors
        for u in self.vertices:
            self.vertices[u].color = 'white'
            self.vertices[u].pred = None

        # Explicitly start DFS from the specified node
        if start_node in self.vertices:
            self.dfsVisitar(self.vertices[start_node])

        # Visit any remaining disconnected components
        for u in sorted(list(self.vertices.keys())):
            if self.vertices[u].color == 'white':
                self.dfsVisitar(self.vertices[u])

    def dfsVisitar(self, vert):
        global tiempo
        tiempo += 1
        vert.d = tiempo
        vert.color = 'gris'

        for v in vert.vecinos:
            if self.vertices[v].color == 'white':
                self.vertices[v].pred = vert.nombre
                self.dfsVisitar(self.vertices[v])

        vert.color = 'black'
        tiempo += 1
        vert.f = tiempo

class Controladora:
    def main(self):
        g = Grafo()

        # Create vertices from '1' to '12'
        for i in range(1, 13):
            g.agregarVertice(Vertice(str(i)))

        # Define the edges
        edges = [('1', '2'), ('1', '4'), ('1', '5'), ('1', '12'),('2', '3'), ('2', '6'), ('2', '11'),('3', '4'), ('3', '7'),('3', '11'), ('4', '8'),('4', '12'), ('5', '6'),
        ('5', '9'), ('6', '10'),('7', '8'),('7', '11'),('8', '12'),('9', '10'), ('9', '12'),('10', '11'),('11', '12')]

        # Add the edges to the graph
        for edge in edges:
            u, v = edge
            g.agregarArista(u, v)

        # Perform DFS, starting from node '1'
        g.dfs('1')

        # Print the graph (adjacency list)
        print('\nGrafo 1\n')
        g.imprimeGrafo()

obj = Controladora()
obj.main()