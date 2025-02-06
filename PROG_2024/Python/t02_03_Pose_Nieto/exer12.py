#!/usr/bin/env python
# -*- coding: utf-8 -*-

"""
Exercicio 12 Escribe un script que elixirá no seu comezo un número ao azar entre 1 e 25. 
A continuación o usuario introducirá números por teclado ata que acerte o número seleccionado ao azar. 
Cada vez que se introduza un número incorrecto, o script proporcionaralle pistas ao usuario: “o número e maior” ou “o número é menor”. 
Unha vez que o usuario acerte o número, indicaráselle por pantalla se gañou o xogo ou non. 
Para gañar, o usuario deberá acertar o número en menos de 5 intentos.

Para obter o número ao azar utiliza o seguinte código:

import random
numero_aleatorio = random.randint(1, 25)
"""

__author__ = "Brais Pose Nieto"

import random
numero_aleatorio = random.randint(1, 25)

# Inicializa el contador de intentos en 0.
contador = 0

while True:

    intento = int(input("Introduzca un número do 1 ao 25 -> "))
    # Incrementa el contador de intentos.
    contador += 1
    
    # Comprueba si el intento del usuario es correcto.
    if intento == numero_aleatorio:
        break  # Sale del bucle si el usuario adivina el número.

    elif numero_aleatorio < intento:
        print("O número e menor") 

    elif numero_aleatorio > intento:
        print("O número e maior")

# Después de salir del bucle, comprueba si el usuario ganó.
if contador < 5:
    print("**¡Ganaste!**")
    
else:
    print("Perdiste :(")
