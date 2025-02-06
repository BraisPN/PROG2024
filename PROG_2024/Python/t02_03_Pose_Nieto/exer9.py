#!/usr/bin/env python
# -*- coding: utf-8 -*-

"""
Exercicio 9 Escribe un script que permita 
obter o factorial dun número enteiro positivo introducido por teclado.
"""

__author__ = "Brais Pose Nieto"

n = int(input("Introduzca un número enteiro positivo: "))

# Inicializa el contador en 1 y el resultado del factorial en 1.
contador = 1
factorial = 1

if n > 0:

    while contador <= n:
        # Multiplica el contador por el valor actual de factorial.
        factorial = contador * factorial
        
        contador += 1

    print("O resultado é ->", factorial)

# Si el número es menor o igual a 0, se muestra un mensaje de error.
else:
    print("Por favor introduzca un número positivo")
