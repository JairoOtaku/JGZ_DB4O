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
public class Canciones {

    private String Titulo;
    private float Duracion;
    private Cantante cantante;

    public Canciones(String Titulo, float Duracion, Cantante cantante) {
        this.Titulo = Titulo;
        this.Duracion = Duracion;
        this.cantante = cantante;
    }

    @Override
    public String toString() {
        return "Canciones{" + "Titulo=" + Titulo + ", Duracion=" + Duracion + ", cantante=" + cantante + '}';
    }

    public void setTitulo(String Titulo) {
        this.Titulo = Titulo;
    }

    public void setDuracion(float Duracion) {
        this.Duracion = Duracion;
    }

    public void setCantante(Cantante cantante) {
        this.cantante = cantante;
    }

    public String getTitulo() {
        return Titulo;
    }

    public float getDuracion() {
        return Duracion;
    }

    public Cantante getCantante() {
        return cantante;
    }
}
