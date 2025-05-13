package Model;

public class Biblioteca {
    private static int contId = 0;

    private String nome;
    private String direccion;
    private String cidade;
    private String provincia;
    private int id;

    public Biblioteca(String nome, String direccion, String cidade, String provincia, int id) {
        setNome(nome);
        setDireccion(direccion);
        setCidade(cidade);
        setProvincia(provincia);
        setId(id);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        contId++;
        this.id = contId;
    }

    @Override
    public String toString() {
        return this.getId() + " " + this.getNome() + ", " + this.getDireccion() + "; " + this.getCidade() + " ("
                + this.getProvincia() + ")";
    }

}
