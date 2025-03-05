public static boolean compronarMatricula(String matricula) {
        if (matricula.length() != 7) {
            return false;
        }

        String dixitos = "";
        int contD = 0;

        for(int i = 0; i < 4;i++){
            dixitos += matricula.charAt(i);
        }

        for(int i = 0; i < 4;i++){
            if ( dixitos.charAt(i) <= '9' && dixitos.charAt(i) >= '0') {
                contD += 1;
            }
        }
        
        if (contD == 4) {
            String letras = "";
            int contL = 0;
            for(int i = 0; i < 3;i++){
                letras += matricula.charAt(i+4);
            }
            for(int i = 0; i < 3;i++){
                if ( letras.charAt(i) <= 'Z' && letras.charAt(i) >= 'A') {
                    contL += 1;
                }
            }
            if (contL == 3) {
                return true;
            }
            else{
                return false; 
            }
        }
        else {
            return false;
        }
    }
