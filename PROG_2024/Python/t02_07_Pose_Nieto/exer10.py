#!/usr/bin/env python
# -*- coding: utf-8 -*-

"""
Exercicio 10. O algoritmo de ordenación que se describe a continuación permite ordenar unha lista de xeito simple pero ineficiente para listas pequenas. 
Funciona comparando elementos adxacentes na lista e intercambiándoos se están na orde incorrecta (é dicir, se o primeiro elemento é maior que o segundo). 
Este proceso repítese varias veces ata que toda a lista estea ordenada. 
É dicir, realízanse varias pasadas sobre a lista para ordenala ata que non se produza ningún intercambio de posicións.

Escribe unha función en Python ordenar(lista: List) -> List que implante o algoritmo de ordenación descrito anteriormente para unha lista de números de menor a maior.

Aquí temos un exemplo:

# Proba con estes datos:
lista = [64, 34, 25, 12, 22, 11, 90]
# saída esperada: [11, 12, 22, 25, 34, 64, 90]
"""

__author__ = "Brais Pose Nieto"

def ordenar(lista):
    """
    Ordena unha lista de números de menor a maior utilizando o algoritmo de ordenación por burbuxa.
    
    O algoritmo percorre repetidamente a lista, comparando elementos adxacentes e intercambiándoos se están desordenados.
    Este proceso repítese ata que a lista está completamente ordenada, esgotando as pasadas cando non se realizan máis intercambios.
    
    Args:
    lista (list): Lista de números a ordenar.
    
    Returns:
    list: A lista ordenada de menor a maior.
    """
    
    while True:
        intercambiado = False 
        
        # Itera sobre a lista (excepto o último elemento, xa que se compara co seguinte)
        for i, actual in enumerate(lista[:-1]):  # Utiliza enumerate para obter índices e valores
            novo = lista[i + 1]  # Colle o seguinte elemento á dereita
            
            if actual > novo:
                lista[i], lista[i + 1] = lista[i + 1], lista[i]  # Intercambia os valores
                intercambiado = True  # Indica que se fixo un intercambio
        
        # Se non se fixeron intercambios, a lista está ordenada e saímos do bucle
        if not intercambiado:
            break
    
    return lista 

lista = [64, 34, 25, 12, 22, 11, 90]
print("Lista ordenada:", ordenar(lista))