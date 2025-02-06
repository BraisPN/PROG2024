#!/usr/bin/env python
# -*- coding: utf-8 -*-

"""
Exercicio 16. Escribe un script que pida ao usuario o seu nome e apelidos por separado 
e mostra a seguinte mensaxe por pantalla:
O usuario <apelido1> <apelido 2>, <nome> rexistrouse correctamente

"""

__author__ = "Brais Pose Nieto"

#Solicitamos os datos con input
nome = input("Escriba o seu nome ")
apelido1 = input("Escriba o seu primeiro apelido ")
apelido2 = input("Escriba o seu segundo apelido ")


print("O usuario", apelido1, apelido2 + ",", nome, "rexistrouse correctamente")