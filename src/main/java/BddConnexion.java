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


    public void eraseAll() throws SQLException {
        String query = "DELETE FROM classroom";
        Statement st = myConnexion.createStatement();
        st.executeUpdate(query);
    }
}
