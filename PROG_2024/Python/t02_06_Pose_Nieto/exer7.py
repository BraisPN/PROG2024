#!/usr/bin/env python
# -*- coding: utf-8 -*-

"""
Exercicio 7. Un número de DNI ten o seguinte formato 00000000A. Escribe un script que lle pida ao usuario o seu DNI e comprobe que sexa correcto. 

Para iso sigue os seguintes pasos: Comproba a lonxitude da cadea. Comproba que os 8 primeiros díxitos son números e o último é unha letra maiúscula. 

PISTA: utiliza a táboa do código ASCII. Comproba que a letra introducida é o código de control do DNI.

https://www.interior.gob.es/opencms/es/servicios-al-ciudadano/tramites-y-gestiones/dni/calculo-del-digito-de-control-del-nif-nie/#:~:text=Por%20ejemplo%2C%20si%20el%20n%C3%BAmero,n%C3%BAmeros%20y%20d%C3%ADgito%20de%20control. 

Por último imprime Válido ou Inválido segundo corresponda.
"""

__author__ = "Brais Pose Nieto"

def calcular_letra_dni(numero):
    """
    Calcula a letra de control do DNI a partir dos primeiros 8 díxitos numéricos.

    Args:
        numero (int): Número de 8 díxitos correspondente á parte numérica do DNI.

    Returns:
        str: Letra de control do DNI correspondente ao número.
    """
    letras = "TRWAGMYFPDXBNJZSQVHLCKE"
    return letras[numero % 23]

def comprobar_dni(dni):
    """
    Comproba se un DNI é válido segundo o formato español.

    Realiza as seguintes comprobacións:
    1. Verifica que o DNI teña exactamente 9 caracteres.
    2. Confirma que os primeiros 8 caracteres son díxitos.
    3. Verifica que o último carácter é unha letra maiúscula.
    4. Calcula e compara a letra de control co último carácter do DNI.

    Args:
        dni (str): DNI introducido polo usuario en formato 00000000A.

    Returns:
        str: "Válido" se o DNI é correcto, "Inválido" no caso contrario.
    """
    # Comproba tamaño do valor introducido
    if not len(dni) == 9:
        return False

    # Comproba formato usando valores ASCII
    for i in dni[:8]:
        if ord(i) < 48 or ord(i) > 57:  # ASCII de '0' é 48 e de '9' é 57
            return False
    
    if ord(dni[8]) < 65 or ord(dni[8]) > 90:  # ASCII de 'A' é 65 e de 'Z' é 90
        return False

    # Comproba letra de control
    numero = int(dni[:8])
    letra = dni[8]
    letra_correcta = calcular_letra_dni(numero)

    if not letra == letra_correcta:
        return False

    return True

# Solicita DNI ao usuario
dni = input("Introduce o teu DNI: ")
resultado = comprobar_dni(dni)
if resultado == True:
    print("Válido")
elif resultado == False:
    print("Inválido")