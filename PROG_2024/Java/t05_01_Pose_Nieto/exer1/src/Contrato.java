public abstract class Contrato {
    private static int ultimoNumeroContrato = 0;
    private int numeroContrato;
    private String nome;
    private String apelidos;
    private double salarioBrutoAnual;
    private double irpf;


    /**
     * Construtor de contrato
     * @param nome do contratado
     * @param apelidos do contratado
     * @param salarioBrutoAnual do contratado
     * @param irpf do contratado en tanto por 100
     */
    public Contrato(String nome, String apelidos, double salarioBrutoAnual, double irpf) {
        this.setNome(nome);
        this.setApelidos(apelidos);
        this.setSalarioBrutoAnual(salarioBrutoAnual);
        this.setIrpf(irpf);
        Contrato.ultimoNumeroContrato++;
        this.numeroContrato = Contrato.ultimoNumeroContrato;
    }

    /**
     * Devolve o salario neto anual
     * @return devolve o salario neto anual
     */
    public double getSalarioNetoAnual() {
        return this.salarioBrutoAnual * (1 - irpf);
    }

    /**
     * Devolve o salario neto mensual
     * @return devolve o salario neto mensual
     */
    public double getSalarioMensualNeto() {
        return this.getSalarioNetoAnual()/12.0;
    }

    @Override
    public String toString() {
        String mensaxe = this.numeroContrato + ": " + this.apelidos + ", " + this.nome + ". Salario mensual: " + this.getSalarioMensualNeto();
        return mensaxe;
    }

    public static int getUltimoNumeroContrato() {
        return ultimoNumeroContrato;
    }

    public static void setUltimoNumeroContrato(int ultimoNumeroContrato) {
        Contrato.ultimoNumeroContrato = ultimoNumeroContrato;
    }

    public int getNumeroContrato() {
        return numeroContrato;
    }

    public void setNumeroContrato(int numeroContrato) {
        this.numeroContrato = numeroContrato;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getApelidos() {
        return apelidos;
    }
    
    public void setApelidos(String apelidos) {
        this.apelidos = apelidos;
    }

    public double getSalarioBrutoAnual() {
        return salarioBrutoAnual;
    }

    public void setSalarioBrutoAnual(double salarioBrutoAnual) {
        this.salarioBrutoAnual = salarioBrutoAnual;
    }

    public double getIrpf() {
        return irpf;
    }

    public void setIrpf(double irpf) {
        this.irpf = irpf / 100.0;
    }

}