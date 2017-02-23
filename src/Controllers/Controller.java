package Controllers;

import Models.BD;
import Models.Cantante;
import Views.MainView;
import Models.Consultas;
import com.db4o.ObjectContainer;
import javax.swing.JDialog;

//http://panamahitek.com/crear-un-archivo-jar-con-librerias-externas/
public class Controller {

    private final MainView vista;
    private final Consultas consulta;
    private final ObjectContainer bd;
    private final JDialog jdp;

    Controller(MainView mainView) {
        vista = mainView;
        consulta = new Consultas();
        bd = new BD().conexion();
        jdp = vista.jDialog1;
    }

    void iniciar() {
        Cantante cantaor = new Cantante("manuel", "Flamenco");
        consulta.insertCanciones(bd, "nombre", 14, cantaor);
    }

}
