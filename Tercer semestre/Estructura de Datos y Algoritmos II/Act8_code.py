import random
from collections import Counter, defaultdict

def ordenar_por_frecuencia(arr):
    """Versión más eficiente usando Counter"""
    counter = Counter(arr)
    
    first_occurrence = {}
    for i, num in enumerate(arr):
        if num not in first_occurrence:
            first_occurrence[num] = i
    
    sorted_items = sorted(counter.items(), 
                         key=lambda x: (-x[1], first_occurrence[x[0]]))
    
    resultado = []
    for num, freq in sorted_items:
        resultado.extend([num] * freq)
    
    return resultado

if __name__ == "__main__":
    arr = [2, 5, 2, 8, 5, 6, 8, 8]
    
    print("Entrada:", arr)
    print("Salida:", ordenar_por_frecuencia(arr))
    
    arr_grande = [random.randint(-1000, 1000) for _ in range(100000)]
    
    import time
    start = time.time()
    resultado = ordenar_por_frecuencia(arr_grande)
    end = time.time()
    
    print(f"\nTiempo para 100,000 elementos: {end - start:.4f} segundos")
    print("Primeros 10 elementos:", resultado[:10])