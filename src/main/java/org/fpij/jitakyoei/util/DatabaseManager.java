package org.fpij.jitakyoei.util;

import com.db4o.Db4o;
import com.db4o.ObjectContainer;
import com.db4o.ext.ExtObjectContainer;

public class DatabaseManager {
    public static final String PRODUCTION = "fpij.db";
    public static final String TEST       = "test.db";
    public static String ENVIROMENT = PRODUCTION;
    private static ExtObjectContainer db;

    public static ExtObjectContainer getConnection() {
        return open();
    }

    public static ExtObjectContainer open() {
        if (db != null) {
            db.close();
        }
        ObjectContainer objectContainer = Db4o.openFile(ENVIROMENT);
        db = objectContainer.ext();
        return db;
    }

    public static void close() {
        if (db != null && !db.isClosed()) {
            db.close();
        }
    }

    public static void setEnviroment(String env) {
        ENVIROMENT = env;
    }

    // Adicionado o método isDatabaseOpen
    public static boolean isDatabaseOpen() {
        return db != null && !db.isClosed();
    }

    // Atualização no método openDatabase para usar isDatabaseOpen
    public static void openDatabase() {
        if (!isDatabaseOpen()) {
            open();
        }
    }
}
