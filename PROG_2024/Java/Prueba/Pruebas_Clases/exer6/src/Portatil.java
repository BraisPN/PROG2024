public class Portatil {
    private String Modelo;
    private String NS;
    private Cor Cor;

    public Portatil(String modelo, String nS, Cor cor) {
        Modelo = modelo;
        NS = nS;
        Cor = cor;
    }

    public String getModelo() {
        return Modelo;
    }

    public void setModelo(String modelo) {
        Modelo = modelo;
    }

    public String getNS() {
        return NS;
    }

    public void setNS(String nS) {
        NS = nS;
    }

    public Cor getCor() {
        return Cor;
    }

    public void setCor(Cor cor) {
        Cor = cor;
    }

}
