/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vehiculos;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author tomas
 */
public class PruebaVehiculos {

    public static void main(String[] args) {

        // Crea una lista de vehiculos y guardalos en una lista de tipo vehiculos. 
        List<Vehiculos> listaVehiculos = new ArrayList<>();
        // Crea una lista de vehiculos. 
        listaVehiculos(listaVehiculos);
        for (Vehiculos listaVehiculo : listaVehiculos) {
            System.out.println(listaVehiculo);
        }
        
       // A partir de la lista de vehiculos, creo un fichero vehiculos.txt donde guardate la lista de vehiculos entera. 
       ServiciosFicheros.crearArchivoDeVehiculos("vehiculos.txt", listaVehiculos); 
        
        
    }

    public static List<Vehiculos> listaVehiculos(List<Vehiculos> listavehiculos) {
        // 0 turismo, 1 deportivo, 2 furgoneta. 
        // 10  vehiculos turismo.
        listavehiculos.add(new Vehiculos(0, "oipu789", "Seat", "ibiza", "blanco"));
        listavehiculos.add(new Vehiculos(0, "kljh987", "Seat", "ibiza", "blanco"));
        listavehiculos.add(new Vehiculos(0, "eisj948", "Seat", "ibiza", "blanco"));
        listavehiculos.add(new Vehiculos(0, "jshd847", "Seat", "ibiza", "blanco"));
        listavehiculos.add(new Vehiculos(0, "jhgf543", "Seat", "ibiza", "blanco"));
        listavehiculos.add(new Vehiculos(0, "sdfg456", "Seat", "ibiza", "blanco"));
        listavehiculos.add(new Vehiculos(0, "ñlfk654", "Seat", "ibiza", "blanco"));
        listavehiculos.add(new Vehiculos(0, "dfkf578", "Seat", "ibiza", "blanco"));
        listavehiculos.add(new Vehiculos(0, "azxs756", "Seat", "ibiza", "blanco"));

        // 10  vehiculos deportivos.
        listavehiculos.add(new Vehiculos(1, "oiuo987", "Kia", "Ceed", "Negro"));
        listavehiculos.add(new Vehiculos(1, "abkz123", "Kia", "Ceed", "Negro"));
        listavehiculos.add(new Vehiculos(1, "qwert567", "Seat", "Ibiza", "Rojo"));
        listavehiculos.add(new Vehiculos(1, "yxcv987", "Renault", "Captur", "Blanco"));
        listavehiculos.add(new Vehiculos(1, "poiuyt321", "Ford", "Focus", "Azul"));
        listavehiculos.add(new Vehiculos(1, "mnbv456", "Hyundai", "Tucson", "Gris"));
        listavehiculos.add(new Vehiculos(1, "lkjhgf654", "Volkswagen", "Golf", "Negro"));
        listavehiculos.add(new Vehiculos(1, "zxcvbn789", "Toyota", "Corolla", "Rojo"));
        listavehiculos.add(new Vehiculos(1, "asdfgh210", "Peugeot", "308", "Blanco"));
        listavehiculos.add(new Vehiculos(1, "poiuyt753", "Citroen", "C3", "Gris"));

        // 10  vehiculos furgonetas.
        listavehiculos.add(new Vehiculos(2, "abkz123", "Kia", "Ceed", "Negro"));
        listavehiculos.add(new Vehiculos(2, "xycd789", "Toyota", "Corolla", "Blanco"));
        listavehiculos.add(new Vehiculos(2, "poiu951", "Renault", "Clio", "Rojo"));
        listavehiculos.add(new Vehiculos(2, "mnbv753", "Ford", "Fiesta", "Azul"));
        listavehiculos.add(new Vehiculos(2, "lkjh246", "Volkswagen", "Golf", "Gris"));
        listavehiculos.add(new Vehiculos(2, "fdas852", "Audi", "A3", "Negro"));
        listavehiculos.add(new Vehiculos(2, "qwer369", "Mercedes-Benz", "Clase C", "Blanco"));
        listavehiculos.add(new Vehiculos(2, "zxpo468", "BMW", "Serie 3", "Gris"));
        listavehiculos.add(new Vehiculos(2, "hjkl147", "Hyundai", "i30", "Rojo"));
        listavehiculos.add(new Vehiculos(2, "uejd147", "Hyundai", "i30", "Rojo"));

        return listavehiculos;
    }
}
