import java.util.*;

public class Pregunta {
    private String texto;
    private List<String> respostas;
    private Map<String,Integer> votos;


// --- Constructores ---

public Pregunta(String texto) {
    this.texto = texto;
    this.respostas = new ArrayList<>() ;
    this.votos = new HashMap<>();
}

// --- Getters & Setters ---

public String getTexto() {
    return texto;
}

public void setTexto(String texto) {
    this.texto = texto;
}

public List<String> getRespostas() {
    return respostas;
}

public void setRespostas(List<String> respostas) {
    this.respostas = respostas;
}

public Map<String, Integer> getVotos() {
    return votos;
}

public void setVotos(Map<String, Integer> votos) {
    this.votos = votos;
}


// --- Métodos ---

    public void engadirPregunta(String pregunta){
        
    }


}
