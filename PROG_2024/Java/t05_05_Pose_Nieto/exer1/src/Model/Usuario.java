package Model;
public class Usuario {
    private String nome;
    private String contrasinal;

    public Usuario(String nome, String contrasinal) {
        setNome(nome);
        setContrasinal(contrasinal);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getContrasinal() {
        return contrasinal;
    }

    public void setContrasinal(String contrasinal) {
        this.contrasinal = contrasinal;
    }

    @Override
    public boolean equals(Object obj) {
        Usuario u = (Usuario) obj;
        return this.nome.equals(u.getNome());
    }
}
