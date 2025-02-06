#!/usr/bin/env python
# -*- coding: utf-8 -*-

"""
Exercicio 5. Escribe unha función calcular_desconto_irpf(soldo_bruto: float/int, irpf: int) -> float nun script que calcule o desconto de IRPF.
Comproba que estes dous valores son números, que o soldo é maior que 0 e que o IRPF é un valor válido. 
Se algunha destas condicións non se cumpre, lanza a excepción ValueError. 
O propio script deberá recibir estes datos por teclado e utilizar a función creada para calcular o desconto do IRPF. 
Captura a excepción que lanza a función.
"""

__author__ = "Brais Pose Nieto"

def calcular_desconto_irpf(soldo_bruto, irpf) -> float:
    """
    Calcula o desconto de IRPF a partir do soldo bruto e a porcentaxe de IRPF.

    Args:
        soldo_bruto (float o int): O soldo bruto do que se calculará o desconto.
        irpf (float o int): A porcentaxe de IRPF a aplicar (debe estar entre 0 e 100).

    Returns:
        float: O valor do desconto de IRPF calculado.

    Raises:
        ValueError: Se o soldo bruto ou o IRPF non son valores válidos ou se
                     non cumpren as condicións establecidas.
    """
    # Verifica se soldo_bruto e irpf son valores numéricos e se cumpren as condicións
    if not (type(soldo_bruto) in (float,int)):
        raise ValueError("O soldo bruto debe ser un valor númerico.")
    if not  type(irpf) in (float,int):
        raise ValueError("O IRPF debe ser un valor númerico.")
    if soldo_bruto <= 0:
        raise ValueError("O soldo bruto debe ser maior que 0.")
    
    if not (0 <= irpf <= 100):
        raise ValueError("O IRPF debe estar entre 0 e 100.")
    
    # Calcula o desconto de IRPF
    desconto = (soldo_bruto * irpf) / 100
    return desconto

# Pide os datos ao usuario e calcula o desconto de IRPF
try:
    soldo_bruto = float(input("Introduce o soldo bruto: "))
    irpf = float(input("Introduce o IRPF (en tanto por cen): "))
    desconto = calcular_desconto_irpf(soldo_bruto, irpf)
    print(f"O desconto é de: {desconto}")
except ValueError as erro:
    print(f"Erro: {erro}")
