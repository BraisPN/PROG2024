import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class App {
    public static void main(String[] args) throws Exception {

        ArrayList<Integer> listaNumeros = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            listaNumeros.add(i);
        }

        // 1. TODO
        List<Integer> listaElevados = listaNumeros.stream()
                .filter(n -> n % 2 == 0)
                .map(n -> n * n)
                .collect(Collectors.toList());
        for (Integer i : listaElevados) {
            System.out.println(i);
        }
        
        System.out.println("-------------");

        // 2. TODO
        List<String> listaString = new ArrayList<>();
        listaString = listaNumeros.stream()
                .map(n -> Integer.toString(n))
                .collect(Collectors.toList());

        for (String s : listaString) System.out.println(s);

        System.out.println("-------------");

        // 3. TODO
        long sol3 = listaString.stream()
                .filter(s -> s.length() >= 2)
                .count();
        System.out.println(sol3);
    }

}
