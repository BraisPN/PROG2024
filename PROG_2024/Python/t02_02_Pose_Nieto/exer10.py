#!/usr/bin/env python
# -*- coding: utf-8 -*-


"""
Exercicio 10. Escribe un script que pide ao usuario por teclado os coeficientes dunha ecuación de segundo grao e calcula a solución. 
Comproba se hai unha solución, dúas ou ningunha. Dependendo do caso, mostra as solucións que corresponda.
"""

__author__ = "Brais Pose Nieto"

# La formula es la siguiente ax2+bx+c=0 -> (-b + (b**2 - 4*a*c)**0.5) / (2*a)

# Solicitamos los coeficientes
a = float(input("Escriba o primeiro coeficiente "))
b = float(input("Escriba o segundo coeficiente "))
c = float(input("Escriba o terceiro coeficiente "))

discriminante = b**2 - 4*a*c

if discriminante > 0:
    resultado1 = (-b + (discriminante**0.5)) / (2 * a)
    resultado2 = (-b - (discriminante**0.5)) / (2 * a)
    print("As solucións son:" + resultado1 +" y " +resultado2)
elif discriminante == 0:
    resultado = -b / (2 * a)
    print(f"A solución é {resultado}")
else:
    print("Non hai solucións")