#!/usr/bin/env python
# -*- coding: utf-8 -*-

"""
Exercicio 8. Crea un script que pida as notas dun exame dos alumnos dunha clase para procesalos. 
Tódalas notas téñense que ir almacenando nunha lista. 
Mostra un menú que se mostre continuamente ata que o usuario seleccione a opción saír.
"""

__author__ = "Brais Pose Nieto"

def engadir_nota(lista: list[float], nota: float):
    """
    Engade unha nova nota á lista de notas despois de comprobar que a nota é válida.
    
    Args:
    lista (list[float]): A lista onde se almacenan as notas.
    nota (float): A nota a engadir, debe estar entre 0 e 10.
    
    Raises:
    ValueError: Se a lista non é do tipo list ou a nota non é un número flotante ou está fora de rango.
    """
    if not type(lista) == list:  # Comproba que a lista sexa un tipo de lista
        raise ValueError
    if not type(nota) == float or nota < 0 or nota > 10:  # Comproba que a nota sexa un número entre 0 e 10
        raise ValueError
    lista.append(nota)  # Engade a nota á lista

def mostrar_notas(lista: list[float]):
    """
    Mostra todas as notas na lista xunto co seu índice.
    
    Args:
    lista (list[float]): A lista das notas a mostrar.
    
    Raises:
    ValueError: Se a lista non é do tipo list.
    """
    if not type(lista) == list:
        raise ValueError
    for indice, valor in enumerate(lista):  # Itera sobre a lista imprimindo cada nota co seu índice
        print(indice, ":" , valor)

def media_notas(lista: list[float]) -> float:
    """
    Calcula e retorna a media das notas na lista.
    
    Args:
    lista (list[float]): A lista das notas.

    Returns:
    float: A media das notas.
    
    Raises:
    ValueError: Se a lista non é do tipo list.
    """
    if not type(lista) == list:
        raise ValueError
    if len(lista) == 0:  # Se a lista está vacía, devolve 0.0
        return 0.0
    suma = 0
    for nota in lista:
        suma += nota
    return suma / len(lista)  # Calcula a media dividiendo a suma das notas entre o número de notas

def numero_aprobados(lista: list[float]) -> int:
    """
    Conta o número de aprobados (notas >= 5) na lista.
    
    Args:
    lista (list[float]): A lista das notas.

    Returns:
    int: O número de aprobados.
    
    Raises:
    ValueError: Se a lista non é do tipo list.
    """
    if not type(lista) == list:
        raise ValueError
    contador = 0
    for nota in lista:
        if nota >= 5:  # Se a nota é maior ou igual a 5, é un aprobado
            contador += 1
    return contador

# Función para obter a máxima nota na lista
def maxima_nota(lista: list[float]) -> float:
    """
    Obtén a máxima nota na lista.
    
    Args:
    lista (list[float]): A lista das notas.

    Returns:
    float: A máxima nota ou None se a lista está vacía.
    
    Raises:
    ValueError: Se a lista non é do tipo list.
    """
    if not type(lista) == list:
        raise ValueError
    if len(lista) == 0:  # Se a lista está vacía, devolve None
        return None
    max = lista[0]
    for nota in lista:
        if nota > max:
            max = nota
    return max 

def eliminar_nota(lista: list[float], indice: int):
    """
    Elimina unha nota na lista dado o seu índice.
    
    Args:
    lista (list[float]): A lista das notas.
    indice (int): O índice da nota a eliminar.

    Raises:
    ValueError: Se a lista non é do tipo list ou o índice non é válido.
    """
    if not type(lista) == list:
        raise ValueError
    if not 0 <= indice < len(lista):  # Comproba que o índice estea dentro do rango válido
        raise ValueError
    del lista[indice]  # Elimina a nota na posición indicada


lista = []

while True:
    print("a) Engadir nota")
    print("b) Ver media")
    print("c) Ver número de aprobados")
    print("d) Ver máxima nota")
    print("e) Eliminar nota")
    print("f) Saír")

    opcion = input("-> ")

    # Executa a acción correspondente dependendo da opción seleccionada
    if opcion == "a":
        try:
            nota = float(input("Introduce a nota (0-10): "))
            engadir_nota(lista, nota)  
            print("Nota engadida correctamente.")
        except ValueError:
            print("Erro: A nota debe ser un número flotante entre 0 e 10.")

    elif opcion == "b":
        try:
            media = media_notas(lista)
            media_r = round(media, 2)  # Redondea a media a 2 decimais
            print(f"A media das notas é: {media_r}")
        except ValueError:
            print("Erro: Non se pode calcular a media. A lista pode estar vacía ou non é válida.")

    elif opcion == "c":
        try:
            aprobados = numero_aprobados(lista)
            print(f"Número de aprobados: {aprobados}")
        except ValueError:
            print("Erro: Non se pode calcular o número de aprobados. A lista pode estar vacía ou non é válida.")

    elif opcion == "d":
        try:
            max_nota = maxima_nota(lista)  
            if max_nota is None:
                print("Non hai notas na lista.")
            else:
                print(f"A máxima nota é: {max_nota}")
        except ValueError:
            print("Erro: Non se pode obter a máxima nota. A lista pode estar vacía ou non é válida.")

    elif opcion == "e":
        try:
            mostrar_notas(lista)
            indice = int(input("Introduce o índice da nota a eliminar: ")) 
            eliminar_nota(lista, indice)
            print("Nota eliminada correctamente.")
        except ValueError:
            print("Erro: O índice non é válido ou a lista está vacía.")

    elif opcion == "f":
        print("Saíndo do programa...") 
        break

    else:
        print("Opción non válida, volve a tentar.")
