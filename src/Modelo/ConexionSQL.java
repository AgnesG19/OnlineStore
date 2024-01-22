package Modelo;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConexionSQL {
    private static final String user = "root";
    private static final String password = "";
    private static final String url = "jdbc:mysql://localhost:3306/art-ped-cli?serverTimezone=UTC&useSSL=false";

    private static Connection conect = null;

    public static Connection gConnection(){
        Connection conect = null;
        try {
            conect = DriverManager.getConnection(url, user, password);
        } catch (Exception e) {
            System.err.println(e);
        }
        return conect;
    }
}