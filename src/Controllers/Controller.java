package Controllers;

import Models.BD;
import Models.Canciones;
import Models.Cantante;
import Views.MainView;
import Models.Consultas;
import com.db4o.ObjectContainer;

import javax.swing.*;
import java.util.ArrayList;

//http://panamahitek.com/crear-un-archivo-jar-con-librerias-externas/
public class Controller {

    private final MainView vista;
    private final Consultas consulta;
    private final ObjectContainer bd;
    private final JDialog jdp;

    private ArrayList<Canciones> listaCanciones;

    Controller(MainView mainView) {
        vista = mainView;
        consulta = new Consultas();
        bd = new BD().conexion();
        jdp = vista.jDialog1;
    }

    void iniciar() {
        Cantante cantaor = new Cantante("manuel", "Flamenco");
        boolean insertOk = consulta.insertCanciones(bd, "nombre", 14, cantaor);
        if(!insertOk){
            JOptionPane.showMessageDialog(vista, "Error al insertar la canción", "Error", JOptionPane.ERROR_MESSAGE);
        }
        listaCanciones = consulta.mostrarCanciones(bd);
        boolean updateOk = consulta.modificarCanciones(bd, listaCanciones.get(0), "Titulo nuevo", 10, cantaor);
        if(!updateOk){
            JOptionPane.showMessageDialog(vista, "Error al actualizar la canción", "Error", JOptionPane.ERROR_MESSAGE);
        }
        listaCanciones = consulta.mostrarCanciones(bd);
        boolean deleteOk = consulta.borrarCanciones(bd, listaCanciones.get(0));
        if(!deleteOk){
            JOptionPane.showMessageDialog(vista, "Error al actualizar la canción", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

}
