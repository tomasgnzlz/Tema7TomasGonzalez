/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vehiculos;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 *
 * @author tomas
 */
public class PruebaVehiculos {

    public static void main(String[] args) {

        // A)
        // Crea una lista de vehiculos y guardalos en una lista de tipo vehiculos. 
        List<Vehiculos> listaVehiculos = new ArrayList<>();
        // Crea una lista de vehiculos. 
        listaVehiculos(listaVehiculos);
        for (Vehiculos listaVehiculo : listaVehiculos) {
            System.out.println(listaVehiculo);
        }

        // A partir de la lista de vehiculos, creo un fichero vehiculos.txt donde guardate la lista de vehiculos entera. 
        ServiciosFicheros.crearArchivoDeVehiculos("vehiculos.txt", listaVehiculos);

        // B)
        // Creo una nueva lista pero está ordenada por marca.
        System.out.println("\n --------------- LISTA ORDENADA --------------- \n");
        List<Vehiculos> listaVehiculosOrdenada = new ArrayList<>();
        listaVehiculos(listaVehiculosOrdenada);
        Comparator<Vehiculos> porMarca = (r1, r2) -> r1.getMarca().compareToIgnoreCase(r2.getMarca());
        Collections.sort(listaVehiculosOrdenada, porMarca);
        for (Vehiculos listaVehiculo : listaVehiculosOrdenada) {
            System.out.println(listaVehiculo);
        }

        ServiciosFicheros.crearArchivoDeVehiculos("vehiculosOrdenado.txt", listaVehiculos);

        // C)
        // Creo 3 nuevos ficheros, ordenando en cada uno de ellos los vehiculos del mismo tipo. 
        List<Vehiculos> listaVehiculos_C = new ArrayList<>(listaVehiculos);

        // Creo las listas en las que se meterán los datos del fichero cn respecto a cada tipo de vehiculo. 
        List<Vehiculos> turismos = new ArrayList<>();
        List<Vehiculos> deportivos = new ArrayList<>();
        List<Vehiculos> furgonetas = new ArrayList<>();

        // Con este bucle filtramos todos nuestros vehiculos segun el tipo al que pertenece cada uno de ellos. 
        for (Vehiculos v : listaVehiculos_C) {
            switch (v.getTipoVehiculo()) {
                case 0:
                    turismos.add(v);
                    break;
                case 1:
                    deportivos.add(v);
                    break;
                case 2:
                    furgonetas.add(v);
                    break;
            }
        }

        // Guardar cada lista en un archivo separado
        ServiciosFicheros.crearArchivoDeVehiculos("vehiculosTurismos.txt", turismos);
        ServiciosFicheros.crearArchivoDeVehiculos("vehiculosDeportivos.txt", deportivos);
        ServiciosFicheros.crearArchivoDeVehiculos("vehiculosFurgonetas.txt", furgonetas);

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
