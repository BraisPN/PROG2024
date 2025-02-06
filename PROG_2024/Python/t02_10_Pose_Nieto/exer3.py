#!/usr/bin/env python
# -*- coding: utf-8 -*-

"""
Exercicio 3. Pasa a calculadora! é un xogo para dúas persoas no que se comeza cunha calculadora e cada xogador, de xeito alterno, 
suma un número novo, dun só díxito, ao valor acumulado ata o momento, comezando en 0. 
O xogador que, tras sumar o seu número, chegue a un resultado maior ou igual a 31 perde.

Ademais, en cada turno un xogador só pode utilizar os números situados na mesma fila ou columna que o díxito marcado polo seu opoñente no turno anterior, 
pero non pode repetir o número. Evidentemente, o número 0 non se pode utilizar nunca.

Por exemplo, imaxina que, durante unha partida, un xogador recibe aa calculadora mostrándolle o número 28, e o opoñente acaba de introducir o número 9. 
A partir da disposición dos números da calculadora, sabemos que nesta quenda unicamente poderá xogar os números 3, 6, 7 y 8:
"""

__author__ = "Brais Pose Nieto"


def insertar_datos(numero:int,lista:list):
    numero = input("Inserte un numero: ")
    if not type(numero) == int:
        raise ValueError
    if not numero in lista:
        raise ValueError
    if not type(lista) == list:
        raise ValueError
    
    return numero

def calculadora(lista:list, numero:int, opciones:list):
    opciones = []
    numero = insertar_datos(lista,numero)

    if numero in lista[0]:

        for i in lista[0]:
            opciones.append(i)
        opciones.append(lista[0])
        opciones.pop[numero]
        print(opciones)
    elif numero in lista[1]:

        for i in lista[1]:
            opciones.append(i)

    elif numero in lista[2]:

        for i in lista[2]:
            opciones.append(i)





lista = [[7, 8, 9], [4, 5, 6], [1, 2, 3]]

sum = 0
numero = insertar_datos()
sum += numero
