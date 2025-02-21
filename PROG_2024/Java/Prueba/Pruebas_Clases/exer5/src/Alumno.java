public class Alumno {
    
    private String nome;
    private String apelidos;
    private double[] notas;
    private boolean[] notasEngadidas;
    private String expediente;
    private static int expediente_aux = 101;
    

    // Getters

    public Alumno(String nome, String apelidos) {
        this.nome = nome;
        this.apelidos = apelidos;
        
        notas = new double[3];
        notasEngadidas = new boolean[3];
        for(int i=0; i< notasEngadidas.length; i++){
            notasEngadidas[i] = false;
        }
    

        this.expediente = String.valueOf(expediente_aux);
        expediente_aux++;
    }
    public String getNome() {
        return nome;
    }
    public String getApelidos() {
        return apelidos;
    }
    public String getExpediente() {
        return expediente;
    }
    public double getMedia(){
        double media = 0;
        int num = 0;
        for(int i=0;i < notasEngadidas.length;i++){
            if (notasEngadidas[i] == true) {
                media += notas[i];
                num++;
            }
        }
        if (num == 0) {
            return 0;
        }
        return media / num;
    }

    
    // Setters

    public void setNota1(double nota){
        this.setNota(nota, 0);
    }
    public void setNota2(double nota){
        this.setNota(nota, 1);
    }
    public void setNota3(double nota){
        this.setNota(nota, 2);
    }

    private void setNota(double nota, int trimestre){
        if (nota >=0 && nota <= 10) {
            this.notas[trimestre] = nota;
            this.notasEngadidas[trimestre] = true;
        }
    }

    // Métodos

    public boolean aprobado(){
        int num = 0;
        for(int i=0;i < notasEngadidas.length;i++){
            if (notasEngadidas[i] = true) {
                num++;
            }
        }
        if (num == 3 && getMedia() >= 5) {
            return true;
        }
        else{
            return false;
        }
    }

    
}
