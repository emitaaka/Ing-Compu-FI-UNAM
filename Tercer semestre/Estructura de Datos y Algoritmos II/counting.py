def countingSort(A, exp1):
    n = len(A)
    B = [0] * (n)
    C = [0] * (10)

    for i in range(0, n):
        index = (A[i] / exp1)
        C[int(index % 10)] = C[int(index % 10)] + 1

    for i in range(1, 10):
        C[i] = C[i] + C[i - 1]

    i = n - 1
    while i >= 0:
        index = (A[i] / exp1)
        B[C[int(index % 10)] - 1] = A[i]
        C[int(index % 10)] = C[int(index % 10)] - 1
        i -= 1
    
    i = 0
    for i in range(0, len(A)):
        A[i] = B[i]

def radixSort(A):

    max1 = max(A)

    exp = 1
    while max1 / exp > 0:
        countingSort(A, exp)
        exp *= 10

A = [170, 45, 75, 90, 802, 24, 2, 66]

radixSort(A)

for i in  range(len(A)):
    print(A[i])