#!/usr/bin/env python
# -*- coding: utf-8 -*-

"""
Exercicio 5: Escribe un script que faga o cambio de divisas tanto de euros a libras e viceversa. 
Crea un menú para que o usuario escolla o cambio que desexa realizar.
"""

__author__ = "Brais Pose Nieto"

def euros_to_libras(euros: float) -> float:
    """
    Convierte euros a libras usando a taxa de cambio.

    Args:
        euros (float): Cantidade en euros a converter.

    Returns:
        float: Cantidade correspondente en libras, redondeada a 2 decimais.
    """
    # Convertimos euros a libras usando a taxa de cambio
    libras = euros * 1.1
    round_libras = round(libras, 2)
    return round_libras

def libras_to_euros(libras: float) -> float:
    """
    Convierte libras a euros usando a taxa de cambio.

    Args:
        libras (float): Cantidade en libras a converter.

    Returns:
        float: Cantidade correspondente en euros, redondeada a 2 decimais.
    """
    # Convertimos libras a euros usando a taxa de cambio
    euros = libras / 1.1
    round_euros = round(euros, 2)
    return round_euros

# Mostramos o menú de opcións
print("Escolla o tipo de cambio que desea realizar (1/2): ")
print("1 - Euros a Libras")
print("2 - Libras a Euros")
opcion = input("")

if opcion == "1":
    euros = float(input("Escolla a cantidade en euros -> ")) 
    libras = euros_to_libras(euros)
    print(f"Son {libras} libras")

elif opcion == "2":
    libras = float(input("Escolla a cantidade en libras -> "))
    euros = libras_to_euros(libras)
    print(f"Son {euros} euros")

else:
    # Se o usuario introduce unha opción inválida
    print("Opción non válida. Por favor, escolla 1 ou 2.")
