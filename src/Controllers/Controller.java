
package Controllers;

import Views.MainView;


public class Controller {

    MainView vista;

    Controller(MainView mainView) {
        vista = mainView;
    }

    void iniciar() {
        vista.setVisible(true);
    }

}
