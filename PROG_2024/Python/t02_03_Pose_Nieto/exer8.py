#!/usr/bin/env python
# -*- coding: utf-8 -*-

"""
Exercicio 8 Escribe un script que reciba un enteiro (n) maior ou igual a 1 
e ofreza o resultado da seguinte suma: 1 + 1/2 + 1/3 + … 1/n
"""

__author__ = "Brais Pose Nieto"

n = int(input("Introduzca un número enteiro: "))

contador = 1
suma = 0

while contador <= n:   

    a = 1 / contador

    # Acumula el valor de 'a' en 'suma'.
    suma += a
    
    # Incrementa el contador en 1 para la siguiente iteración.
    contador += 1

# Imprime el resultado total de la suma.
print(suma)