/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */
package ejercicio7d;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.AccessDeniedException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author tomas
 */
public class Main {

    public static void main(String[] args) {
        // A) Crear un directorio llamado 'copias'

        System.out.println("\n Creo un directorio llamado copias \n");
        String nombreDirectorio = "./copias";
        crearDirectorios(nombreDirectorio);

        System.out.println("\n Copio los archivos al directorio creado \n");
        copiarFicheros(nombreDirectorio);

        // B) Mostrar el contenido de los archivos que hay en el directorio creado previamente. 
        System.out.println("\n Muestro el contenido que hay del directorio creado previamente \n");
        listarDirectorio(nombreDirectorio);

        // C) Creo una lista de vehiculos en la cual meto los vehiculos que leo desde el fichero. 
        // Crear una lista de vehículos para cada tipo de vehículo
        List<Vehiculos> vehiculosDeportivos = new ArrayList<>();
        List<Vehiculos> vehiculosFurgonetas = new ArrayList<>();
        List<Vehiculos> vehiculosTurismos = new ArrayList<>();
    }

    // Es igual que el método anterior pero crea los directorios intermedios// necesarios especificados en la ruta// Si el directorio a crear ya existe no hace nada
    // Método para crear directorios.
    public static void crearDirectorios(String ruta) {
        Path directory = Paths.get(ruta);
        try {
            Files.createDirectories(directory);
            System.out.println("El directorio se ha creado correctamente");
        } catch (AccessDeniedException ade) {
            System.out.println("No tiene permisos para crear " + ruta);
        } catch (IOException e) {
            System.out.println("Problema creando el directorio " + e.getMessage());
            System.out.println("Seguramente la ruta está mal escrita o no existe");
        }

    }

    // Copio unos ficheros donde el directorio que se ha creado previamente. 
    public static void copiarFicheros(String rutaCopiar) {

        String[] ficheros = {"vehiculosTurismos.txt", "vehiculosDeportivos.txt", "vehiculosFurgonetas.txt"}; // Array con los nombres de los ficheros a copiar

        // Copiar los ficheros uno por uno
        for (String fichero : ficheros) {
            try {
                File origen = new File(fichero); // Fichero de origen
                File destino = new File(rutaCopiar + "/" + fichero); // Fichero de destino con la ruta completa

                Files.copy(origen.toPath(), destino.toPath(), StandardCopyOption.REPLACE_EXISTING); // Copiar el fichero con opción de reemplazo si ya existe
                System.out.println("Se ha copiado el fichero " + fichero + " a " + rutaCopiar);
            } catch (IOException e) {
                System.err.println("Error al copiar el fichero " + fichero + ": " + e.getMessage());
            }
        }
    }

    //Veo el contenido que hay de los ficheros. 
    public static void listarDirectorio(String ruta) {

        File f = new File(ruta);
        if (f.exists()) {
            // Obtiene los ficheros y directorios dentro de f y los 
            // devuelve en un array
            File[] ficheros = f.listFiles();
            for (File file2 : ficheros) {
                System.out.println("fichero -> " + file2.getName());
            }
        } else {
            System.out.println("El directorio a listar no existe");
        }
    }
    // Este método lo que hace es leer los archivos que hay dentro del directorio y los mete en una lista de vehiculos

//    public static List<Vehiculos> leeFichero(String nombreFichero) {
//        List<Vehiculos> vehiculos = new ArrayList<>();
//        try ( Scanner scanner = new Scanner(new File(nombreFichero))) {
//            while (scanner.hasNextLine()) {
//                String[] linea = scanner.nextLine().trim().split(":");
//                int tipoVehiculo = Integer.parseInt(linea[0].trim());
//                String matricula = linea[1].trim();
//                String marca = linea[2].trim();
//                String modelo = linea[3].trim();
//                String color = linea[4].trim();
//                vehiculos.add(new Vehiculos(tipoVehiculo, matricula, marca, modelo, color));
//            }
//        } catch (FileNotFoundException e) {
//            System.err.println("No se ha encontrado el archivo " + nombreFichero);
//        } catch (NumberFormatException e) {
//            System.err.println("Error al parsear un número en el archivo " + nombreFichero);
//        }
//        return vehiculos;
//    }
    //Método para leer el contenido de los ficheros y ademas los meta dentro de una lista
    public static List<Vehiculos> leeFichero(String fichero, List<Vehiculos> vehiculos) {

        try {
            File archivo = new File("copias/" + fichero);
            Scanner sc = new Scanner(archivo);

            while (sc.hasNextLine()) {
                String linea = sc.nextLine();

                // Comprobamos que la línea tenga el formato correcto
                if (linea.matches("\\d+ - [a-zA-Z0-9]+:[a-zA-Z]+:[a-zA-Z]+:[a-zA-Z]+")) {
                    String[] partes = linea.split(":");
                    String matricula = partes[0].split(" - ")[1];
                    String marca = partes[1];
                    String modelo = partes[2];
                    String color = partes[3];

                    // Convertimos el primer número en un entero
                    int tipo = Integer.parseInt(partes[0].split(" - ")[0]);

                    Vehiculos v = new Vehiculos(tipo, matricula, marca, modelo, color);
                    vehiculos.add(v);
                } else {
                    System.out.println("Error de formato en la línea: " + linea);
                }
            }
            sc.close();
        } catch (FileNotFoundException e) {
            System.out.println("No se ha encontrado el archivo " + fichero);
        }

        return vehiculos;
    }
    /*
        1 - oiuo987:Kia:Ceed:Negro:
        1 - abkz123:Kia:Ceed:Negro:
        1 - qwert567:Seat:Ibiza:Rojo:
        1 - yxcv987:Renault:Captur:Blanco:
        1 - poiuyt321:Ford:Focus:Azul:
        1 - mnbv456:Hyundai:Tucson:Gris:
        1 - lkjhgf654:Volkswagen:Golf:Negro:
        1 - zxcvbn789:Toyota:Corolla:Rojo:
        1 - asdfgh210:Peugeot:308:Blanco:
        1 - poiuyt753:Citroen:C3:Gris:
    */

}
