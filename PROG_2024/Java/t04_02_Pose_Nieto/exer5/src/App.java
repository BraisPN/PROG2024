import java.time.LocalDateTime;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        ArrayList<String> pacientes = new ArrayList<>();
        ArrayList<LocalDateTime> citas = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        DateTimeFormatter formatoEntrada = DateTimeFormatter.ofPattern("HH:mm dd/MM/yyyy");
        DateTimeFormatter formatoSaida = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        
        int opcion;
        do {
            System.out.println("Menú:");
            System.out.println("1. Engadir cita");
            System.out.println("2. Eliminar cita");
            System.out.println("3. Seleccionar data");
            System.out.println("4. Saír");
            System.out.print("Escolle unha opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine();

            if (opcion == 1) {
                System.out.print("Nome do paciente: ");
                String nome = scanner.nextLine();

                System.out.print("Introduce a cita (HH:mm dd/MM/yyyy): ");
                String entrada = scanner.nextLine();
                LocalDateTime novaCita = LocalDateTime.parse(entrada, formatoEntrada);

                if (novaCita.getDayOfWeek().getValue() >= 6) {
                    System.out.println("Non se poden engadir citas no fin de semana.");
                    continue;
                }

                boolean conflito = false;
                for (LocalDateTime cita : citas) {
                    if (Math.abs(cita.compareTo(novaCita)) < 30) {
                        conflito = true;
                        break;
                    }
                }

                if (conflito) {
                    System.out.println("Xa hai unha cita nese horario. Escolle outro.");
                } else {
                    pacientes.add(nome);
                    citas.add(novaCita);
                    System.out.println("Cita engadida correctamente.");
                }
            } 
            else if (opcion == 2) {
                if (citas.isEmpty()) {
                    System.out.println("Non hai citas para eliminar.");
                    continue;
                }

                System.out.println("Citas programadas:");
                for (int i = 0; i < citas.size(); i++) {
                    System.out.println((i + 1) + ". " + pacientes.get(i) + " - " + citas.get(i).format(formatoSaida));
                }

                System.out.print("Número da cita a eliminar: ");
                int index = scanner.nextInt() - 1;
                scanner.nextLine();

                if (index >= 0 && index < citas.size()) {
                    pacientes.remove(index);
                    citas.remove(index);
                    System.out.println("Cita eliminada correctamente.");
                } else {
                    System.out.println("Número incorrecto.");
                }
            } 
            else if (opcion == 3) {
                System.out.print("Introduce unha data (dd-MM-yyyy): ");
                String entrada = scanner.nextLine();
                LocalDate dataSeleccionada = LocalDate.parse(entrada, DateTimeFormatter.ofPattern("dd-MM-yyyy"));

                System.out.println("Citas para o " + dataSeleccionada + ":");
                boolean atopada = false;
                for (int i = 0; i < citas.size(); i++) {
                    if (citas.get(i).toLocalDate().equals(dataSeleccionada)) {
                        System.out.println(pacientes.get(i) + " - " + citas.get(i).format(formatoSaida));
                        atopada = true;
                    }
                }

                if (!atopada) {
                    System.out.println("Non hai citas para esta data.");
                }
            }
        } while (opcion != 4);

        System.out.println("------> Saíndo do programa.");
        scanner.close();
    }
}
