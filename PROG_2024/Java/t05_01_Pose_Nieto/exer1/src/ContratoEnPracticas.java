public class ContratoEnPracticas extends Contrato{
    private String titulacion;

    
    public ContratoEnPracticas(String nome, String apelidos, double salarioBrutoAnual, int irpf,
            String titulacion) {
        super(nome, apelidos, salarioBrutoAnual, irpf);
        this.titulacion = titulacion;
    }


// Getters & Setters
    public String getTitulacion() {
        return titulacion;
    }

    public void setTitulacion(String titulacion) {
        this.titulacion = titulacion;
    }

    @Override
    public String toString() {
        return "Contrato En Practicas " + getNumeroContrato() + ": " + getApelidos() + ", " + getNome() + ". " + "Salario mensual: " + getSalarioMensualNeto() + ". Titulación: " + getTitulacion();

    }

// Métodos

    
}
