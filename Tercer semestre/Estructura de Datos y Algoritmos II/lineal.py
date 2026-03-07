def busquedaLineal(A, n, x):
    encontrado = -1
    for k in range(n + 1):
        if A[k] == x:
            encontrado = k
    return encontrado

A = [1, 4, 6, 8, 9, 11]
print(busquedaLineal(A, 5, 8))