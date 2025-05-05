# Exercicio 1

Realiza as seguintes tarefas con **Streams de Java**:

1. **Filtrar tódolos números pares** da lista `listaNumeros`, elevalos ao cadrado e **mostralos por pantalla**.
2. **Converte unha lista de números nunha lista de String** e garda na variable `listaString`.
3. **Indica a cantidade de cadeas de `listaString` que teñen máis dun carácter**.

Tan só debes completar o seguinte código:

```java
public static void main(String[] args) throws Exception {
    
    ArrayList<Integer> listaNumeros = new ArrayList<>();
    for (int i=0; i < 100; i++) {   
        listaNumeros.add(i);
    }

    // 1. TODO

    System.out.println("-------------");

    // 2. TODO
    for(String s: listaString) System.out.println(s);

    System.out.println("-------------");

    // 3. TODO
    System.out.println(sol3);
}
