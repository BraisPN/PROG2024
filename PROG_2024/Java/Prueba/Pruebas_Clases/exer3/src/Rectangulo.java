public class Rectangulo {
    private double alto;
    private double ancho;
    
    public Rectangulo(double alto, double ancho) {
        this.alto = alto;
        this.ancho = ancho;
    }

    public double getPerimetro(){
        return this.alto * 2 + this.ancho * 2;
    }

    public double getArea(){
        return this.alto * this.ancho;
    }

    public double getAlto() {
        return alto;
    }

    public void setAlto(double alto) {
        this.alto = alto;
    }

    public double getAncho() {
        return ancho;
    }

    public void setAncho(double ancho) {
        this.ancho = ancho;
    }

    

}
