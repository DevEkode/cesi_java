package BDD;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

public class BddConnexion {

    private Connection myConnexion;
    private String userbdd;
    private String passwordbdd;
    private String Urlbdd;
    private PreparedStatement ps;

    private static BddConnexion INSTANCE;

    public BddConnexion() throws IOException, SQLException {
    }

    public void seConnecter() throws SQLException, IOException {
        Properties props = new Properties();
        String rootPath = Thread.currentThread().getContextClassLoader().getResource("").getPath();
        String appConfigPath = rootPath + "db.properties";
        props.load(new FileInputStream(appConfigPath));
        userbdd = props.getProperty("user");
        passwordbdd = props.getProperty("password");
        Urlbdd = props.getProperty("dburl");
        myConnexion = DriverManager.getConnection(Urlbdd, userbdd, passwordbdd);
    }

    public Connection getMaConnexion() {
        return myConnexion;
    }

    public static BddConnexion getINSTANCE() throws IOException, SQLException {
        if(INSTANCE == null){
            INSTANCE = new BddConnexion();
            INSTANCE.seConnecter();
        }
        return INSTANCE;
    }
}
