/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vehiculos;

import java.util.Objects;

/**
 *
 * @author tomas
 */
public class Vehiculos/* implements Comparable<Vehiculos>*/{

    private int tipoVehiculo;
    private String matricula;
    private String marca;
    private String modelo;
    private String color;

    public Vehiculos(int tipoVehiculo, String matricula, String marca, String modelo, String color) {
        this.tipoVehiculo = tipoVehiculo;
        this.matricula = matricula;
        this.marca = marca;
        this.modelo = modelo;
        this.color = color;
    }

    // Getters & Setters.
    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

   
    // ToString. 
    @Override
    public String toString() {
        // return "Vehiculos{" + "tipoVehiculo=" + tipoVehiculo + ", matricula=" + matricula + ", marca=" + marca + ", modelo=" + modelo + ", color=" + color + '}';
        return " " + tipoVehiculo + " - " + matricula + ":" + marca + ":" + modelo + ":" + color + ":";
    }
/*
    // Implemento 
    @Override
    public int compareTo(Vehiculos o) {
        return this.marca.compareToIgnoreCase(o.marca);
    }
*/

}
