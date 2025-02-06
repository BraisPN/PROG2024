#!/usr/bin/env python
# -*- coding: utf-8 -*-

"""
Exercicio 18. Escribe un script que pida ao usuario 3 números e móstralle por pantalla a media dos 3 números.

"""

__author__ = "Brais Pose Nieto"

# Solicitamos los numeros
a = int(input("Escriba o primeiro numero "))
b = int(input("Escriba o segundo numero "))
c = int(input("Escriba o terceiro numero "))

# Calculamos la media
resultado = (a + b + c)/3

print("La media es:", resultado)