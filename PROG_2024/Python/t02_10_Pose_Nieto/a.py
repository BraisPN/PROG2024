# Representación de la calculadora en filas
fila1 = [7, 8, 9]
fila2 = [4, 5, 6]
fila3 = [1, 2, 3]

def obtener_opciones(fila1, fila2, fila3, numeros_usados, num_anterior):
    """Dado el número anterior, calcula las opciones válidas."""
    if num_anterior in fila1:
        fila_actual = fila1
    elif num_anterior in fila2:
        fila_actual = fila2
    elif num_anterior in fila3:
        fila_actual = fila3
    else:
        # Si no hay número anterior, devolver todos los números iniciales
        return [num for fila in [fila1, fila2, fila3] for num in fila if num not in numeros_usados]

    opciones = []

    # Opciones de la misma fila
    for num in fila_actual:
        if num not in numeros_usados:
            opciones.append(num)

    # Opciones de la misma columna
    posicion = fila_actual.index(num_anterior)  # Columna en la fila
    for fila in [fila1, fila2, fila3]:
        if fila[posicion] not in numeros_usados:
            opciones.append(fila[posicion])

    # Eliminar duplicados
    return list(set(opciones))

def turno_xogador_manual(valor_actual, numeros_usados, num_anterior, fila1, fila2, fila3):
    """Permite al jugador introducir manualmente un número válido."""
    opciones = obtener_opciones(fila1, fila2, fila3, numeros_usados, num_anterior)
    print(f"Opciones válidas: {opciones}")

    while True:
        try:
            num_jugador = int(input("Elige un número de las opciones válidas: "))
            if num_jugador in opciones:
                return num_jugador
            else:
                print("Número no válido. Elige uno de las opciones válidas.")
        except ValueError:
            print("Entrada no válida. Introduce un número.")

def turno_oponente(valor_actual, numeros_usados, num_anterior, fila1, fila2, fila3):
    """Simula el turno del oponente seleccionando el mejor número posible."""
    opciones = obtener_opciones(fila1, fila2, fila3, numeros_usados, num_anterior)
    print(f"Opciones del oponente: {opciones}")

    # Escoge la mejor opción (la más baja que no lleve a 31 o más)
    mejor_opcion = None
    for opcion in sorted(opciones):
        if valor_actual + opcion < 31:
            mejor_opcion = opcion
            break
    # Si no hay una opción segura, toma la menor posible
    if mejor_opcion is None:
        mejor_opcion = min(opciones)

    return mejor_opcion

# Ejemplo de uso paso a paso
valor_actual = 0
numeros_usados = []
num_anterior = None  # Primer turno no tiene número anterior

# Simulación de turnos
print("¡Comienza el juego!")

while valor_actual < 31:
    print(f"\nValor actual: {valor_actual}")
    print(f"Números usados: {numeros_usados}")

    # Turno del jugador
    print("Turno del jugador...")
    num_jugador = turno_xogador_manual(valor_actual, numeros_usados, num_anterior, fila1, fila2, fila3)
    valor_actual += num_jugador
    numeros_usados.append(num_jugador)
    print(f"El jugador selecciona: {num_jugador}")

    if valor_actual >= 31:
        print("¡El jugador pierde! Valor acumulado llegó a 31 o más.")
        break

    # Turno del oponente
    print("Turno del oponente...")
    num_anterior = turno_oponente(valor_actual, numeros_usados, num_jugador, fila1, fila2, fila3)
    valor_actual += num_anterior
    numeros_usados.append(num_anterior)
    print(f"El oponente selecciona: {num_anterior}")

    if valor_actual >= 31:
        print("¡El oponente pierde! Valor acumulado llegó a 31 o más.")
        break
