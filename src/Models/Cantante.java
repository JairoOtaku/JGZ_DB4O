/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

/**
 *
 * @author Usuario
 */
public class Cantante {

    private String Nombre;
    private String EstiloMusical;

    public Cantante(String Nombre, String EstiloMusical) {
        this.Nombre = Nombre;
        this.EstiloMusical = EstiloMusical;
    }

    @Override
    public String toString() {
        return "Cantante{" + "Nombre=" + Nombre + ", EstiloMusical=" + EstiloMusical + '}';
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public void setEstiloMusical(String EstiloMusical) {
        this.EstiloMusical = EstiloMusical;
    }

    public String getNombre() {
        return Nombre;
    }

    public String getEstiloMusical() {
        return EstiloMusical;
    }
}
