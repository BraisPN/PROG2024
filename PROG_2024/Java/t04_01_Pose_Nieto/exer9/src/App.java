import concesionario.Vehiculo;
import utils.TipoCombustible;


public class App {
    public static void main(String[] args) {
        System.out.println(Vehiculo.getNumeroTotalVehiculos()); 

        Vehiculo leon = new Vehiculo("1234CGF", "SEAT", "León");
        System.out.println(Vehiculo.getNumeroTotalVehiculos()); 
        Vehiculo c3 = new Vehiculo("6894DEF", "Citroen", "C3", TipoCombustible.ELECTRICO);
        System.out.println(Vehiculo.getNumeroTotalVehiculos()); 

        System.out.println(leon.getMatricula() + " " + leon.getTipoCombustible());
        System.out.println(c3.getMatricula() + " " + c3.getTipoCombustible());

        leon.acelerar(20);
        leon.acelerar();
        System.out.println(leon.getVelocidade());

        leon.acelerar(100);
        System.out.println(leon.getVelocidade());

        leon.decelerar();
        leon.decelerar(200);
        System.out.println(leon.getVelocidade());

        Vehiculo.setVelocidadeMaxima(130);

        leon.acelerar(125);
        System.out.println(leon.getVelocidade());
    }
}
