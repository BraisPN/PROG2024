package io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Optional;

import controlador.RedeBibliotecas;

public class RedeIO {

    private static final String FILENAME = "data.bin";

    public static void gardar(RedeBibliotecas rede){
        try {

            // Crear fluxo de saída para gardar o obxecto
            FileOutputStream ficheiro = new FileOutputStream(FILENAME);
            ObjectOutputStream obxecto = new ObjectOutputStream(ficheiro);

            // Serializar o obxecto
            obxecto.writeObject(rede);

            // Pechar os fluxos
            obxecto.close();
            ficheiro.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Optional<RedeBibliotecas> cargar(){
        try {
            // Crear fluxo de entrada para ler o obxecto
            FileInputStream ficheiro = new FileInputStream(FILENAME);
            ObjectInputStream obxecto = new ObjectInputStream(ficheiro);

            // Deserializar o obxecto
            RedeBibliotecas rede = (RedeBibliotecas) obxecto.readObject();

            // Pechar os fluxos
            obxecto.close();
            ficheiro.close();

            return Optional.of(rede);

        } catch (Exception e) {
            return Optional.empty();
        }
    }

}
