public class Circulo implements Figura{
    private double radio;
    
    public Circulo(double radio) {
     this.radio = radio;
    }
 
    public double calcularArea(){
         return Math.PI * (radio * radio);
    }

    @Override
    public String toString() {
        return "Circulo";
    }
    
 }
 