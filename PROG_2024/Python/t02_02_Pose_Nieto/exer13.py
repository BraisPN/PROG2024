#!/usr/bin/env python
# -*- coding: utf-8 -*-

"""
Exercicio 13. Escribe un script que calcule o salario dun traballador. O programa recibirá as horas traballadas ao día e os € por hora dese traballo por parte do usuario. 
A continuación preguntaralle ao usuario se a tarifa é en bruto ou en neto. A partir da súa resposta calcula o salario mensual neto.
 - Os días laborables ao mes son 22.
 - Se o usuario indica que o custe da hora é en bruto, indícalle ao usuario que introduza o IRPF en tanto por cen para poder calcularlle o salario neto.
"""

__author__ = "Brais Pose Nieto"

# Pedimos todos os datos
horas = float(input("Horas trabajadas al dia: "))
eur_x_hora = float(input("Euros por hora de trabajo: "))

print("A tarifa é en bruto ou en neto?(bruto/neto)")
tipo = input("")

# Calculamos o salario bruto mensual
salario_bruto = horas * eur_x_hora * 22
round_salario_bruto = round(salario_bruto, 2)
if tipo == "bruto":
    irpf = float(input("Introduza o IRPF en tanto por cen (por exemplo: 20 para 20%) "))
    salario_neto =   salario_bruto * (1 - irpf / 100)
    round_salario_neto = round(salario_neto, 2)
    print(f"O salario neto mensual é: {round_salario_neto} euros")

elif tipo == "neto":
    print(f"O salario neto mensual é: {round_salario_bruto} euros")

# Por se o usuario escribe algo diferente das opcións dadas
else:
    print("Por favor, escolla unha opción valida")