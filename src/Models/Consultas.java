package Models;

import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;
import com.db4o.ext.Db4oException;

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

    public boolean insertCanciones(ObjectContainer bd, String nombre, int duracion, Cantante cantante) {
        Canciones cancion = new Canciones(nombre, duracion);
        cancion.setCantante(cantante);
        // TODO: fix this duplicated code
        //noinspection Duplicates
        try {
            bd.store(cancion);
            bd.commit();
            return true;
        } catch (Db4oException e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * Recibe una cancion y los parametros para su modificación.
     *
     * @param bd            ObjectContainer
     * @param cancion       Canciones
     * @param nuevoTitulo   String
     * @param nuevaDuracion int
     * @param nuevoCantante Cantante
     * @return boolean
     */
    public boolean modificarCanciones(ObjectContainer bd, Canciones cancion, String nuevoTitulo, int nuevaDuracion, Cantante nuevoCantante) {
        Canciones cancionActualizar = (Canciones) bd.queryByExample(cancion).next();
        cancionActualizar.setTitulo(nuevoTitulo);
        cancionActualizar.setDuracion(nuevaDuracion);
        cancionActualizar.setCantante(nuevoCantante);
        // TODO: fix this duplicated code
        //noinspection Duplicates
        try {
            bd.store(cancionActualizar);
            bd.commit();
            return true;
        } catch (Db4oException e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * Borra una canción de la BBDD.
     *
     * @param bd      ObjectContainer
     * @param cancion Canciones
     * @return boolean
     */
    public boolean borrarCanciones(ObjectContainer bd, Canciones cancion) {
        try {
            bd.delete(bd.queryByExample(cancion));
            bd.commit();
            return true;
        } catch (Db4oException e) {
            e.printStackTrace();
            return false;
        }
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
