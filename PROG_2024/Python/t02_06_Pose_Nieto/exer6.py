#!/usr/bin/env python
# -*- coding: utf-8 -*-


"""
Exercicio 6. Realiza a implantación da función descifra_cesar(texto: str, desprazamento: int): str nun script que descifre unha cadea cifrada con cifrado César. 
Lanza tamén excepción ValueError se os argumentos da función son do tipo de datos inválidos.

O propio script debe utilizar dita función para descifrar un texto introducido polo usuario para mostrar o texto descifrado por pantalla. O usuario tamén indicará por teclado o desprazamento.
"""
__author__ = "Brais Pose Nieto"

def descifra_cesar(texto: str, desprazamento: int) -> str:
    """
    Aplica o descifrado César a un texto cifrado, desprazando cada letra un número fixo de posicións
    no alfabeto en dirección contraria ao cifrado. Os caracteres que non son letras minúsculas de 'a' a 'z' mantéñense sen cambio.
    
    Args:
        texto (str): O texto cifrado a descifrar. Debe estar en minúsculas e conter só letras de 'a' a 'z'.
        desprazamento (int): O número de posicións para desprazar cada letra no alfabeto no proceso de descifrado.
    
    Returns:
        str: O texto descifrado resultante.
    
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
            posicion_cifrada = alfabeto.index(char)
            # Calcula a nova posición
            posicion_original = (posicion_cifrada - desprazamento) % 26
            # Busca a nova letra cifrada e garda en resultado
            resultado += alfabeto[posicion_original]
        else:
            # Manter os caracteres que non estan no alfabeto (espacios, puntos, etc...)
            resultado += char
    
    return resultado

try:
    texto_original = input("Introduce el texto a cifrar: ")
    desprazamento = int(input("Introduce el desprazamento: "))
    
    texto_cifrado = descifra_cesar(texto_original, desprazamento)
    print("Texto cifrado:", texto_cifrado)

except ValueError as e:
    print("Error:", e)
