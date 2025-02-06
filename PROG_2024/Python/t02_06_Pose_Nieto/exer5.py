#!/usr/bin/env python
# -*- coding: utf-8 -*-

"""
Exercicio 5. O cifrado César é un tipo de cifrado de substitución no que unha letra do texto orixinal é substituída por outra letra que é un número fixo de posicións posteriores no alfabeto.

Por exemplo se o desprazamento é 5, a ‘a’ cifrarase coa ‘f’. Débense ignorar os espazos en branco.

Se nun desprazamento rematan as letras, volverase a comezar polo comezo do alfabeto.

Supoñer que todos os nomes están en minúsculas e están compostos só polas seguintes letras: a, b, c, d, e, f, g, h, i, j, k, l, m, n, o, p, q, r, s, t, u, v, w, x, y, z.

Realiza a implantación deste algoritmo na función cifra_cesar(texto: str, desprazamento: int): str. Recorda que os caracteres diferentes as letras se deben manter. Comproba se o tipo de datos introducidos son válidos, e senón é así lanza unha excepción ValueError.
"""

__author__ = "Brais Pose Nieto"

def cifra_cesar(texto: str, desprazamento: int) -> str:
    """
    Aplica o cifrado César a un texto dado, desprazando cada letra un número fixo de posicións
    no alfabeto. Os caracteres que non son letras minúsculas de 'a' a 'z' mantéñense sen cambio.
    
    Args:
        texto (str): O texto a cifrar. Debe estar en minúsculas e conter só letras de 'a' a 'z'.
        desprazamento (int): O número de posicións para desprazar cada letra no alfabeto.
    
    Returns:
        str: O texto cifrado resultante.
    
    Raises:
        ValueError: Se o tipo de datos introducidos non é válido (texto non é unha cadea ou desprazamento non é un enteiro).
    """
    
    if not type(texto) == str or not type(desprazamento) == int:
        raise ValueError("Introduzca valores válidos")
    
    alfabeto = "abcdefghijklmnopqrstuvwxyz"
    resultado = ""
    
    for char in texto:
        if char in alfabeto:
            # Buscar a posición da letra no alfabeto
            posicion_original = alfabeto.index(char)
            # Calcula a nova posición
            nova_posicion = (posicion_original + desprazamento) % 26
            # Busca a nova letra cifrada e garda en resultado
            resultado += alfabeto[nova_posicion]
        else:
            # Manter os caracteres que non estan no alfabeto (espacios, puntos, etc...)
            resultado += char
    
    return resultado

try:
    texto_original = input("Introduce el texto a cifrar: ")
    desprazamento = int(input("Introduce el desprazamento: "))
    
    texto_cifrado = cifra_cesar(texto_original, desprazamento)
    print("Texto cifrado:", texto_cifrado)

except ValueError as e:
    print("Error:", e)
