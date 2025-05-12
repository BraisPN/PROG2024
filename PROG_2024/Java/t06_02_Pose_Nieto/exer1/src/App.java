import java.util.ArrayList;

public class App {
    public static void main(String[] args) throws Exception {
        
            String textoAutores = "";
            boolean primeiro = true;
            for (String a : autores) {
                if (!primeiro) {
                    textoAutores += "; ";
                }
                textoAutores += a;
                primeiro = false;
                
            }
            System.out.println(textoAutores);
    
    }
}
