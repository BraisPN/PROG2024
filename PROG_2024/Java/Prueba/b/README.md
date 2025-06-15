# Exercicio 1

## Descrición

Realiza un programa para a **xestión de hoteis** que ofreza ao usuario un menú con opcións para crear hoteis, engadir habitacións, buscar habitacións dispoñibles, facer reservas e consultar o grao de ocupación dun hotel nun día determinado.

---

## Funcionalidades

### a) Dar de alta un hotel

- Só é necesario indicar un nome para o hotel.

### b) Dar de alta unha habitación nun hotel

- Tipo de habitación: individual, dobre ou triple.
- Selección do hotel (mediante menú).
- Número de habitación (verificar que non se repita dentro do mesmo hotel).
- Prezo por noite.

### c) Buscador de habitacións libres nun hotel

- Datos de entrada:
  - Día de entrada e día de saída (formato `dd/mm/yyyy`).
  - Tipo de habitación (individual, dobre ou triple).
  - Hotel (mediante menú).
- Resultado: números das habitacións libres que cumpren os criterios.
- **Nota:** unha habitación considérase dispoñible o día da entrada aínda que ese mesmo día teña unha reserva que remate.

### d) Reservar unha habitación nun hotel

- Introducir:
  - Hotel (menú).
  - Número de habitación.
  - Día de entrada e saída (`dd/mm/yyyy`).
  - Nome da persoa que fai a reserva.
- Comprobar dispoñibilidade e crear a reserva se é posible.
- Cada reserva ten un **identificador único**.
- Se non se pode facer a reserva, mostrar mensaxe explicativa.

### e) Ver porcentaxe de ocupación dun día concreto

- Datos:
  - Data (`dd/mm/yyyy`).
  - Hotel (mediante menú).
- Mostra a porcentaxe de ocupación para ese día.
- **Nota:** se unha reserva remata o día introducido, esa habitación está dispoñible ese mesmo día.

---

## Código base

```java
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        boolean menuActivo = true;

        while(menuActivo) {
            System.out.println("a) Dar de alta un hotel");
            System.out.println("b) Dar de alta unha habitación nun hotel");
            System.out.println("c) Buscador de habitacións libres nun hotel");
            System.out.println("d) Reservar unha habitación nun hotel");
            System.out.println("e) Ver porcentaxe de ocupación dun determinado día nun hotel");
            System.out.println("s) Sair");

            String opcion = sc.nextLine();

            switch (opcion) {

                case "a" -> {
                    // Alta de hotel
                }

                case "b" -> {
                    // Alta de habitación
                }

                case "c" -> {
                    // Buscador de habitacións
                }

                case "d" -> {
                    // Reserva
                }

                case "e" -> {
                    // Porcentaxe ocupación
                }

                case "s" -> {
                    System.out.println("Saindo");
                    menuActivo = false;
                }

                default -> System.out.println("Opcion inválida");
            }
        }

        sc.close();
    }
}
```
# Exercicio 2

Realiza os seguintes métodos estáticos no programa principal:

- `public static Optional<Integer> productoEscalar(int[] vector1, int[] vector2)`  
  Devolve o produto escalar de dous vectores se teñen o mesmo tamaño.  
  En caso contrario devolve `Optional` baleiro.

  - Fórmula do produto escalar:  
    Dados dous vectores:  
    `u = [u₁, u₂, u₃, ...]`  
    `v = [v₁, v₂, v₃, ...]`  
    O produto escalar é:  
    `u₁·v₁ + u₂·v₂ + u₃·v₃ + ...`

- `public static Optional<Double> distanciaEntreDousPuntos(double[] vector1, double[] vector2)`  
  Devolve a distancia euclidiana entre dous puntos se e só se ambos teñen **exactamente 2 elementos**.  
  En caso contrario devolve `Optional` baleiro.

  - Fórmula:  
    `√((x₂ - x₁)² + (y₂ - y₁)²)`

- `public static boolean eMatrizIdentidade(int[][] matriz)`  
  Indica se unha matriz é identidade (matriz cadrada con uns na diagonal e ceros no resto).

  - Exemplos de matrices identidade:

    ```
    1 0
    0 1

    1 0 0
    0 1 0
    0 0 1
    ```

---

## Método main para probar os métodos

```java
public static void main(String[] args) throws Exception {

    /////////////// Test producto escalar
    int[][] vectores1 = {
        { 1, 2, 3 },
        { 4, 5, 6 },
        { 1, 0, -1 },
        { 3, 3, 3, 3 }
    };
    int[][] vectores2 = {
        { 4, 5, 6 },
        { 1, 1, 1 },
        { -1, 0, 1 },
        { 2, 2, 2 }
    };

    for (int i = 0; i < vectores1.length; i++) {
        Optional<Integer> resultado = productoEscalar(vectores1[i], vectores2[i]);
        if (resultado.isPresent())
            System.out.println("O producto escalor dos vectores é " + resultado.get());
        else
            System.out.println("Non se pode calcular o producto escalar");
    }

    /////////////////// Test distancia dous puntos
    double[][] puntos1 = {
        { 1.0, 2.0 },
        { 3.0, 4.0 },
        { 0.0, 0.0 },
        { 1.0 }
    };
    double[][] puntos2 = {
        { 4.0, 6.0 },
        { 0.0, 0.0 },
        { 1.0, 1.0 },
        { 2.0, 3.0 }
    };

    for (int i = 0; i < puntos1.length; i++) {
        Optional<Double> resultado = distanciaEntreDousPuntos(puntos1[i], puntos2[i]);
        if (resultado.isPresent())
            System.out.println("A distancia entre dous puntos é: " + resultado.get());
        else
            System.out.println("Non se pode calcular a distancia entre estes dous puntos");
    }

    /////////////////// Test matriz identidade
    int[][][] matrices = {
        {
            { 1, 0, 0 },
            { 0, 1, 0 },
            { 0, 0, 1 }
        },
        {
            { 1, 0, 0 },
            { 0, 1, 0 },
            { 1, 0, 1 }
        },
        {
            { 1, 0 },
            { 0, 1 }
        },
        {
            { 1, 0, 0 },
            { 0, 2, 0 },
            { 0, 0, 1 }
        },
        {
            { 1, 0, 0 },
            { 0, 1, 0 }
        }
    };

    for (int i = 0; i < matrices.length; i++) {
        boolean identidade = eMatrizIdentidade(matrices[i]);
        System.out.println("A matriz" + (identidade ? " é " : " non é ") + "unha matriz identidade.");
    }
}
```
## Salida Esperada
O producto escalor dos vectores é 32
O producto escalor dos vectores é 15
O producto escalor dos vectores é -2
Non se pode calcular o producto escalar
A distancia entre dous puntos é: 5.0
A distancia entre dous puntos é: 5.0
A distancia entre dous puntos é: 1.4142135623730951
Non se pode calcular a distancia entre estes dous puntos
A matriz é unha matriz identidade.
A matriz non é unha matriz identidade.
A matriz é unha matriz identidade.
A matriz non é unha matriz identidade.
A matriz non é unha matriz identidade.
