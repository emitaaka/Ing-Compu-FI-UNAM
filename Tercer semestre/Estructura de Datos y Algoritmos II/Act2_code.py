def count_sort(A):
    M = max(A)
    C = [0] * (M + 1)
    
    for num in A:
        C[num] += 1


    for i in range(M - 1, -1, -1):  
        C[i] += C[i + 1]  




    B = [0] * len(A)
    for i in A:
        B[C[i] - 1] = i
        C[i] -= 1

    return B

A = [23, 20, 19, 18, 13, 12, 9, 7, 6, 5, 4, 3, 2, 1, 0]
print("Arreglo original:")
print(A)

B = count_sort(A)

print("Arreglo ordenado")
for num in B:
    print(num, end= " ")