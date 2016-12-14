package Models;

import com.db4o.*;

public class BD {

    private String basededatos = "JGZ.db4o";

    public void Prueba() {
        ObjectContainer bd = Db4o.openFile(Db4o.newConfiguration(), basededatos);
        //Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), basededatos);
        try {
            //metodos sobre la BD

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            bd.close();
        }
    }

}
