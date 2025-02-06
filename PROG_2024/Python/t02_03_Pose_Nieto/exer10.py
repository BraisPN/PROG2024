#!/usr/bin/env python
# -*- coding: utf-8 -*-

"""
Exercicio 10 Escribe un script no que o usuario poida introducir números enteiros por teclado ata que teclee a palabra “fin”. 
Tras finalizar a introdución de números, indícalle cal é o número máis pequeno introducido.
"""

__author__ = "Brais Pose Nieto"

# Inicializa la variable como None para que no cuente como numero.
numero_minimo = None

while True:

    entrada = input("Introduce un número (ou 'fin' para terminar): ")
    
    # Si el usuario introduce 'fin', se sale del bucle.
    if entrada == "fin":
        break
    
    # Convierte la entrada a un número entero.
    numero = int(entrada)

    # Guarda solo el numero mas pequeño en cada iteración.
    if numero_minimo is None or numero < numero_minimo:
        numero_minimo = numero

# Después del bucle, si se ha introducido al menos un número, se imprime el número mínimo.
if numero_minimo is not None:
    print(f"O número máis pequeno introducido foi: {numero_minimo}")
