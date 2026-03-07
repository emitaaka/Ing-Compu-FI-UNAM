def formaArreglo(tamano):
    Arr = [None] * tamano
    return Arr

def obtenerLlaveNumerica(llave):
    hash = 0
    for char in str(llave):
        hash += ord(char)
    return hash

def H(llaveN, modulo):
    return llaveN % modulo

def agregar(llave, valor, map, modulo):
    llave_numerica = obtenerLlaveNumerica(llave)
    llave_hash = H(llave_numerica, modulo)
    
    colision = False

    if map[llave_hash] is None:
        map[llave_hash] = [[llave, valor]]
        return colision
    colision = True
    for par in map[llave_hash]:
        if par[0] == llave:
            par[1] = valor
            return False
    
    for j in range(1, modulo):
        llaveh = (llave_hash + j) % modulo
        if map[llaveh] is None:
            map[llaveh] = [[llave, valor]]
            return colision
    
    print("Tabla llena, no se pudo agregar", llave)
    return colision

datos = [
    ("Hola9", "12213299"), ("Hola4", 12213214), ("Hola1", 1221321),
    ("Hola2", 1221322), ("Hola3", 1221323), ("Hola5", 1221325),
    ("Hola6", 1221326), ("Hola7", 1221327), ("Hola8", 1221328),
    ("Hola10", 12213210)]

modulos = [11, 17, 7, 5, 13]

resultados = {}

for modulo_actual in modulos:
    print("\n-Probando con módulo ", modulo_actual)

    mapa = formaArreglo(modulo_actual)
    colisiones_totales = 0

    for llave, valor in datos:
        if agregar(llave, valor, mapa, modulo_actual):
            colisiones_totales += 1
    
    print("Mapa final para módulo ", modulo_actual, ":")

    for i, item in enumerate(mapa):
        print("Índice ", i, ":", item)
    print("Total de Colisiones: ", colisiones_totales)
    resultados[modulo_actual] = colisiones_totales

print("\n\n--- Tabla de resultados ---")
print("Módulo | # de colisiones")
print("------------------------")
for modulo, colisiones in sorted(resultados.items()):
    print(f"{modulo:^6}  | {colisiones:^15}")