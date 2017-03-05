package Controllers;

import Models.BD;
import Models.Canciones;
import Models.Cantante;
import Views.MainView;
import Models.Consultas;
import com.db4o.ObjectContainer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import java.util.ArrayList;

//http://panamahitek.com/crear-un-archivo-jar-con-librerias-externas/
public class Controller {

    private final MainView vista;
    private final Consultas consulta;
    private final ObjectContainer bd;
    private final JDialog jdp;

    private ArrayList<Canciones> listaCanciones;
    private ArrayList<Cantante> listaCantantes;

    private int accion = 0;

    Controller(MainView mainView) {
        vista = mainView;
        consulta = new Consultas();
        bd = new BD().conexion();
        jdp = vista.jDialog1;
        jdp.setSize(700, 175);

    }

    void iniciar() {
        //listaCanciones = consulta.mostrarCanciones(bd);
        listaCantantes = consulta.mostrarCantantes(bd);
        /*BOTONES CANCION*/
        vista.insecancion.addActionListener((ActionEvent ActionEvent) -> {
            jdp.setVisible(true);
            accion = 1;
        });
        vista.modcancion.addActionListener((ActionEvent ActionEvent) -> {
            jdp.setVisible(true);
            accion = 2;
        });
        vista.delcancion.addActionListener((ActionEvent ActionEvent) -> {

            boolean deleteOk = consulta.borrarCanciones(bd, listaCanciones.get(0));
            if (!deleteOk) {
                JOptionPane.showMessageDialog(vista, "Error al borrar la canción", "Error", JOptionPane.ERROR_MESSAGE);
            }
            vista.tablaCanciones.setModel(consulta.tablaCanciones(bd));
            vista.tablaCantante.setModel(consulta.tablaCantantes(bd));
            listaCanciones = consulta.mostrarCanciones(bd);
        });

        /*BOTONES CANTANTE*/
        vista.insecanta.addActionListener((ActionEvent ActionEvent) -> {
            jdp.setVisible(true);
            accion = 3;
        });
        vista.modcanta.addActionListener((ActionEvent ActionEvent) -> {
            jdp.setVisible(true);
            accion = 4;
        });
        vista.delcanta.addActionListener((ActionEvent ActionEvent) -> {
            vista.tablaCanciones.setModel(consulta.tablaCanciones(bd));
            vista.tablaCantante.setModel(consulta.tablaCantantes(bd));
        });

        /**/
        vista.btnAceptar.addActionListener((ActionEvent ActionEvent) -> {
            String namecancion = vista.txtNameCancion.getText();
            String duracion = vista.txtDuracion.getText();
            String namecantante = vista.txtNameCantante.getText();
            String estilo = vista.txtEstiloM.getText();
            switch (accion) {
                case 1://INSERTARCANCION

                    Cantante cantaor1 = new Cantante(namecantante, estilo);
                    Canciones cancion1 = new Canciones(namecancion, Integer.parseInt(duracion), cantaor1);

                    boolean insertCancionOk = consulta.insertCanciones(bd, cancion1.getTitulo(), (int) cancion1.getDuracion(), cantaor1);
                    if (!insertCancionOk) {
                        JOptionPane.showMessageDialog(vista, "Error al insertar la canción", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                    listaCanciones = consulta.mostrarCanciones(bd);
                    vista.tablaCanciones.setModel(consulta.tablaCanciones(bd));
                    vista.tablaCantante.setModel(consulta.tablaCantantes(bd));
                    resetDialog();
                    break;
                case 2://UPDATECANCION
                    Cantante cantaor2 = new Cantante(namecantante, estilo);
                    Canciones cancion2 = new Canciones(namecancion, Integer.parseInt(duracion), cantaor2);

                    boolean updateCancionOk = consulta.modificarCanciones(bd, listaCanciones.get(0), cancion2.getTitulo(), (int) cancion2.getDuracion(), cantaor2);
                    if (!updateCancionOk) {
                        JOptionPane.showMessageDialog(vista, "Error al modificar la canción", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                    listaCanciones = consulta.mostrarCanciones(bd);
                    vista.tablaCanciones.setModel(consulta.tablaCanciones(bd));
                    vista.tablaCantante.setModel(consulta.tablaCantantes(bd));
                    resetDialog();
                    break;
                case 3://INSERTARCANTANTE
                    Cantante cantaor3 = new Cantante(namecantante, estilo);
                    Canciones cancion3 = new Canciones(namecancion, Integer.parseInt(duracion), cantaor3);

                    boolean insertCantanteOk = consulta.insertCanciones(bd, cancion3.getTitulo(), (int) cancion3.getDuracion(), cantaor3);
                    if (!insertCantanteOk) {
                        JOptionPane.showMessageDialog(vista, "Error al insertar el cantante", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                    listaCantantes = consulta.mostrarCantantes(bd);
                    vista.tablaCanciones.setModel(consulta.tablaCanciones(bd));
                    vista.tablaCantante.setModel(consulta.tablaCantantes(bd));
                    resetDialog();

                    break;
                case 4://UPDATECANTANTE
                    Cantante cantaor4 = new Cantante(namecantante, estilo);
                    Canciones cancion4 = new Canciones(namecancion, Integer.parseInt(duracion), cantaor4);

                    boolean updateCantanteOk = consulta.modificarCantantes(bd, listaCantantes.get(0), cantaor4.getNombre(), cantaor4.getEstiloMusical());
                    if (!updateCantanteOk) {
                        JOptionPane.showMessageDialog(vista, "Error al modificar el cantante", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                    listaCantantes = consulta.mostrarCantantes(bd);
                    vista.tablaCanciones.setModel(consulta.tablaCanciones(bd));
                    vista.tablaCantante.setModel(consulta.tablaCantantes(bd));
                    break;
                default:
                    resetDialog();
                    break;
            }
        });
        vista.btnCancelar.addActionListener((ActionEvent actionEvent) -> {
            resetDialog();
        });

        vista.tablaCanciones.setModel(consulta.tablaCanciones(bd));
        vista.tablaCantante.setModel(consulta.tablaCantantes(bd));

        vista.setVisible(true);
    }

    public void resetDialog() {
        vista.txtNameCancion.setText("");
        vista.txtDuracion.setText("");
        vista.txtNameCantante.setText("");
        vista.txtEstiloM.setText("");
        accion = 0;
        vista.tablaCanciones.setModel(consulta.tablaCanciones(bd));
        vista.tablaCantante.setModel(consulta.tablaCantantes(bd));
        jdp.dispose();
    }
}
