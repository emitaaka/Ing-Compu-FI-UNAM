def intercambia(A, x, y):
    tmp = A[x]
    A[x] = A[y]
    A[y] = tmp

def particionar(A, p, r):
    x = A[r]
    i = p - 1
    for j in range(p, r):
        if (A[j] <= x):
            i += 1
            intercambia(A, i, j)
    intercambia(A, i + 1, r)
    return i + 1

def Quicksort(A, p, r):
    if(p < r):
        q = particionar(A, p ,r)
        Quicksort(A, p, q - 1)
        Quicksort(A, q + 1, r)

A = [10, 80, 30, 90, 40, 50, 70]
Quicksort(A, 0, 6)
print("Arreglo ordenado")
print(A)