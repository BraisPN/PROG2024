import java.util.ArrayList;

public class App {
    public static void main(String[] args) throws Exception {
        ArrayList<Contrato> contratos = new ArrayList<Contrato>();

        ContratoIndefinido contratoIndefinido1 = new ContratoIndefinido("Charles", "Foster Kane", 35000, 18, false);
        contratos.add(contratoIndefinido1);

        ContratoIndefinido contratoIndefinido2 = new ContratoIndefinido("Rick", "Blaine", 60000, 25, true);
        contratos.add(contratoIndefinido2);

        ContratoTemporal contratoTemporal1 = new ContratoTemporal("Cool", "Hand Luke", 10000, 6, 4, "12/01/2025");
        contratos.add(contratoTemporal1);

        ContratoEnPracticas contratoEnPracticas1 = new ContratoEnPracticas("Harrison", "Smith", 15000, 2, "Desenvolvemento de Aplicacións Web");
        contratos.add(contratoEnPracticas1);

        for(Contrato c: contratos) {
            System.out.println(c);
        }


    }
}