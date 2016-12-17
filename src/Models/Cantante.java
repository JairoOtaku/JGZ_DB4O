
package Models;

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
