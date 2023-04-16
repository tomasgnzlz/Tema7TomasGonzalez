/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */
package ejerciciopuntoscardinales;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author tomas
 */
public class PruebaPuntosCardinales {

    public static void main(String[] args) {
        // Leo el fichero localizaciones.txt
        List<String> contenidoFichero = ServiciosFicheros.leerFichero("localizaciones.txt");

        // Con ayuda de una expresionRegular leo el fichero y me quedo solo con los datos que quiero. 
        // Me quedo solo con las localizaciones. 
        Pattern expReg = Pattern.compile("Localizacion: ([N-S-E-O])");
        List<String> puntosCardinales = new ArrayList<>();
        for (String string : contenidoFichero) {
            Matcher match = expReg.matcher(string);
            if (match.find()) {
                String cardinales = match.group(1);
                puntosCardinales.add(cardinales);
            }
        }

        Map<String, Integer> contadorPuntosCardinales = new HashMap<>();

        for (String localizacion : puntosCardinales) {
            Integer contadorLocalizaciones = contadorPuntosCardinales.get(localizacion);
            if (contadorLocalizaciones == null) {
                // Primero vemos si esta localizacion ya está dentro del MAP, si no lo está la metemos dentro
                contadorPuntosCardinales.put(localizacion, 1);
            } else {
                // En caso de que la letra ya este dentro de nuestro map, sumamos un 1  cada vez que vaya apareciendo. 
                contadorPuntosCardinales.put(localizacion, contadorLocalizaciones + 1);
            }
        }

        // Ahora Creo el nuevo fichero con los datos obtenidos tras leer el fichero y meetr su contneido dentro de una lista. 
        for (Map.Entry<String, Integer> entry : contadorPuntosCardinales.entrySet()) {
            System.out.println(entry.getKey() + " - " + entry.getValue());
        }
        
        ServiciosFicheros.generarFichero("FicheroLocalizacionesContador", contadorPuntosCardinales);
    }
}
