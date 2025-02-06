#!/usr/bin/env python
# -*- coding: utf-8 -*-

"""
Exercicio 4. Desenvolva un script para determinar se unha cadea de caracteres (palabra/frase) é palíndromo, é dicir, se se pode ler igual de esquerda a dereita que de dereita a esquerda. 
Un exemplo de palíndromo é a palabra “radar”.

Desenvolva a seguinte función recursiva:

Función palindromo: cos parámetros de entrada que considere preciso para resolver de forma recursiva se unha palabra/frase é palíndromo. 
O valor de retorno será True ou False en función do caso. (Exemplo:“radar” é palíndromo, polo tanto, a función devolverá True).
Nese mesmo script proba a función obtendo unha palabra ou frase por teclado e mostra por pantalla Palídromo se é un palíndromo e Non palíndromo en caso contrario.
"""

__author__ = "Brais Pose Nieto"

def es_palindromo(palabra: str) -> bool:
    """
    Verifica recursivamente si una palabra o frase es un palíndromo.

    Parámetros:
    palabra (str): La palabra o frase a verificar. Debe contener solo letras.

    Retorna:
    bool: True si la palabra es un palíndromo, False en caso contrario.

    Excepciones:
    ValueError: Si la entrada no es una cadena de caracteres o contiene caracteres no alfabéticos.
    """
    if not type(palabra) == str:
        raise ValueError
    
    palabra = palabra.replace(" ","").lower()
    
    for c in palabra:
        if not ('a' <= c <= 'z'):
            raise ValueError
    if len(palabra) <= 1:
        return True
    
    if palabra[0] == palabra[-1]:
        return es_palindromo(palabra[1:-1])
    else:
        return False

try:
    palabra = input("Introduzca unha palabra ou frase: ")

    if es_palindromo(palabra) == True:
        print("É un palíndromo")
    else:
        print("Non é un palíndromo")
except ValueError:
    print("A palabra solo debe conter letras.")