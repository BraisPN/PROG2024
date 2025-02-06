#!/usr/bin/env python 
# -*- coding: utf-8 -*-

"""
Exercicio 8: A avaliación deste módulo é a seguinte: 
15% de tarefas, 20% exame teórico e 65% exame práctico. 
Escribe un script que lle pedirá ao usuario as súas tres notas sobre 10. 
Indicaralle por pantalla se obtivo Sobresaliente, Notable, Ben, Suficiente ou Insuficiente.

Deduce o número necesario de funcións e defíneas.
"""

__author__ = "Brais Pose Nieto"

def nota_final(tarefas: float, teorico: float, practico: float) -> float:
    """
    Calcula a nota final a partir das notas de tarefas, exame teórico e exame práctico.

    Args:
        tarefas (float): Nota das tarefas (sobre 10).
        teorico (float): Nota do exame teórico (sobre 10).
        practico (float): Nota do exame práctico (sobre 10).

    Returns:
        float: Nota final calculada segundo os pesos establecidos.
    """
    # Calculamos a contribución de cada nota segundo o seu peso
    tarefas15 = tarefas * 0.15
    teorico20 = teorico * 0.2
    practico65 = practico * 0.65
    
    # Sumamos as contribucións para obter a nota final
    nota = tarefas15 + teorico20 + practico65
    return nota

def nota_escrita(nota_num: float) -> str:
    """
    Determina a calificación a partir da nota final.

    Args:
        nota_num (float): Nota final calculada (sobre 10).

    Returns:
        str: Calificación correspondente á nota final.
    """
    # Determinamos a calificación a partir da nota final
    if nota_num <= 10 and nota_num >= 9:
        return "Sobresaliente"
    elif nota_num < 9 and nota_num >= 7:
        return "Notable"
    elif nota_num < 7 and nota_num >= 6:
        return "Ben"
    elif nota_num < 6 and nota_num >= 5:
        return "Suficiente"
    else:
        return "Insuficiente"
        

# Solicitamos as notas ao usuario
tarefas = float(input("Escriba a nota das tarefas: ")) 
teorico = float(input("Escriba a nota do exame teórico: "))
practico = float(input("Escriba a nota do exame práctico: "))

# Calculamos a nota final chamando á función nota_final
nota_num = nota_final(tarefas, teorico, practico)

# Obtemos a calificación correspondente á nota final
nota = nota_escrita(nota_num)

print("A túa nota final é:", nota)
