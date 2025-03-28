import java.util.ArrayList;

public class App {
    public static void main(String[] args) throws Exception {
        ArrayList<Contrato> contratos = new ArrayList<>();
        contratos.add(new ContratoIndefinido("Charles", "Foster Kane", 35000, 18, false));
        contratos.add(new ContratoIndefinido("Rick", "Blaine", 60000, 25, true));
        contratos.add(new ContratoTemporal("Cool", "Hand Luke", 10000, 6, 4, "12/01/2025"));
        contratos.add(new ContratoEnPracticas("Harrison", "Smith", 15000, 2, "Desenvolvemento de Aplicacións Web"));
        for(Contrato c: contratos){
            System.out.println(c.toString());
        }
    }
}