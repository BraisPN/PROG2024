import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public abstract class Deportista implements Comparable<Deportista> {
    private static final DateTimeFormatter form = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    
    private String nomeCompleto;
    private String nomePopular;
    private LocalDate dataNac;

    public Deportista(String nomeCompleto, String nomePopular, String dataNac) {
        this.nomeCompleto = nomeCompleto;
        this.nomePopular = nomePopular;
        setDataNac(dataNac);
    }

    public String getNomeCompleto() {
        return nomeCompleto;
    }

    public void setNomeCompleto(String nomeCompleto) {
        this.nomeCompleto = nomeCompleto;
    }

    public String getNomePopular() {
        return nomePopular;
    }

    public void setNomePopular(String nomePopular) {
        this.nomePopular = nomePopular;
    }

    public LocalDate getDataNac() {
        return dataNac;
    }

    public void setDataNac(String dataNac) {
        this.dataNac = LocalDate.parse(dataNac, form);
    }

    public int getIdade(){
        return LocalDate.now().getYear() - dataNac.getYear();
    }

    @Override
    public String toString() {
        return this.nomePopular + " : " + getIdade() + " anos";
    }

    @Override
    public int compareTo(Deportista o) {
        return this.dataNac.compareTo(o.getDataNac());
    }
}
