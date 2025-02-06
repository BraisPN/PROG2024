#!/usr/bin/env python
# -*- coding: utf-8 -*-

"""
Exercicio 4. Escribe unha función raiz_cadrada(numero: float/int) -> float nun script que calcule a raíz cadrada dun número. 
Se o parámetro non é un número ou é negativo, lanza unha excepción chamada ValueError. 
O propio script debe recibir un número por parte do usuario e calcula a raíz cadrada dese número utilizando a función creada anteriormente. 
Captura a excepción que lanza a función.
"""

__author__ = "Brais Pose Nieto"


def raiz_cadrada(numero) -> float:
    """
    Calcula a raíz cadrada dun número positivo.

    Args:
        numero (float o int): O número do que se quere calcular a raíz cadrada.
                              Se é unha cadea, debe representar un número válido.

    Returns:
        float: A raíz cadrada do número.

    Raises:
        ValueError: Se o número é negativo ou non é un número válido.
    """
    # Verificación de tipo
    if type(numero) not in (float, int):
        raise ValueError("Introduzca un valor numérico.")
    if numero < 0:
        raise ValueError("O número debe ser positivo.")
    return numero ** 0.5

# Pide un número ao usuario e calcula a raíz cadrada
try:
    numero = input("Introduce un número para calcular a súa raíz cadrada: ")
    resultado = raiz_cadrada(float(numero))
    print(f"A raíz cadrada de {numero} é: {resultado}")
except ValueError as erro:
    print(f"Erro: {erro}")

