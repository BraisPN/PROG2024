#!/usr/bin/env python
# -*- coding: utf-8 -*-

"""
Exercicio 5. Crea nun script unha función recursiva: anagrama(palabra1: str, palabra2: str) -> boolean 
que indique se unha das palabras é ou non un anagrama da outra, é dicir, que se pode obter a partir das letras da outra sen máis que reordenalas.

Considerarase que as palabras están escritas en minúsculas, sen til nin outros signos diacríticos e sen espazos en branco ou outros caracteres distintos dos alfabéticos da “A” á “Z”.

Se as dúas palabras son iguais tamén se considera que son anagrama.

Nese mesmo script proba a función obtendo unha palabra por teclado e mostra por pantalla Anagrama se é un anagrama e Non anagrama en caso contrario.
"""

__author__ = "Brais Pose Nieto"

def anagrama(palabra1: str, palabra2: str) -> bool:
    """
    Verifica recursivamente si una palabra es un anagrama de otra.

    Parámetros:
    palabra1 (str): La primera palabra a comparar.
    palabra2 (str): La segunda palabra a comparar.

    Retorna:
    bool: True si palabra1 es un anagrama de palabra2, False en caso contrario.

    Excepciones:
    ValueError: Si las entradas no son cadenas de caracteres o están vacías.
    """
    if not type(palabra1) and not type(palabra2) == str:
        raise ValueError
    
    if len(palabra1) == 0 and len(palabra2) == 0:
        raise ValueError
    
    if palabra1 == palabra2:
        return True


    if len(palabra1) == len(palabra2):
        if palabra1[0] in palabra2:
            nova_palabra2 = ""
            encontrada = False
            for c in palabra2:
                if c == palabra1[0] and not encontrada:
                    encontrada = True
                else:
                    nova_palabra2 += c

        return anagrama(palabra1[1:], nova_palabra2)

    return False

palabra1 = str(input("Primeira palabra: "))
palabra2 = str(input("Segunda palabra: "))

try:
    if anagrama(palabra1, palabra2) == True:
        print("Son anagramas")
    else:
        print("Non son anagrama")
except:
    print("Por favor, introduza caracteres válidos.")
