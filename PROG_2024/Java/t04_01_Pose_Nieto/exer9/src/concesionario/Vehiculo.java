package concesionario;

import utils.TipoCombustible;

/**
 * Clase que representa un vehículo.
 */
public class Vehiculo {
    private static int numeroTotalVehiculos = 0;
    private static int velocidadeMaxima = 120;

    private String matricula;
    private String marca;
    private String modelo;
    private TipoCombustible tipoCombustible;
    private int velocidade;

    public static boolean comprobarMatricula(String matricula) {
        return matricula.matches("\\d{4}[BCDFGHJKLMNPRSTVWXYZ]{3}");
    }

    public Vehiculo(String matricula, String marca, String modelo) {
        this.matricula = comprobarMatricula(matricula) ? matricula : "0000XXX";
        this.marca = marca;
        this.modelo = modelo;
        this.tipoCombustible = TipoCombustible.GASOLINA;
        this.velocidade = 0;
        numeroTotalVehiculos++;
    }

    public Vehiculo(String matricula, String marca, String modelo, TipoCombustible tipoCombustible) {
        this(matricula, marca, modelo);
        this.tipoCombustible = tipoCombustible;
    }

    private void modificarVelocidade(int cambio) {
        this.velocidade = Math.max(0, Math.min(velocidadeMaxima, this.velocidade + cambio));
    }

    public void acelerar() {
        modificarVelocidade(10);
    }

    public void acelerar(int velocidade) {
        modificarVelocidade(velocidade);
    }

    /**
     * Método para decelerar en 10 km/h.
     */
    public void decelerar() {
        modificarVelocidade(-10);
    }


    public void decelerar(int velocidade) {
        modificarVelocidade(-velocidade);
    }

    // Getters y Setters
    public String getMatricula() {
        return matricula;
    }

    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public TipoCombustible getTipoCombustible() {
        return tipoCombustible;
    }

    public int getVelocidade() {
        return velocidade;
    }

    public static int getNumeroTotalVehiculos() {
        return numeroTotalVehiculos;
    }

    public static int getVelocidadeMaxima() {
        return velocidadeMaxima;
    }

    public static void setVelocidadeMaxima(int novaVelocidadeMaxima) {
        velocidadeMaxima = novaVelocidadeMaxima;
    }
}
