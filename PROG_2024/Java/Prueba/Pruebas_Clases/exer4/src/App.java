public class App {
    public static void main(String[] args) throws Exception {
        Empregado e1 = new Empregado("55026812R", "Manuel", "Varela", "López", 1500);
        System.out.println("DNI de Manuel: "+e1.getDNI());
        e1.setDni("55026811R");
        System.out.println(e1.getApelidos() + ", " + e1.getNome() + " con " + e1.getDNI() + " ten un salario neto de " + e1.getSalarioNeto() + " eur");
    }
}
