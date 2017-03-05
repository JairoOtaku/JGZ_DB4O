package Models;

public class Canciones {

    private String Titulo;
    private int Duracion;
    private Cantante cantante;

    public Canciones(String Titulo, int Duracion) {
        this.Titulo = Titulo;
        this.Duracion = Duracion;
    }

    public Canciones(String Titulo, int Duracion, Cantante cantante) {
        this.Titulo = Titulo;
        this.Duracion = Duracion;
        this.cantante = cantante;
    }

    public Canciones() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String toString() {
        return "Canciones{" + "Titulo=" + Titulo + ", Duracion=" + Duracion + ", cantante=" + cantante + '}';
    }

    public void setTitulo(String Titulo) {
        this.Titulo = Titulo;
    }

    public void setDuracion(int Duracion) {
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
