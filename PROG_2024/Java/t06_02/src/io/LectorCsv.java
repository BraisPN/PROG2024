package io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import modelo.Lingua;
import modelo.excepcions.ISBNIncorrectoException;
import modelo.libro.Libro;

public abstract class LectorCsv {

    public static List<Libro> leerCsv(String path) {

        ArrayList<Libro> datos = new ArrayList<>();

        // Try con resources
        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            String linha;
            boolean primeiraLinea = true;
            while ((linha = reader.readLine()) != null) {
                // Separar a liña en campos usando a coma como delimitador
                String[] campos = linha.split(",");
                if (!primeiraLinea){
                    String titulo = campos[0];
                    String editorial = campos[1];
                    String lingua = campos[2];
                    Lingua linguaEnu = switch (lingua) {
                        case "INGLES" -> Lingua.INGLES;
                        case "CASTELAN" -> Lingua.CASTELAN;
                        default -> Lingua.GALEGO;
                    };
                    String[] autores = campos[3].split("&");
                    List<String> autoresList = new ArrayList<>();
                    for (String a : autores)
                        autoresList.add(a.trim());
                    String isbn = campos[4];
                    int numExemplares = Integer.valueOf(campos[5]);
                    try {
                        Libro l = new Libro(titulo, editorial, isbn, linguaEnu, numExemplares);
                        datos.add(l);
                    } catch (ISBNIncorrectoException e) {
                        e.printStackTrace();
                    }
                }
                else
                    primeiraLinea = false;
            }
            return datos;
        } catch (IOException e) {
            return new ArrayList<>();
        }
    }

}
