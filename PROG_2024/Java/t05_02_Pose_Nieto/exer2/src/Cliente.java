public class Cliente implements Comparable<Cliente>{
    private String dni;
    private String nome;
    private int idade;
    private double sueldo;
    
    public Cliente(String dni, String nome, int idade, double sueldo) {
        this.dni = dni;
        this.nome = nome;
        this.idade = idade;
        this.sueldo = sueldo;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public double getSueldo() {
        return sueldo;
    }

    public void setSueldo(double sueldo) {
        this.sueldo = sueldo;
    }

    @Override
    public int compareTo(Cliente ob) {
        return this.dni.compareTo(ob.getDni());
    }
   

    @Override
    public boolean equals(Object obj) {
        Cliente other = (Cliente) obj;
        if (this.dni.equals(other.getDni())) {
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return this.dni + " " + this.nome + ". "  + "Idade: " + this.idade + ". Soldo " + this.sueldo ;
    }
    


}
