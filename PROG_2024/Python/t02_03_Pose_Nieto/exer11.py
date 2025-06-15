#!/usr/bin/env python
# -*- coding: utf-8 -*-

"""
Exercicio 11 Escribe un script que calcule o mínimo común múltiplo 
de dous números introducidos polo usuario.
"""

__author__ = "Brais Pose Nieto"

num_1 = int(input("Introduce o primeiro número -> "))
num_2 = int(input("Introduce o segundo número -> "))

mcm = 1

# Prueba números hasta encontrar el mínimo común múltiplo (MCM)
while not (mcm % num_1 == 0 and mcm % num_2 == 0):
    mcm += 1  

print(f"O mínimo común múltiplo (MCM) de {num_1} e {num_2} é: {mcm}")
