import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;


public class App {
    public static void main(String[] args) {
        String rutaFicheiro = "C:\\Users\\a21braispn\\Documents\\PROG\\PROG_2024\\Java\\t06_01_Pose_Nieto\\exer2\\src\\spotify.csv";
        ArrayList<SpotifyData> datos = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(rutaFicheiro))) {
            String liña;
            while ((liña = reader.readLine()) != null) {
                String[] campos = liña.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)");

                datos.add(new SpotifyData(campos[0], campos[1], campos[2], campos[3], campos[4]));  
            }

            // 1. Imprime os artistas que tiveron un número 1 no ano 2023.
            ArrayList<String> artistasTop1 = new ArrayList<>();
            datos.stream()
                .filter(d -> d.date().contains("2023") && d.position().equals("1"))
                .forEach(d -> artistasTop1.add(d.artist()) );

            System.out.println("Artistas que ocuparon a posición 1 en 2023:\n");
            artistasTop1.stream().distinct().forEach(x -> System.out.println(x));
            System.out.println("----------------------------------------");

            // 2. Indica o número de cancións diferentes que foron número 1 en 2024.
            ArrayList<String> cancionsTop1 = new ArrayList<>();
            datos.stream()
                .filter(d -> d.date().contains("2024") && d.position().equals("1"))
                .forEach(d -> cancionsTop1.add(d.song()) );

            System.out.println("Número de cancións diferentes que foron número 1 en 2024:\n");
            cancionsTop1.stream().distinct().forEach(x -> System.out.println(x));
            System.out.println("----------------------------------------");
            System.out.println();
            // 3. Indica as cancións de “Aitana” que estiveron nas 10 primeiras posicións das máis escoitadas
            ArrayList<String> cancionsTop10Aitana = new ArrayList<>();
            datos.stream()
                .filter(d -> d.position().matches("[1-9]|10") && d.artist().equals("Aitana"))
                .forEach(d -> cancionsTop10Aitana.add(d.song()) );

            System.out.println("Cancións de Aitana que estiveron nas 10 primeiras posicións:\n");
            cancionsTop10Aitana.stream().distinct().forEach(x -> System.out.println(x));
            System.out.println("----------------------------------------");
            System.out.println();
            // 4. Indica as cancións que foron máis escoitadas durante o mes de agosto de 2024.
            ArrayList<String> cancionsTop1agosto = new ArrayList<>();
            datos.stream()
                .filter(d -> d.date().contains("2024-08") && d.position().equals("1"))
                .forEach(d -> cancionsTop1agosto.add(d.song()));

            System.out.println("Cancións que foron máis escoitadas durante o mes de agosto de 2024:\n");
            cancionsTop1agosto.stream().distinct().forEach(x -> System.out.println(x));
            System.out.println("----------------------------------------");
            System.out.println();
            // 5. Indica as posicións diferentes que obtiveron as cancións de “Aitana” ordenadas de menor a maior nunha cadea de texto separada por comas.
            ArrayList<String> posicionsAitana = new ArrayList<>();
            datos.stream()
                .filter(d -> d.artist().equals("Aitana"))
                .forEach(d -> posicionsAitana.add(d.position()));
            
            System.out.println("Posicións diferentes que obtiveron as cancións de Aitana:\n");
            posicionsAitana.stream().distinct().sorted().forEach(x -> System.out.println(x));
            System.out.println("----------------------------------------");
            System.out.println();
            
        } catch (IOException e) {
            System.out.println(e);
        }
        
        
    }
}
