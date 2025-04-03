## Exercicio 2

Segue os seguintes pasos:

### Clase Cliente

Crea unha clase `Cliente` que implante a interface `Comparable<Cliente>` coas seguintes características:

- Almacena o **DNI**, **nome**, **idade** e **soldo** do cliente.
- Crea os **getters** e **setters** necesarios.
- Crea os **construtores** que creas necesarios.
- Documenta os **construtores**.
- Redefine o método `toString()` co formato:
  
  ```
  <DNI> <Nome>. Idade: <idade>. Soldo <soldo>.
  ```
- Redefine o método `equals()`. Para que dous clientes sexan iguais, tan só o **DNI** debe de coincidir.
- Implanta o método `int compareTo(Cliente ob)` no cal o criterio de ordenación estará baseado no **DNI**.

### Clase CompararPorNome

Crea a clase `CompararPorNome` que implante a interface `Comparator<Cliente>`:

- Implanta o método `int compare(Cliente ob1, Cliente ob2)` no cal o criterio de ordenación estará baseado no **nome**.

### Programa Principal

Realiza o seguinte programa principal:

1. Crea un **ArrayList** para almacenar clientes.
2. Crea os seguintes clientes e almacénaos na lista de clientes:

| DNI        | Nome  | Idade | Soldo  |
|------------|-------|-------|--------|
| 12345678A | Ana   | 25    | 1500.50 |
| 87654321B | Xoán  | 30    | 1800.75 |
| 11223344C | Marta | 28    | 2000.00 |
| 44332211D | Pedro | 35    | 2500.25 |
| 99887766E | Laura | 22    | 1600.60 |
| 55667788F | Carlos | 40   | 2200.10 |
| 66778899G | Sabela | 27   | 1700.80 |

3. **Imprime a lista de clientes ordenada por DNI.**
4. **Imprime a lista de clientes ordenada por nome utilizando a clase `CompararPorNome`.**
5. **Imprime a lista de clientes ordenada por idade utilizando unha clase anónima.**
