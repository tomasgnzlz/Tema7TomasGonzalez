/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */
package intnento;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Usuario
 */
public class intneto {

    public static void main(String[] args) {
        String rutaArchivo = "./datos/RelPerCen.csv";
        List<String> listaPrueba = new ArrayList<>();
        ficheroAListaString(rutaArchivo, listaPrueba);
        listaPrueba.forEach(System.out::println);
        deListaAFicheroTXT(listaPrueba, rutaArchivo);
    }

    // Método para leer un fichero y meterlo dentro de una lista de Strings.
    public static List<String> ficheroAListaString(String ruta, List<String> lista) {
        try ( BufferedReader reader = new BufferedReader(new FileReader(ruta))) {
            String line;
            while ((line = reader.readLine()) != null) {
                lista.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return lista;
    }

    // Método para obtener una lista de String y pasarla a un fichero.
    public static void deListaAFicheroTXT(List<String> lista, String ruta) {
        try ( BufferedWriter flujo = new BufferedWriter(new FileWriter("./datos/prueba.txt"))) {
            for (String string : lista) {
                for (int i = 0; i < lista.size(); i++) {
                    flujo.write(lista.get(i) + "\n");
                }
                flujo.newLine();
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }

}
