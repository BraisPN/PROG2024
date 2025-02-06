#!/usr/bin/env python
# -*- coding: utf-8 -*-

"""
Exercicio 17. Escribe un script que pida ao usuario o número de quilómetros 
recorridos na súa última viaxe en coche, o consumo do coche en litros cada 100 quilómetros e o prezo en euros dun litro de combustible. 
Calcula o custo da viaxe e móstrallo ao usuario por pantalla.

"""

__author__ = "Brais Pose Nieto"

# Solicitamos os datos
km = float(input("Escriba os quilómetros da sua ultima viaxe "))
consumo = float(input("Escriba o consumo do seu vehiculo cada 100km "))
prezo = float(input("Escriba o prezo en euros dun litro de combustible "))

# Calculamos con regra de tres canto consumiu na viaxe
consumido = (consumo*km)/100

# Calculamos usan o mesmo metodo o custo do viaxe
custo = (consumido*prezo)

print("O custo da viaxe foi a seguinte:", custo, "euros")