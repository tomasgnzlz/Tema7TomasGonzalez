/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Record.java to edit this template
 */
package robotVico_stream;

/**
 *
 * @author tomas
 */
public record Robot( int numSerie, int vida) implements Comparable<Robot> {

    @Override
    public int compareTo(Robot o) {
        return Integer.compare(numSerie, o.numSerie);
    }

}
