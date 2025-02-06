def insertar_datos(numero:int,lista:list):
    numero = input("Inserte un numero: ")
    if not type(numero) == int:
        raise ValueError
    if not numero in lista:
        raise ValueError
    if not type(lista) == list:
        raise ValueError
    
    return numero

def calculadora(lista:list, numero:int, opciones:list):
    opciones = []
    numero = insertar_datos(lista,numero)

    if numero in lista[0]:

        for i in lista[0]:
            opciones.append(i)
        opciones.append(lista[0])
        opciones.pop[numero]
        print(opciones)
    elif numero in lista[1]:

        for i in lista[1]:
            opciones.append(i)

    elif numero in lista[2]:

        for i in lista[2]:
            opciones.append(i)

calculadora(lista, numero, opciones)