#!/usr/bin/env python
# -*- coding: utf-8 -*-

"""
Exercicio 12. Escribe un script que pida o nome de usuario e contrasinal ao usuario. 
Indica se o inicio de sesión é correcto. O nome de usuario sería “python” e o contrasinal “pip”.
"""

__author__ = "Brais Pose Nieto"

# Pedimos o usuario
print("INICIO DE SESIÓN")
usuario = input("Usuario: ")
contrasinal = input("Contrasinal: ")

if usuario == "python" and contrasinal == "pip":
    print("Iniciou sesión correctamente")
else:
    print("O usuario ou contrasinal é incorrecto")