#!/usr/bin/env python
# -*- coding: utf-8 -*-

"""
Exercicio 15. Escribe un script que pida ao usuario os coeficientes dunha ecuación de segundo grao 
e calcula as dúas solucións. Mostra as dúas solucións por pantalla.

"""

__author__ = "Brais Pose Nieto"

# La formula es la siguiente ax2+bx+c=0 -> (-b + (b**2 - 4*a*c)**0.5) / (2*a)

# Solicitamos los coeficientes
a = int(input("Escriba o primeiro coeficiente "))
b = int(input("Escriba o segundo coeficiente "))
c = int(input("Escriba o terceiro coeficiente "))


# Aplicamos la formula
resultado1 = (-b + (b**2 - 4*a*c)**0.5) / (2*a)
resultado2 = (-b - (b**2 - 4*a*c)**0.5) / (2*a)


print("El primer resultado es", resultado1)
print("El segundo resultado es", resultado2)