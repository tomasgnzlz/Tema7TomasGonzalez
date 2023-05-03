/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package intnento;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Usuario
 */
public class Prueba2 {

    public static void main(String[] args) {

        Empleado e1 = new Empleado("Ana", "García", "12345678A", "Analista", LocalDate.of(2021, 4, 15), LocalDate.of(2022, 4, 15), "123456789", false, true);
        Empleado e2 = new Empleado("Jorge", "Martín", "23456789B", "Programador", LocalDate.of(2020, 3, 20), LocalDate.of(2022, 7, 10), "234567890", true, false);
        Empleado e3 = new Empleado("María", "Fernández", "34567890C", "Diseñador", LocalDate.of(2019, 2, 5), LocalDate.of(2021, 12, 31), "345678901", false, false);
        Empleado e4 = new Empleado("David", "Hernández", "45678901D", "Ingeniero", LocalDate.of(2022, 1, 1), null, "456789012", true, true);
        Empleado e5 = new Empleado("Laura", "Sánchez", "56789012E", "Consultor", LocalDate.of(2020, 5, 10), LocalDate.of(2023, 5, 9), "567890123", false, true);
        Empleado e6 = new Empleado("Manuel", "Romero", "67890123F", "Gestor", LocalDate.of(2018, 11, 1), LocalDate.of(2021, 11, 1), "678901234", true, false);
        Empleado e7 = new Empleado("Elena", "López", "78901234G", "Técnico", LocalDate.of(2019, 8, 15), LocalDate.of(2022, 8, 15), "789012345", false, false);
        Empleado e8 = new Empleado("Sara", "Jiménez", "89012345H", "Administrativo", LocalDate.of(2022, 3, 1), LocalDate.of(2023, 3, 1), "890123456", true, true);
        Empleado e9 = new Empleado("Pablo", "Castillo", "90123456I", "Analista", LocalDate.of(2020, 6, 1), LocalDate.of(2023, 6, 1), "901234567", false, true);
        Empleado e10 = new Empleado("Luis", "González", "01234567J", "Programador", LocalDate.of(2022, 2, 1), null, "012345678", true, false);
        Empleado e11 = new Empleado("Isabel", "Pérez", "12345678K", "Diseñador", LocalDate.of(2021, 1, 1), LocalDate.of(2023, 12, 31), "123456789", false, false);
        Empleado e12 = new Empleado("Miguel", "Ruiz", "23456789L", "Ingeniero", LocalDate.of(2020, 7, 1), LocalDate.of(2023, 6, 30), "234567890", true, true);
        Empleado e13 = new Empleado("Carmen", "Vázquez", "34567890M", "Consultor", LocalDate.of(2019, 9, 1), LocalDate.of(2022, 9, 1), "345678901", false, true);
        Empleado e14 = new Empleado("tomas", "Gonzalez", "12345678A", "Informatico", LocalDate.now(), LocalDate.now().plusYears(1), "987654321", true, true);

        List<Empleado> listaEmpleados = new ArrayList<>();
        listaEmpleados.add(e1);
        listaEmpleados.add(e2);
        listaEmpleados.add(e3);
        listaEmpleados.add(e4);
        listaEmpleados.add(e5);
        listaEmpleados.add(e6);
        listaEmpleados.add(e7);
        listaEmpleados.add(e8);
        listaEmpleados.add(e9);
        listaEmpleados.add(e10);
        listaEmpleados.add(e11);
        listaEmpleados.add(e12);
        listaEmpleados.add(e13);
        listaEmpleados.add(e14);


    }

}
