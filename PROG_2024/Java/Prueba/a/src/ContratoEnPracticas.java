public class ContratoEnPracticas extends Contrato{
    private String titulacion;


    /**
     * Construtor de contrao
     * @param nome do contratado
     * @param apelidos do contratado
     * @param salarioBrutoAnual do contratado
     * @param irpf en porcentaxe
     * @param titulacion a titulacion que está cursando o contratado
     */
    public ContratoEnPracticas(String nome, String apelidos, double salarioBrutoAnual, double irpf, String titulacion) {
        super(nome, apelidos, salarioBrutoAnual, irpf);
        this.setTitulacion(titulacion);
    }

    @Override
    public String toString() {
        String mensaxe = "Contrato en prácticas " + super.toString() + ". Titulación : " + this.titulacion;
        return mensaxe;
    }


    public String getTitulacion() {
        return titulacion;
    }


    public void setTitulacion(String titulacion) {
        this.titulacion = titulacion;
    }
}