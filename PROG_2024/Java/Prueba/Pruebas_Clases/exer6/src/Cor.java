public enum Cor {

    NEGRO("Negro"),
    BRANCO("Branco"), 
    AZUL("Azul"), 
    VERMELLO("Vermello"), 
    VERDE("Verde");
    
    String nomeCor;

    private Cor(String nomeCor) {
        this.nomeCor = nomeCor;
    }

    public String getNomeCor() {
        return nomeCor;
    }

    
}


