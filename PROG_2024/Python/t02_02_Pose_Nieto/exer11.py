#!/usr/bin/env python
# -*- coding: utf-8 -*-

"""
Exercicio 11. Escribe un script que faga o cambio de divisas tanto de euros a libras e viceversa. 
Crea un menú para que o usuario escolla o cambio que desexa realizar e a continuación introducirá o valor da moeda correspondente para realizar o cambio de divisas. 1 € son 1,10 libras.
"""

__author__ = "Brais Pose Nieto"

# Creamos o menu para que o usuario escolla
print("Escolla o tipo de cambio que desea realizar (1/2): ")
print("1 - Euros a Libras")
print("2 - Libras a Euros")
opcion = input("")

# Para cada opción facemos distintas operacións e damos o resultado
if opcion == "1":
    euros = float(input("Escolla a cantidade en euros -> "))
    libras = euros * 1.1
    round_euros = round(euros, 2)
    round_libras = round(libras, 2)
    print(f"{round_euros} euros son {round_libras} libras")

elif opcion == "2":
    libras = float(input("Escolla a cantidade en libras -> "))
    euros = libras / 1.1
    round_euros = round(euros, 2)
    round_libras = round(libras, 2)
    print(f"{round_libras} libras son {round_euros} euros")

# Por se o usuario escollera algo alleo a 1 e 2, que dea un erro
else:
    print("Opción non válida, intente de novo")



