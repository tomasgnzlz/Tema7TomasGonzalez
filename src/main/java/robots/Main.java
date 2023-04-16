/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package robots;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author jorge
 */
public class Main {

    public static void main(String[] args) {

        // Creo la lista con 50 robots aleatorios
        List<Robot> lista = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            lista.add(new Robot());
        }

        // Imprimo todos los robots de la lista por consola en el formato puesto
        System.out.println("Imprimo los robots de la lista 1:");
        for (Robot robot : lista) {
            System.out.println(robot);
        }
        System.out.println("--------------------------------------------------");

        // Guardo los robots en un fichero .txt
        String fichero = "robots.txt";

        try ( BufferedWriter flujo = new BufferedWriter(new FileWriter(fichero))) {
            for (Robot r : lista) {
                flujo.write(r.toString());
                flujo.newLine();
            }
            flujo.flush();
        } catch (IOException ioe) {
            System.out.println(ioe.getMessage());
        }

        // Leo el fichero .txt que he creado y hago otra lista de robots igual con 
        System.out.println("Leo el fichero antes creado:");
        String linea;
        String[] tokens;
        List<Robot> lista2 = new ArrayList<>();
        try ( Scanner datosFichero = new Scanner(new FileReader(fichero))) {

            while (datosFichero.hasNextLine()) {
                linea = datosFichero.nextLine(); // Leo la linea que toca
                System.out.println(linea); // Imprimo la linea
                tokens = linea.split("(-vida:|Robot:)");
                // Imprimo los dos valores que usaré para crear los robots nuevos para comprobar
                System.out.println(tokens[1] + " " + tokens[2]);
                lista2.add(new Robot(tokens[1], Integer.parseInt(tokens[2])));
            }

        } catch (FileNotFoundException fnfe) {
            System.out.println(fnfe.getMessage());
        }

        // Imprimo la lista 2 para comprobar si he filtrado bien con el regex
        System.out.println("Imprimo la lista 2:");
        for (Robot robot : lista2) {
            System.out.println(robot);
        }

    }
}
