#!/usr/bin/env python
# -*- coding: utf-8 -*-

"""
Exercicio 4. Realiza unha aplicación co seguinte menú:

a) Ingresar datos alumno

b) Eliminar datos alumno

Débese mostrar unha lista de alumnos nun menú e seleccionar o alumno a eliminar segundo o índice co seguinte formato: indice. apelidos_alumno, nome: nota.
c) Modificar nota alumno

Débese mostrar unha lista de alumnos nun menú e seleccionar o alumno a modificar a nota o índice co seguinte formato: indice. apelidos_alumno, nome: nota.
d) Ver nomes e apelidos de alumnos aprobados

Débese mostrar co seguinte formato: indice. apelidos_alumno, nome: nota
e) Mostra alumnos alfabeticamente:

Débese mostrar co seguinte formato: indice. apelidos_alumno, nome: nota
Podes adaptar o algoritmo de ordenación da tarefa anterior.
f) Ver a nota media.

g) Sair.

Para cada alumno necesitaremos gardar os seguintes datos:

Nome
Apelidos
Nota con decimais.
Axuda:

A información de cada alumno almacenarase nun dicionario.
Para gardar a información de cada alumno utilizaremos unha lista.
"""

__author__ = "Brais Pose Nieto"

lista = []

def mostrar(lista:list):
    """
    Muestra os alumnos da lista co seu índice, apelidos, nome e nota.

    Args:
        lista (list): Lista de alumnos, onde cada alumno é un dicionario que debe
                      conter as chaves "apelidos", "nome" e "nota".
    """
    for i, alumno in enumerate(lista):
        print(f"{i}. {alumno['apelidos']}, {alumno['nome']}: {alumno['nota']:.2f}")

def ingresar_datos(nome:str, apelidos:str, nota:float, lista:list):
    """
    Engade un alumno á lista de alumnos.

    Args:
        nome (str): Nome do alumno.
        apelidos (str): Apelidos do alumno.
        nota (float): Nota do alumno (0-10).
        lista (list): Lista onde se engade o alumno.

    Raises:
        ValueError: Se os datos non son válidos.
    """
    if not type(nome) == str:
        raise ValueError
    elif not type(apelidos) == str:
        raise ValueError
    elif not type(nota) == float:
        raise ValueError
    if nota < 0 or nota > 10:
        raise ValueError
    alumno = {"nome" : nome, "apelidos" : apelidos, "nota" : nota}
    lista.append(alumno)

def eliminar_alumno(indice:int ,lista:list):
    """
    Elimina un alumno da lista segundo o índice.

    Args:
        indice (int): Índice do alumno a eliminar.
        lista (list): Lista de alumnos.

    Raises:
        ValueError: Se o índice non é válido.
    """
    if not type(indice) == int:
        raise ValueError
    if not 0 <= indice < len(lista):
        raise ValueError

    del lista[indice]

def modificar_datos(indice:int, lista:list, nova_nota:float):
    """
    Modifica a nota dun alumno segundo o índice.

    Args:
        indice (int): Índice do alumno.
        lista (list): Lista de alumnos.
        nova_nota (float): Nova nota para o alumno (0-10).

    Raises:
        ValueError: Se o índice ou a nota non son válidos.
    """
    if not type(indice) == int:
        raise ValueError
    if not type(nova_nota) == float:
        raise ValueError
    if not 0 <= indice < len(lista):
        raise ValueError
    if not 0 <= nova_nota <= 10:
        raise ValueError

    lista[indice]["nota"] = nova_nota
        

def ver_aprobados(lista: list):
    """
    Obtén unha lista de alumnos aprobados (nota >= 5).

    Args:
        lista (list): Lista de alumnos, onde cada alumno é un dicionario
                      que debe conter, polo menos, a chave "nota".

    Returns:
        list: Lista de alumnos aprobados, onde cada alumno é un dicionario.
              A lista devolta contén só os alumnos que teñen unha nota >= 5.
    """
    aprobados = []
    for alumno in lista: 
        if alumno["nota"] >= 5:
            aprobados.append(alumno)
    
    return aprobados

def ordenar_alumnos(lista: list):
    """
    Ordena a lista de alumnos alfabeticamente por apelidos e nome.

    Args:
        lista (list): Lista de alumnos, onde cada alumno é un dicionario
                      que debe conter as chaves "apelidos" e "nome".

    Returns:
        list: Lista de alumnos ordenada alfabéticamente, primeiro polos apelidos
              e, en caso de empate, polo nome.
    """
    while True:
        intercambiado = False
        
        for i, actual in enumerate(lista[:-1]):
            seguinte = lista[i + 1]
            
            
            if (actual["apelidos"] > seguinte["apelidos"] or (actual["apelidos"] == seguinte["apelidos"] and actual["nome"] > seguinte["nome"])):
                lista[i], lista[i + 1] = lista[i + 1], lista[i]
                intercambiado = True
        
        if not intercambiado:
            break
    
    return lista

def nota_media(lista: list):
    """
    Calcula a nota media dos alumnos.

    Args:
        lista (list): Lista de alumnos, onde cada alumno é un dicionario que debe
                      conter a chave "nota".

    Returns:
        float: A nota media calculada. Se a lista está baleira, devolve 0.
    """
    if len(lista) == 0:
        return 0
    total = 0
    for alumno in lista:
        total += alumno["nota"]
    return total / len(lista)

while True:
    print("a) Ingresar datos alumno")
    print("b) Eliminar datos alumno")
    print("c) Modificar nota alumno")
    print("d) Ver nomes e apelidos de alumnos aprobados")
    print("e) Mostrar alumnos alfabéticamente")
    print("f) Ver a nota media")
    print("g) Sair")
    opcion = input("-> ")

    if opcion == "a":
        try:
            nome = str(input("Nome: "))
            apelidos = str(input("Apelidos: "))
            nota = float(input("Nota: "))
            ingresar_datos(nome, apelidos, nota, lista)
        except ValueError:
            print("Os datos introducidos non son válidos")

    elif opcion == "b":
        try:
            print("Alumnos:")
            mostrar(lista)
            indice = int(input("Alumno a eliminar: "))
            eliminar_alumno(indice, lista)
        except ValueError:
            print("Os datos introducidos non son válidos")
    
    elif opcion == "c":
        try:
            print("Alumnos:")
            mostrar(lista)
            indice = int(input("Alumno a modificar: "))
            nova_nota = float(input("Nova nota: "))
            modificar_datos(indice, lista, nova_nota)
        except ValueError:
            print("Os datos introducidos non son válidos")

    elif opcion == "d":
        try:
            aprobados = ver_aprobados(lista)
            mostrar(aprobados)
        except ValueError:
            print("Houbo un erro coa recopilación dos alumnos aprobados")
    elif opcion == "e":
        try:
            print("Alumnos ordenados alfabeticamente:")
            ordenar_alumnos(lista)
            mostrar(lista)
        except ValueError:
            print("Houbo un erro coa ordenación dos alumnos")

    elif opcion == "f":
        try:
            media = nota_media(lista)
            media_decimal = ord(media, 2)
            print("A nota media é:", media_decimal)
        except ValueError:
            print("Houbo un erro co calculo da media")
        
    elif opcion == "g":
        print("Saindo do programa...")
        break