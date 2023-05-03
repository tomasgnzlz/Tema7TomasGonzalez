/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejer7f;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.AccessDeniedException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

/**
 *
 * @author tomas Crea una clase que contenga el método main() y gestione la
 * lectura del fichero adjunto.
 */
public class MainEjercicio {

    public static void main(String[] args) {
        // Creo el directorio donde leeré el fichero. 
        crearDirectorios("./datos");

        // Creo una lista de POJO donde meteré los datos del fichero a leer. 
        List<Empleado> listaPOJO = new ArrayList<>();
        String rutaArchivo = "./datos/RelPerCen.csv";
        leerFicheroCSV(rutaArchivo, ",", listaPOJO);
        // Muestro la lista de empleados
        System.out.println("\n Muestro los datos de los empleados obtenidos del archivoCSV \n");
        listaPOJO.forEach(System.out::println);

        // A) Apartados Sin APIStream
        int numeroTecnologia = numeroProfTecnologia_1(listaPOJO);
        System.out.println("\n Hay " + numeroTecnologia + " profesores de tecnología \n");
        boolean ambos = Informatica_Coordinador_1(listaPOJO);
        System.out.println("¿Hay profesores de informatica y ademas coordinadores? " + ambos);
        System.out.println("\n Lista ordenada. Nombres que contienen J \n");
        nif_J_1(listaPOJO);
        boolean jonh = verificar_Jonh_1(listaPOJO);
        System.out.println("\n ¿Hay algun profesor que se llame jonh?" + jonh + "\n");
        //
        // B) Apartados con APIStream
        System.out.println("\n USNADO API STREAM \n");
        int numeroTecnologia_2 = numeroProfTecnologia_2(listaPOJO);
        System.out.println("\n Hay " + numeroTecnologia_2 + " profesores de tecnología \n");
        Informatica_Coordinador_2(listaPOJO);
        System.out.println("\n Lista ordenada. Nombres que contienen J \n");
        nif_J_2(listaPOJO);
        boolean jonh_2 = verificar_Jonh_2(listaPOJO);
        System.out.println("\n ¿Hay algun profesor que se llame jonh? " + jonh_2 + "\n");

    }

    // Método para crear un directorio donde leeremos el fichero. 
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

    //Método para leer el fichero dado. 
    public static List<Empleado> leerFicheroCSV(String rutaFichero, String elemento_Separador, List<Empleado> lista) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String idFichero = rutaFichero;
        String[] tokens;
        String linea;

        try ( Scanner teclado = new Scanner(new File(idFichero), "ISO-8859-1")) {
            teclado.nextLine(); // Salto la primera linea que contiene el nombre de cada uno de los valores que se encuentran en el fichero. 

            while (teclado.hasNextLine()) {
                Empleado e1 = new Empleado();
                // Guarda la línea completa en un String
                linea = teclado.nextLine();
                // Se guarda en el array de String cada elemento de la
                // línea en función del carácter separador de campos del fichero CSV
                // Convierte en String tokens
                tokens = linea.split(elemento_Separador);

                for (int i = 0; i < tokens.length; i++) {
                    tokens[i] = tokens[i].replaceAll("\"", ""); //Quito espacios
                }

                e1.setApellido(tokens[0]);
                e1.setNombre(tokens[1]);
                e1.setDni(tokens[2]);
                e1.setPuesto(tokens[3]);
                try {
                    e1.setFechaTomaPosicion(LocalDate.parse(tokens[4], formatter));
                    e1.setFechaCese(LocalDate.parse(tokens[5], formatter));
                } catch (DateTimeParseException dtpe) {
                    e1.setFechaTomaPosicion(null);
                    e1.setFechaCese(null);
                }

                e1.setTelefono(tokens[6]);
                e1.setEvaluador(tokens[7].equalsIgnoreCase("Sí"));
                e1.setCoordinador(tokens[8].equalsIgnoreCase("Sí"));
                // una vez tengo separado cada dato y dentro de un token,lo meto dentro de la lista 1 a 1. 
                lista.add(e1);
            }
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
        return lista;
    }

    //                              A)
    // Método para contar el número de profesores de Tecnología.
    public static int numeroProfTecnologia_1(List<Empleado> lista) {
        int contador = 0;
        for (Empleado empleado : lista) {
            if (empleado.getPuesto().equalsIgnoreCase("Tecnología P.E.S.")) {
                contador++;
            }
        }
        return contador;
    }

    // Método para saber si algún profesor/a de Informática es también coordinador
    public static boolean Informatica_Coordinador_1(List<Empleado> lista) {
        int contador = 0;
        for (Empleado empleado : lista) {
            if (empleado.getPuesto().equalsIgnoreCase("Inform�tica P.E.S.")) {
                if (empleado.isCoordinador() == true) {
                    contador++;
                }
            }
        }
        boolean hay = false;
        if (contador >= 1) {
            hay = true;
        } else {
            hay = false;
        }
        return hay;
    }

    // Método para obtener una lista ordenada alfabéticamente con todos los apellidos de los empleados cuyo NIF contenga la letra J.
    public static List<Empleado> nif_J_1(List<Empleado> lista) {
        for (Empleado empleado : lista) {
            if (empleado.getDni().contains("j")) {
                lista.add(empleado);
            }
        }

        Comparator<Empleado> porNombre = (e1, e2) -> e1.getNombre().compareToIgnoreCase(e2.getNombre());
        Collections.sort(lista, porNombre);
        return lista;
    }

    // Método para verificar que ningún profesor se llama "Jonh".
    public static boolean verificar_Jonh_1(List<Empleado> lista) {
        boolean bol = false;
        for (Empleado empleado : lista) {
            if (empleado.getNombre().equalsIgnoreCase("Jonh")) {
                bol = true;
            } else {
                bol = false;
            }
        }
        return bol;
    }

    //                  B)
    public static int numeroProfTecnologia_2(List<Empleado> lista) {
        int contador = (int) lista.stream().filter(p -> p.getPuesto().contains("Tecnología P.E.S.")).count();
        return contador;
    }

    public static void Informatica_Coordinador_2(List<Empleado> lista) {
        boolean ambos = lista.stream().noneMatch(p -> p.getPuesto()
                .contains("Informática")
                && p.isCoordinador() == true);
        if (ambos) {
            System.out.println("Si hay");
        } else {
            System.out.println("No hay");
        }
    }

    public static void nif_J_2(List<Empleado> lista) {
        Comparator<Empleado> porNombre = (e1, e2) -> e1.getNombre().compareToIgnoreCase(e2.getNombre());
        lista.stream().sorted(porNombre).filter(p -> p.getDni().contains("J"));
    }

    public static boolean verificar_Jonh_2(List<Empleado> lista) {
        boolean hay = (boolean) lista.stream().anyMatch(p -> p.getNombre().contains("Jonh"));
        return hay;
    }
}
