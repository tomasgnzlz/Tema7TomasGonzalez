/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package robotVico_stream;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.stream.Stream;

/**
 *
 * @author tomas
 */
public class Main {

    public static void main(String[] args) {
        
        List<Robot> lista = getListaRobots(20);
        System.out.println("Imprimo todos los robots creados \n");
        lista.forEach(System.out::println);
//        
//        //Ordenar
//        Collections.sort(lista, (r1,r2)-> Integer.compare(r1.vida(), r2.vida()));
//        System.out.println("\n Ordenados por porcentaje de vida de menor a mayor \n");
//        lista.forEach(System.out::println);
//        //
//        Comparator<Robot> menorMayor = (r1,r2) -> Integer.compare(r1.vida(), r2.vida());
//        Collections.sort(lista,menorMayor.reversed());
//        System.out.println("\n Ordenados por porcentaje de vida de mayor a menor \n");
//        lista.forEach(System.out::println);
//        //
//        System.out.println("\n Robots con más del 50% de vida\n");
//        // Con ForEach normal. 
//        System.out.println("        FORMA 1 ");
//        for (Robot r : lista) {
//            if (r.vida() >=50) {
//                System.out.println(r);
//            }
//        }
//        // Hacer lo mismo pero de manera diferente(STREAM)
//        System.out.println("\n        FORMA 2 ");
//        lista.stream()
//                .filter(r-> r.vida()>=50)       // le digo el predicate
//                .forEach(System.out::println); // Se van mostrando aquellos que cumplan el predicado
//        
//        // --
//        System.out.println("\n 3 Robots que tengan el mayor % de vida");
//        lista.stream()
//                .limit(3)
//                    .forEach(r->System.out.println(r.numSerie()));
//        // LOS STREAM CON SANGRÍA.
//        System.out.println("\n Usando API Stream Robots con más de un 50% de vida \n");
//        Stream<Robot> streamRobot = lista.stream();
//        Stream<Robot> streamRobtosFiltrados = streamRobot.filter(r->r.vida()>=50);
//        streamRobtosFiltrados.forEach(System.out::println);
//                
//                
//        lista.stream()
//                .filter(r-> r.vida()>=50);
//        
    }
  
    
    
    
    
    
    
    
    
    public static ArrayList<Robot> getListaRobots(int num) {
        var listaRobots = new ArrayList<Robot>();
        Random random=new Random();
        if (num <=0) {
            throw new IllegalArgumentException("num no valido");
        }
        for (int i = 0; i < num; i++) {
            listaRobots.add(new Robot(random.nextInt(0, 5000), random.nextInt(1, 101)));
        }
        
        return listaRobots;
        
        
    }
}

