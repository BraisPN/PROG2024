public class Empregado {
    private String dni;
    private String nome;
    private String ape1;
    private String ape2;
    private double salario;
    private static double irpf = 0.15;

    public Empregado(String dni, String nome, String ape1, String ape2, double salario) {
        if (comprobarDni(dni)) {
            this.dni = dni;
        }
        this.nome = nome;
        this.ape1 = ape1;
        this.ape2 = ape2;
        this.salario = salario;
    }
    public Empregado(String dni, String nome, String ape1, double salario) {
        if (comprobarDni(dni)) {
            this.dni = dni;
        }
        this.nome = nome;
        this.ape1 = ape1;
        this.salario = salario;
    }
    public Empregado(String nome, String ape1, double salario) {
        this.nome = nome;
        this.ape1 = ape1;
        this.salario = salario;
    }

    private boolean comprobarDni(String dni) {
        if (dni.length() != 9) {
            return false;
        }
        
        String numeros = dni.substring(0, 8);
        char letra = dni.charAt(8);

        for( int i=0; i < numeros.length();i++){
            if (numeros.charAt(i) < '0' || numeros.charAt(i) > '9') {
                return false;
            }
        }

        if (!(letra >= 'A' && letra <= 'Z')) {
            return false;
        }

        int numero = Integer.valueOf(numeros);

        String letras = "TRWAGMYFPDXBNJZSQVHLCKE";
        int resto = numero % letras.length();

        char letraReal = letras.charAt(resto);

        if (letra != letraReal) {
            return false;
        }
        return true;
    }

    // Getters
    public String getApelidos(){
        return ape1 + " " + ape2;
    }

    public String getDNI(){
        if (dni == null) {
            return "Sen información";
        }
        return dni;
    }

    public double getSalarioNeto(){
        return salario * (1 - irpf);
    }

    public String getNome() {
        return nome;
    }

    public double getSalario() {
        return salario;
    }

    public static double getIrpf() {
        return irpf;
    }
    
    // Setters

    public void setDni(String dni) {
        if (comprobarDni(dni)) {
            this.dni = dni;
        }
        
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setApe1(String ape1) {
        this.ape1 = ape1;
    }

    public void setApe2(String ape2) {
        this.ape2 = ape2;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public static void setIrpf(double irpf) {
        Empregado.irpf = irpf;
    }

    
}