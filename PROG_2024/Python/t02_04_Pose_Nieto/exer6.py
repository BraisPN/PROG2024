#!/usr/bin/env python
# -*- coding: utf-8 -*-

"""
Exercicio 6: Escribe un script que pida o nome de usuario e contrasinal ao usuario. 
Indica se o inicio de sesión é correcto. O nome de usuario correcto sería “python” 
e o contrasinal “pip”. 
"""

__author__ = "Brais Pose Nieto"

def login(usuario: str, contrasinal: str) -> bool:
    """
    Comproba se o usuario e o contrasinal son correctos.

    Args:
        usuario (str): Nome de usuario introducido.
        contrasinal (str): Contrasinal introducido.

    Returns:
        bool: Verdadeiro se o usuario e contrasinal son correctos, falso doutro modo.
    """
    # Comprobamos se o usuario e o contrasinal son correctos
    return usuario == "python" and contrasinal == "pip"

# Mensaxe de inicio de sesión
print("INICIO DE SESIÓN")
usuario = input("Usuario: ")
contrasinal = input("Contrasinal: ")

# Verificamos se o inicio de sesión é correcto
if login(usuario, contrasinal):
    print("Iniciou sesión correctamente") 
else:
    print("O usuario ou contrasinal é incorrecto")
