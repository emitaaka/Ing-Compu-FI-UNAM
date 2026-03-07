def count_sort(A):
    M = max(A)
    C = [0] * (M + 1)

    for num in A:
        C[num] += 1
    
    for i in range(1, M + 1):
        C[i] += C[i - 1]

    B = [0] * len(A)
    for i in range(len(A) - 1, -1, -1):
        B[C[A[i]] - 1] = A[i]
        C[A[i]] -= 1
    
    return B

A = [2, 5, 3, 0, 2, 3, 0, 3]

B = count_sort(A)
for num in B:
    print(num, end = " ")