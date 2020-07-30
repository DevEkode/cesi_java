import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

public class BddConnexion {


    private Connection myConnexion;
    private String userbdd;
    private String passwordbdd;
    private String Urlbdd;
    private String cheminFichierProperties;
    private PreparedStatement ps;

    public BddConnexion(String cheminFichierProperties) throws IOException, SQLException {
        this.cheminFichierProperties = cheminFichierProperties;
    }

    public void seConnecter() throws SQLException, IOException {
        Properties props = new Properties();
        props.load(new FileInputStream(cheminFichierProperties));
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
