#!/usr/bin/env python 
# -*- coding: utf-8 -*-

"""
Exercicio 9. Vaise realizar un sorteo no que pode haber un número diferente de gañadores a partir dunhas rifas numeradas entre 0001 e 9999.

Este script recibe por teclado o número de premios dispoñibles e imprime os números premiados co formato de 4 díxitos.

Usa a librería `random` para xerar números aleatorios entre 1 e 9999.
"""

__author__ = "Brais Pose Nieto"

def ignorar_repetidos(premiados: list[int], premio: int) -> bool:
    """
    Esta función comproba se un número xa foi premiado.
    Se o número non está na lista de premiados, engádese e retorna `True` (indica que se engadiu un novo premio).
    Se o número xa está na lista, retorna `False` (non engade o número repetido).

    Args:
    premiados (list[int]): A lista de números premiados ata o momento.
    premio (int): O número que se quere comprobar e engadir (se non está repetido).

    Returns:
    bool: `True` se o número foi engadido, `False` se xa estaba na lista.
    """
    if premio not in premiados:  # Se o número non está na lista de premiados
        premiados.append(premio)  # Engádeo á lista de premiados
        return True
    return False


import random

# Solicita ao usuario o número de premios
num_premios = int(input("Numero de premios -> "))

contador = 0 
premiados = [] 


while contador < num_premios:  # Repite ata que se asinen todos os premios
    numero_aleatorio = random.randint(1, 9999)
    if ignorar_repetidos(premiados, numero_aleatorio):  # Se o número non está repetido
        contador += 1  # Incrementa o contador de premios asignados


for premio in premiados: # Imprime os numeros por separado
    print(f"Premiados = {premio:04d}")  # Engade ceros á esquerda ata chegar ás 4 cifras
#!/usr/bin/env python
# -*- coding: utf-8 -*-

"""
Exercicio 9. Vaise realizar un sorteo no que pode haber un número diferente de gañadores a partir dunhas rifas numeradas entre 0001 e 9999. 

Escribe un script que reciba por teclado o número de premios dispoñibles e imprima os números premiados co formato de 4 díxitos.

Para obter un número número ao azar utiliza o seguinte código:

import random

...

numero_aleatorio = random.randint(1, 9999)
"""

__author__ = "Brais Pose Nieto"

def ignorar_repetidos(premiados: list[int], premio: int) -> bool:
        
    if premio not in premiados:
        
        premiados.append(premio)
        return True
    return False


import random

num_premios = int(input("Numero de premios -> "))

contador = 0

premiados = []


while contador < num_premios:
    numero_aleatorio = random.randint(1, 9999)
    if ignorar_repetidos(premiados,numero_aleatorio) == True:
        contador += 1

    
for premio in premiados:
    print(f"Premiados = {premio:04d}")


