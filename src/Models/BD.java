package Models;

import com.db4o.*;
import com.db4o.config.EmbeddedConfiguration;

public class BD {

    private final String basededatos = "JGZ.db4o";

    public ObjectContainer conexion() {
        EmbeddedConfiguration config = Db4oEmbedded.newConfiguration();
        config.common().objectClass(Canciones.class).cascadeOnDelete(true);
        ObjectContainer bd = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), basededatos);
        return bd;
    }

}
