#!/usr/bin/env python
# -*- coding: utf-8 -*-

"""
Exercicio 7: Escribe un script que calcule o salario dun traballador.
O programa recibirá por parte do usuario as horas traballadas ao día e os € por cada hora de traballo.
A continuación, preguntaralle ao usuario se a tarifa é en bruto ou en neto.
A partir da súa resposta, calcula o salario mensual neto.

- Os días laborables ao mes son 22.
- Se o usuario indica que o custe da hora é en bruto, indícalle ao usuario que introduza o IRPF en tanto por cen para poder calcularlle o salario neto.
"""

__author__ = "Brais Pose Nieto"

def neto_mensual(horas: float, eur_x_hora: float, irpf: float) -> float:
    """
    Calcula o salario mensual neto a partir do salario bruto e do IRPF.

    Args:
        horas (float): Horas traballadas ao día.
        eur_x_hora (float): Custo por hora de traballo en euros.
        irpf (float): Porcentaxe de IRPF a restar.

    Returns:
        float: Salario neto mensual redondeado a 2 decimais.
    """
    salario_bruto = horas * eur_x_hora * 22
    salario_neto = salario_bruto * (1 - irpf / 100)
    return round(salario_neto, 2)

def bruto_mensual(horas: float, eur_x_hora: float) -> float:
    """
    Calcula o salario bruto mensual a partir das horas traballadas e do custo por hora.

    Args:
        horas (float): Horas traballadas ao día.
        eur_x_hora (float): Custo por hora de traballo en euros.

    Returns:
        float: Salario bruto mensual redondeado a 2 decimais.
    """
    salario_bruto = horas * eur_x_hora * 22
    return round(salario_bruto, 2)

# Solicitamos as horas traballadas e o custo por hora
horas = float(input("Horas traballadas ao día: "))
eur_x_hora = float(input("Euros por hora de traballo: "))

# Preguntamos se a tarifa é en bruto ou en neto
tipo = input("A tarifa é en bruto ou en neto? (bruto/neto) ").strip().lower()

if tipo == "bruto":
    # Se a tarifa é en bruto, solicitamos o IRPF
    irpf = float(input("Introduza o IRPF en tanto por cen (por exemplo: 20 para 20%) "))  # IRPF en %
    neto = neto_mensual(horas, eur_x_hora, irpf)
    print(f"O salario neto mensual é: {neto} euros")

elif tipo == "neto":
    bruto = bruto_mensual(horas, eur_x_hora)
    print(f"O salario bruto mensual é: {bruto} euros")

else:
    print("Por favor, escolla unha opción válida")
