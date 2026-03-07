def heapify(arr, n, i): 
    largest = i
    l = 2 * i + 1
    r = 2 * i + 2

    print("n: ", n)
    print("i: ", i)
    print("larg: ", largest)
    print("l: ", l)
    print("r: ", r)

    if l < n and arr[largest] < arr[l]:
        print(arr[largest], arr[l])
        print("true")
        largest = l
        print("Largest = ", largest)
    else:
        print("false")

    if r < n and arr[largest] < arr[r]:
        print(arr[largest], arr[r])
        print("true")
        largest = r
        print("Largest = ", largest)
    else:
        print("false")
    
    print(largest, " != ", i, "?")
    if largest != i:
        print("true")
        print(arr[i], arr[largest])
        temp = arr[i]
        arr[i] = arr[largest]
        arr[largest] = temp   
        print(arr[i], arr[largest])
    
        heapify(arr, n, largest)
    else:
        print("false")

def heapSort(arr):
    n = len(arr)

    print("primer for:")
    for i in range(n//2 - 1, -1, -1):
        print(arr)
        heapify(arr, n, i)
    
    print("segundo for:")
    for i in range(n - 1, 0, -1):
        arr[i], arr[0] = arr[0], arr[i]
        print(arr)
        heapify(arr, i, 0)

arr = [23, 20, 19, 18, 13, 12, 9, 7, 6, 5, 4, 3, 2, 1, 0]
heapSort(arr)
n = len(arr)
for i in range(n):
    print("%d" % arr[i], end=" ")