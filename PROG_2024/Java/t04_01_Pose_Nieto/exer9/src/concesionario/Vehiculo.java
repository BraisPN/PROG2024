package concesionario;

import utils.TipoCombustible;

public class Vehiculo {
    private static int numeroTotalVehiculos = 0;
    private static double velocidadeMaxima = 120;
    private String matricula;
    private String marca;
    private String modelo;
    private TipoCombustible tipoCombustible;
    private double velocidade;

    public static boolean comprobarMatricula(String matricula) {
        if (matricula == null || matricula.length() != 7) {
            return false;
        }

        // Verificar os primeiros 4  díxitos
        for (int i = 0; i < 4; i++) {
            if (matricula.charAt(i) < '0' || matricula.charAt(i) > '9') {
                return false;
            }
        }

        // Verificar os últimos 3 caracteres
        String letrasValidas = "BCDFGHJKLMNPRSTVWXYZ";
        for (int i = 4; i < 7; i++) {
            if (letrasValidas.indexOf(matricula.charAt(i)) == -1) {
                return false;
            }
        }

        return true;
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
        this.velocidade = this.velocidade + cambio;
    
        if (this.velocidade < 0) {
            this.velocidade = 0;
        }
    
        if (this.velocidade > velocidadeMaxima) {
            this.velocidade = velocidadeMaxima;
        }
    }
    

    public void acelerar() {
        modificarVelocidade(10);
    }
    /**
     * Método para acelerar.
     */
    public void acelerar(int velocidade) {
        modificarVelocidade(velocidade);
    }

    /**
     * Método para decelerar 10 km/h.
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

    public double getVelocidade() {
        return velocidade;
    }

    public static int getNumeroTotalVehiculos() {
        return numeroTotalVehiculos;
    }

    public static double getVelocidadeMaxima() {
        return velocidadeMaxima;
    }

    public static void setVelocidadeMaxima(double novaVelocidadeMaxima) {
        velocidadeMaxima = novaVelocidadeMaxima;
    }
}
