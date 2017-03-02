package Models;

import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;
import com.db4o.ext.Db4oException;
import com.db4o.query.Query;

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
    /**
     * Recoge todos los cantantes de la BD.
     *
     * @param bd ObjectContainer
     * @return ArrayList<Cantante>
     */
    public ArrayList<Cantante> mostrarCantantes(ObjectContainer bd) {
        ArrayList<Cantante> cantantes = new ArrayList<>();
        ObjectSet<Cantante> set = bd.queryByExample(new Cantante("Manuel", "Flamenco"));
        set.forEach(cantantes::add);
        return cantantes;
    }

    /**
     * Inserta un nuevo cantante en la BD.
     *
     * @param bd            ObjectContainer
     * @param nombre        String
     * @param estiloMusical String
     * @return boolean
     */
    public boolean insertarCantantes(ObjectContainer bd, String nombre, String estiloMusical) {
        Cantante cantante = new Cantante(nombre, estiloMusical);
        // TODO: fix this duplicated code
        //noinspection Duplicates
        try {
            bd.store(cantante);
            bd.commit();
            return true;
        } catch (Db4oException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean modificarCantantes(ObjectContainer bd, Cantante cantante, String nuevoNombre, String nuevoEstiloMusical) {
        Cantante cantanteActualizar = (Cantante) bd.queryByExample(cantante).next();
        cantante.setNombre(nuevoNombre);
        cantante.setEstiloMusical(nuevoEstiloMusical);
        // TODO: fix this duplicated code
        //noinspection Duplicates
        try {
            bd.store(cantanteActualizar);
            bd.commit();
            return true;
        } catch (Db4oException e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * Borra un cantante de la BD.
     *
     * @param bd       ObjectContainer
     * @param cantante Cantante
     * @return boolean
     */
    public boolean borrarCantantes(ObjectContainer bd, Cantante cantante) {
        // TODO: fix this duplicated code
        //noinspection Duplicates
        try {
            bd.delete(bd.queryByExample(cantante));
            bd.commit();
            return true;
        } catch (Db4oException e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * ***********ADICIONALES**************
     */
    /**
     * Devuelve una lista de canciones por su titulo.
     *
     * @param bd            ObjectContainer
     * @param nombreCancion String
     * @return ArrayList<Canciones>
     */
    public ArrayList<Canciones> buscaCancionNombre(ObjectContainer bd, String nombreCancion) {
        ArrayList<Canciones> canciones = new ArrayList<>();
        ObjectSet<Canciones> set = bd.queryByExample(new Canciones(nombreCancion, 0));
        set.forEach(canciones::add);
        return canciones;
    }

    /**
     * Busca canciones por nombre del cantante.
     *
     * @param bd             ObjectContainer
     * @param nombreCantante String
     * @return ArrayList<Canciones>
     */
    public ArrayList<Canciones> buscaCantanteNombre(ObjectContainer bd, String nombreCantante) {
        ArrayList<Canciones> canciones = new ArrayList<>();
        Canciones cancionQuery = new Canciones(null, 0);
        cancionQuery.setCantante(new Cantante(nombreCantante, null));
        ObjectSet<Canciones> set = bd.queryByExample(cancionQuery);
        set.forEach(canciones::add);
        return canciones;
    }


    /**
     * DB4O no tiene para buscar entre dos valores, solo mayores o menores pero una combinación de estos.
     * Es mas rapido recogerlas todas y hacer el filtro en el código.
     *
     * @param bd        ObjectContainer
     * @param valorAlto int
     * @param valorBajo int
     * @return ArrayList<Canciones>
     */
    public ArrayList<Canciones> buscaCancionDuracion(ObjectContainer bd, int valorAlto, int valorBajo) {
        ArrayList<Canciones> canciones = new ArrayList<>();
        ObjectSet<Canciones> set = bd.queryByExample(new Canciones(null, 0));
        set.forEach((can) -> {
            if (can.getDuracion() < valorAlto && can.getDuracion() > valorBajo) {
                set.add(can);
            }
        });
        return canciones;
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
