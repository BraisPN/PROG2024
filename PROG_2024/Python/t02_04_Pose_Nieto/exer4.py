#!/usr/bin/env python
# -*- coding: utf-8 -*-

"""
Exercicio 4: Escribe un script que pide ao usuario os coeficientes dunha ecuación de segundo grao 
e calcula a solución. Comproba se hai unha solución, dúas ou ningunha. 
Dependendo do caso, mostra as solucións que corresponda.
"""

__author__ = "Brais Pose Nieto"

def descriminante(a: float, b: float, c: float) -> float:
    """
    Calcula o discriminante dunha ecuación de segundo grao.

    Args:
        a (float): Coeficiente cuadrático.
        b (float): Coeficiente lineal.
        c (float): Termo constante.

    Returns:
        float: O valor do discriminante (b^2 - 4ac).
    """
    # Calculamos o discriminante (b^2 - 4ac)
    return b**2 - 4*a*c

def numero_solucions(a: float, b: float, c: float) -> int:
    """
    Determina o número de solucións dunha ecuación de segundo grao.

    Args:
        a (float): Coeficiente cuadrático.
        b (float): Coeficiente lineal.
        c (float): Termo constante.

    Returns:
        int: O número de solucións (0, 1 ou 2).
    """
    # Obtemos o valor do discriminante
    d = descriminante(a, b, c)
    
    # Determinamos o número de solucións baseado no discriminante
    if d > 0:
        return 2
    elif d == 0:
        return 1
    else:
        return 0

def solucion_unica(a: float, b: float) -> float:
    """
    Calcula a solución única dunha ecuación de segundo grao.

    Args:
        a (float): Coeficiente cuadrático.
        b (float): Coeficiente lineal.

    Returns:
        float: A solución única da ecuación.
    """
    # Calculamos a solución única
    return -b / (2 * a)

def calcula_duas_solucions(a: float, b: float, c: float) -> tuple:
    """
    Calcula as dúas solucións dunha ecuación de segundo grao.

    Args:
        a (float): Coeficiente cuadrático.
        b (float): Coeficiente lineal.
        c (float): Termo constante.

    Returns:
        tuple: Unha tupla con as dúas solucións (solución1, solución2).
    """
    # Obtemos o discriminante
    d = descriminante(a, b, c)

    # Calculamos as dúas solucións
    resultado1 = (-b + (d**0.5)) / (2 * a)
    resultado2 = (-b - (d**0.5)) / (2 * a)

    return (resultado1, resultado2)

# Solicitamos os coeficientes da ecuación
a = float(input("Escriba o primeiro coeficiente: "))  # Coeficiente 'a'
b = float(input("Escriba o segundo coeficiente: "))   # Coeficiente 'b'
c = float(input("Escriba o terceiro coeficiente: "))   # Coeficiente 'c'

# Obtemos o número de solucións
num_solucions = numero_solucions(a, b, c)

# Mostramos os resultados baseados no número de solucións
if num_solucions == 2:
    resultado1, resultado2 = calcula_duas_solucions(a, b, c)
    print(f"As solucións son: {resultado1} e {resultado2}")
elif num_solucions == 1:
    resultado = solucion_unica(a, b)
    print(f"A solución é: {resultado}")
else:
    print("Non hai solucións")
