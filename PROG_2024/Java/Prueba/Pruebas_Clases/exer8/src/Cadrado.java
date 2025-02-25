public class Cadrado {
    private double lado;

    public Cadrado(double lado){
        this.setLado(lado, Unidades.M);
    }

    public Cadrado(double lado, Unidades unidade){
        this.setLado(lado, unidade);
    }

    public void setLado(double lado, Unidades unidade) {
        if (unidade == Unidades.DM) {
            this.lado = lado / 10;
        }
        else if (unidade == Unidades.CM) {
            this.lado = lado / 100;
        }
        else if (unidade == Unidades.KM) {
            this.lado = lado * 1000;
        }
        else{
            this.lado = lado;
        }
    }

    public double getLado() {
        return lado;
    }

    public double getPerimetro(Unidades unidade) {
        if(unidade == Unidades.DM) {
            return (this.lado * 10) * 4;
        }
        else if (unidade == Unidades.CM) {
            return (this.lado * 100) * 4;
        }
        else if (unidade == Unidades.KM) {
            return (this.lado / 1000) * 4;
        }
        else {
            return this.lado * 4;
        }
    }

    public double getArea(Unidades unidade){
        if(unidade == Unidades.DM) {
            return (this.lado * 10) * (this.lado * 10);
        }
        else if (unidade == Unidades.CM) {
            return (this.lado * 100) * (this.lado * 100);
        }
        else if (unidade == Unidades.KM) {
            return (this.lado / 1000) * (this.lado / 1000);
        }
        else {
            return this.lado * this.lado;
        }
    }
}
