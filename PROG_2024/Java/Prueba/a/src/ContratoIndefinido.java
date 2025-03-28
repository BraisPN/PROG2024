public class ContratoIndefinido extends Contrato {
    private boolean extrasProrrateadas;
    
    /**
     * Construtor de contrao
     * @param nome do contratado
     * @param apelidos do contratado
     * @param salarioBrutoAnual do contratado
     * @param irpf en porcentaxe
     * @param extrasProrrateadas verdadeiro se son 12 pagas, falso en caso contrario
     */
    public ContratoIndefinido(String nome, String apelidos, double salarioBrutoAnual, double irpf, boolean extrasProrrateadas) {
        super(nome, apelidos, salarioBrutoAnual, irpf);
        this.setExtrasProrrateadas(extrasProrrateadas);
    }

    @Override
    public double getSalarioMensualNeto() {
        if (this.extrasProrrateadas) {
            return super.getSalarioMensualNeto();
        }
        else {
            return this.getSalarioBrutoAnual() / 14.0;
        }
    }

    @Override
    public String toString() {
        String mensaxe = "Contrato indefinido " + super.toString() + ". Pagas anuais: ";
        if (extrasProrrateadas) {
            mensaxe = mensaxe + " 12";
        }
        else {
            mensaxe = mensaxe + " 14";
        }
        return mensaxe;
    }

    public boolean isExtrasProrrateadas() {
        return extrasProrrateadas;
    }

    public void setExtrasProrrateadas(boolean extrasProrrateadas) {
        this.extrasProrrateadas = extrasProrrateadas;
    }
}