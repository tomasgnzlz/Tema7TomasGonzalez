/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package robots;

import java.util.Objects;
import java.util.Random;

/**
 *
 * @author jorge
 */
public class Robot {
 
    private static Random aleatorio = new Random();
    private static final int VIDA_MIN = 0;
    private static final int VIDA_MAX = 100;
    private static int contador = 0;
    
    private String id;
    private int vida;

    public Robot() {
        this.id = String.valueOf(++contador);
        this.vida = aleatorio.nextInt(VIDA_MIN, VIDA_MAX + 1);
    }

    public Robot(String id, int vida) {
        this.id = id;
        this.vida = vida;
    }

    // getters y setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getVida() {
        return vida;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }

    // equals y hasCode
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 59 * hash + Objects.hashCode(this.id);
        hash = 59 * hash + this.vida;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Robot other = (Robot) obj;
        if (this.vida != other.vida) {
            return false;
        }
        return Objects.equals(this.id, other.id);
    }

    // toString
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Robot:");
        sb.append(this.id);
        sb.append("-");
        sb.append("vida:");
        sb.append(this.vida);
        return sb.toString();
    }
}
