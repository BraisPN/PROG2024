#!/usr/bin/env python
# -*- coding: utf-8 -*-

"""
Exercicio 19. A avaliación deste módulo é a seguinte: 15% de tarefas, 20% exame teórico e 65% exame práctico. 
Escribe un script que lle pida ao usuario as súas tres notas sobre 10 e indicaralle por pantalla a súa nota final sobre 10.

"""
__author__ = "Brais Pose Nieto"

# Solicitamos as notas
tarefas = float(input("Escriba a nota das tarefas "))
teorico = float(input("Escriba a nota do exame teórico "))
practico = float(input("Escriba a nota do exame práctico "))

# Calculamos a porcentaxe das notas
tarefas15 = tarefas * 0.15
teorico20 = teorico * 0.2
practico65 = practico * 0.65

nota = tarefas15 + teorico20 + practico65

print("A túa nota final e:", nota)



