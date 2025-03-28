import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class ContratoTemporal extends Contrato{
    private int duracionContrato;
    private LocalDate inicioContrato;
    private final static DateTimeFormatter formatoPersonalizado = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    /**
     * Construtor de contrao
     * @param nome do contratado
     * @param apelidos do contratado
     * @param salarioBrutoAnual do contratado
     * @param irpf en porcentaxe
     * @param duracionContrato os meses que dura o contrato, non poden ser máis de 6
     * @param inicioContrato dia do inicio do contrato en formato dd/MM/yyyy
     */
    public ContratoTemporal(String nome, String apelidos, double salarioBrutoAnual, double irpf, int duracionContrato, String inicioContrato) {
        super(nome, apelidos, salarioBrutoAnual, irpf);
        this.setDuracionContrato(duracionContrato);
        this.setInicioContrato(inicioContrato);
    }

    /**
     * Devolve a data do fin do contrato
     * @return data do fin do contrato en formato dd/MM/yyyy
     */
    public String getFinContrato() {
        LocalDate finContrato = this.inicioContrato.plus(this.duracionContrato, ChronoUnit.MONTHS);
        return finContrato.format(ContratoTemporal.formatoPersonalizado);

    }

    @Override
    public double getSalarioMensualNeto() {
        return this.getSalarioNetoAnual() / (double) this.duracionContrato;
    }

    @Override
    public String toString() {
        String mensaxe = "Contrato temporal " + super.toString() + ". Contratado dende : ";
        mensaxe = mensaxe + this.inicioContrato.format(ContratoTemporal.formatoPersonalizado) + " ata ";
        mensaxe = mensaxe + this.getFinContrato();
        return mensaxe;
    }

    public int getDuracionContrato() {
        return duracionContrato;
    }

    public void setDuracionContrato(int duracionContrato) {
        if (duracionContrato > 6) {
            duracionContrato = 6;
        }
        this.duracionContrato = duracionContrato;
    }

    public LocalDate getInicioContrato() {
        return inicioContrato;
    }

    public void setInicioContrato(String inicioContrato) {
        this.inicioContrato = LocalDate.parse(inicioContrato, ContratoTemporal.formatoPersonalizado);
    }

    public static DateTimeFormatter getFormatopersonalizado() {
        return formatoPersonalizado;
    }

}