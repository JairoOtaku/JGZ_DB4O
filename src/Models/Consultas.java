package Models;

import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;

import java.util.ArrayList;

public class Consultas {

//    public void x(ObjectContainer bd) {}
    /**
     * ***********BASICO DE CANCIONES**************
     */
    /**
     * Recogemos todas las canciones de la base de datos.
     *
     * @param bd ObjectContainer
     * @return ArrayList<Canciones>
     */
    public ArrayList<Canciones> mostrarCanciones(ObjectContainer bd) {
        ArrayList<Canciones> canciones = new ArrayList<>();
        ObjectSet<Canciones> set = bd.queryByExample(new Canciones(null, 0));
        set.forEach(canciones::add);
        return canciones;
    }

    public void insertCanciones(ObjectContainer bd, String nombre, int duracion, Cantante cantante) {

    }

    public void modificarCanciones(ObjectContainer bd) {

    }

    public void borrarCanciones(ObjectContainer bd) {

    }

    /**
     * ***********BASICO DE CANTANTES**************
     */
    public void mostrarCantantes(ObjectContainer bd) {

    }

    public void insertarCantantes(ObjectContainer bd) {

    }

    public void modificarCantantes(ObjectContainer bd) {

    }

    public void borrarCantantes(ObjectContainer bd) {

    }

    /**
     * ***********ADICIONALES**************
     */
    public void buscaCancionNombre(ObjectContainer bd) {

    }

    public void buscaCantanteNombre(ObjectContainer bd) {

    }

    public void buscaCancionDuracion(ObjectContainer bd) {

    }
}

//    jbutton.actionlistener (ObjectContainer bd) {
//
//        Canciones c1 = new canciones("", 123);
//        Cantante canta1 = new cantante();
//        c1.setcantante(canta1);
//
//        bd.store(c1);
//    }
