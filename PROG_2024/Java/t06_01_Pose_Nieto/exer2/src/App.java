import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class App {
    public static void main(String[] args) {
        String rutaFicheiro = "src\\spotify.csv";
        ArrayList<SpotifyData> datos = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(rutaFicheiro))) {
            String liña;
            while ((liña = reader.readLine()) != null) {
                String[] campos = liña.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)");

                datos.add(new SpotifyData(campos[0], campos[1], campos[2], campos[3], campos[4]));
            }
        } catch (IOException e) {
            System.out.println(e);
        }
        // 1. Imprime os artistas que tiveron un número 1 no ano 2023.
        ArrayList<String> artistasTop1 = new ArrayList<>();
        datos.stream()
                .filter(d -> d.date().contains("2023") && d.position().equals("1"))
                .forEach(d -> artistasTop1.add(d.artist()));

        System.out.println("\nArtistas que ocuparon a posición 1 en 2023:");
        artistasTop1.stream().distinct().forEach(x -> System.out.println(x));
        System.out.println("----------------------------------------");

        // 2. Indica o número de cancións diferentes que foron número 1 en 2024.
        ArrayList<String> cancionsTop1 = new ArrayList<>();
        datos.stream()
                .filter(d -> d.date().contains("2024") && d.position().equals("1"))
                .forEach(d -> cancionsTop1.add(d.song()));

        System.out.println("\nNúmero de cancións diferentes que foron número 1 en 2024:");
        System.out.println(cancionsTop1.stream().distinct().count());
        System.out.println("----------------------------------------");

        // 3. Indica as cancións de “Aitana” que estiveron nas 10 primeiras posicións
        // das máis escoitadas
        ArrayList<String> cancionsTop10Aitana = new ArrayList<>();
        datos.stream()
                .filter(d -> d.position().matches("[1-9]|10") && d.artist().equals("Aitana"))
                .forEach(d -> cancionsTop10Aitana.add(d.song()));

        System.out.println("\nCancións de Aitana que estiveron nas 10 primeiras posicións:");
        cancionsTop10Aitana.stream().distinct().forEach(x -> System.out.println(x));
        System.out.println("----------------------------------------");

        // 4. Indica as cancións que foron máis escoitadas durante o mes de agosto de
        // 2024.
        ArrayList<String> cancionsTop1agosto = new ArrayList<>();
        datos.stream()
                .filter(d -> d.date().contains("2024-08") && Integer.parseInt(d.position()) <= 5)
                .forEach(d -> cancionsTop1agosto.add(d.song()));

        System.out.println("\nCancións que foron máis escoitadas durante o mes de agosto de 2024:");
        cancionsTop1agosto.stream().distinct().forEach(x -> System.out.println(x));
        System.out.println("----------------------------------------");

        // 5. Indica as posicións diferentes que obtiveron as cancións de “Aitana”
        // ordenadas de menor a maior nunha cadea de texto separada por comas.
        String posicionsAitanaTexto = datos.stream()
                .filter(d -> d.artist().equals("Aitana"))
                .map(d -> Integer.parseInt(d.position()))
                .distinct()
                .sorted()
                .map(d -> String.valueOf(d))
                .collect(Collectors.joining(", "));

        System.out.println("\nPosicións diferentes que obtiveron as cancións de Aitana:");
        System.out.println(posicionsAitanaTexto);
        System.out.println("----------------------------------------");

        // 6. Indica a posición máis alta de escoitadas que chegou unha canción de “Cris
        // Mj”.
        Optional<SpotifyData> posicion = datos.stream()
                .filter(d -> d.artist().equals("Cris Mj"))
                .min(Comparator.comparingInt(d -> Integer.parseInt(d.position())));

        System.out.println("\nPosición máis alta de escoitadas que chegou unha canción de Cris MJ:");
        if (posicion.isPresent()) {
            System.out.println(posicion.get().position());
        } else {
            System.out.println("Non se atopou ningunha canción de Cris MJ.");
        }
        System.out.println("----------------------------------------");
        // 7. Agrupa as cancións por artista nun map.
        Map<String, List<String>> cancionsXArtista = datos.stream()
                .collect(Collectors.groupingBy(c -> c.artist(),
                        Collectors.mapping(c -> c.song(),
                                Collectors.collectingAndThen(Collectors.toSet(), set -> set.stream().toList()))));

        System.out.println("\nAgrupación de cancións por artista:");
        cancionsXArtista.forEach((artista, cancion) -> {
            System.out.println(artista + ": " + cancion);
        });
        System.out.println("----------------------------------------");
        // 8. Indica o número de cancións que superan os 6 minutos e que estiveron nas 5
        // primeiras posicións.
        long longasTop5 = datos.stream()
                .filter(d -> esNumero(d.position()) && esNumero(d.duration_ms()))
                .filter(d -> Integer.parseInt(d.position()) <= 5 && Integer.parseInt(d.duration_ms()) > 360000)
                .count();

        System.out.println("\nNúmero de cancións que superan os 6 minutos e estiveron nas 5 primeiras posicións:");
        System.out.println(longasTop5);
        System.out.println("----------------------------------------");

    }

    public static boolean esNumero(String texto) {
        try {
            Integer.parseInt(texto);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
