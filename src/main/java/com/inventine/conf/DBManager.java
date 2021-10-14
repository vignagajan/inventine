package com.inventine.conf;

/*
    Database connection using Singleton Pattern
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Map;

import com.inventine.util.DotEnv;

public class DBManager {

    private static volatile DBManager dbInstance;
    private static volatile Connection conn;

    private DBManager(){
        if (dbInstance != null){
            throw new RuntimeException("Use getConnector method to get connector instance!");
        }
    }

    public static DBManager getDbInstance() {

        if (dbInstance == null){
            synchronized (DBManager.class){
                if (dbInstance == null){
                    dbInstance = new DBManager();
                }
            }
        }

        return dbInstance;
    }

    public static Connection getConnection() {

        if (conn == null){
            synchronized (Connection.class){
                if (conn == null){

                    Map<String,String> dotEnv = DotEnv.load();

                    String url = dotEnv.get("DB_URL");
                    String host_username = dotEnv.get("DB_USER");
                    String host_password = dotEnv.get("DB_PASS");

                    try {
                        Class.forName("org.postgresql.Driver");
                        conn = DriverManager.getConnection(url,host_username,host_password);
                    } catch (SQLException | ClassNotFoundException e){
                        e.printStackTrace();
                    }

                }
            }
        }

        return conn;
    }
}