package Models;

import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;
import com.db4o.ext.Db4oException;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

public class Consultas {

    /**
     * ***********BASICO DE CANCIONES**************
     */
    public ArrayList<Canciones> mostrarCanciones(ObjectContainer bd) {
        ArrayList<Canciones> canciones = new ArrayList<>();
        ObjectSet<Canciones> set = bd.queryByExample(new Canciones(null, 0));
        set.forEach(canciones::add);
        return canciones;
    }

    public DefaultTableModel tablaCanciones(ObjectContainer bd) {
        DefaultTableModel tablita = new DefaultTableModel();

        tablita.addColumn("Titulo");
        tablita.addColumn("Duracion");
        tablita.addColumn("Cantante");

        Object[] fila = new Object[3];

        ArrayList<Canciones> canciones = mostrarCanciones(bd);
        for (Canciones e : canciones) {
            fila[0] = e.getTitulo();
            fila[1] = e.getDuracion();
            fila[2] = e.getCantante().getNombre();

            tablita.addRow(fila);
        }

        return tablita;
    }

    public boolean insertCanciones(ObjectContainer bd, String nombre, int duracion, Cantante cantante) {
        Canciones cancion = new Canciones(nombre, duracion);
        cancion.setCantante(cantante);
        try {
            bd.store(cancion);
            bd.commit();
            return true;
        } catch (Db4oException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean modificarCanciones(ObjectContainer bd, Canciones cancion, String nuevoTitulo, int nuevaDuracion, Cantante nuevoCantante) {
        Canciones cancionActualizar = (Canciones) bd.queryByExample(cancion).next();
        cancionActualizar.setTitulo(nuevoTitulo);
        cancionActualizar.setDuracion(nuevaDuracion);
        cancionActualizar.setCantante(nuevoCantante);
        try {
            bd.store(cancionActualizar);
            bd.commit();
            return true;
        } catch (Db4oException e) {
            e.printStackTrace();
            return false;
        }
    }

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
    public ArrayList<Cantante> mostrarCantantes(ObjectContainer bd) {
        ArrayList<Cantante> cantantes = new ArrayList<>();
        ObjectSet<Cantante> set = bd.queryByExample(new Cantante("Manuel", "Flamenco"));
        set.forEach(cantantes::add);
        return cantantes;
    }

    public DefaultTableModel tablaCantantes(ObjectContainer bd) {
        DefaultTableModel tablita = new DefaultTableModel();
        tablita.addColumn("Nombre");
        tablita.addColumn("Estilo Musical");
        Object[] fila = new Object[2];

        ArrayList<Cantante> cantantes = mostrarCantantes(bd);
        for (Cantante e : cantantes) {
            fila[0] = e.getNombre();
            fila[1] = e.getEstiloMusical();
            tablita.addRow(fila);
        }
        return tablita;
    }

    public boolean insertarCantantes(ObjectContainer bd, String nombre, String estiloMusical) {
        Cantante cantante = new Cantante(nombre, estiloMusical);
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
        try {
            bd.store(cantanteActualizar);
            bd.commit();
            return true;
        } catch (Db4oException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean borrarCantantes(ObjectContainer bd, Cantante cantante) {
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
    public ArrayList<Canciones> buscaCancionNombre(ObjectContainer bd, String nombreCancion) {
        ArrayList<Canciones> canciones = new ArrayList<>();
        ObjectSet<Canciones> set = bd.queryByExample(new Canciones(nombreCancion, 0));
        set.forEach(canciones::add);
        return canciones;
    }

    public ArrayList<Canciones> buscaCantanteNombre(ObjectContainer bd, String nombreCantante) {
        ArrayList<Canciones> canciones = new ArrayList<>();
        Canciones cancionQuery = new Canciones(null, 0);
        cancionQuery.setCantante(new Cantante(nombreCantante, null));
        ObjectSet<Canciones> set = bd.queryByExample(cancionQuery);
        set.forEach(canciones::add);
        return canciones;
    }

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
