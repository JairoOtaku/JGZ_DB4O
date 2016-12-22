package Controllers;

import Models.BD;
import Views.MainView;
import Models.Consultas;
import com.db4o.ObjectContainer;

public class Controller {

    private final MainView vista;
    private final Consultas consulta;
    private final ObjectContainer bd;

    Controller(MainView mainView) {
        vista = mainView;
        consulta = new Consultas();
        bd = new BD().conexion();
    }

    void iniciar() {
//
//        consulta.borrarCanciones(bd);
//        consulta.insertCanciones(bd);
//        consulta.modificarCanciones(bd);
//        consulta.mostrarCanciones(bd);
//

        vista.setVisible(true);
    }

//    jbutton.actionlistener (ObjectContainer bd) {
//
//        Canciones c1 = new canciones("", 123);
//        Cantante canta1 = new cantante();
//        c1.setcantante(canta1);
//
//        bd.store(c1);
//    }
}
//http://panamahitek.com/crear-un-archivo-jar-con-librerias-externas/