package BDD;

import java.sql.*;

public class Classroom {

    private Connection myConnexion ;

    public Classroom(BddConnexion bdd) {

        this.myConnexion = bdd.getMaConnexion();
    }

    public void insertClassroom(String classname) throws SQLException {
        String query = "Insert into classroom (classname) values (?)";
        PreparedStatement ps = this.myConnexion.prepareStatement(query);

        ps.setString(1,classname);
        ps.execute();

    }

    public ResultSet showClassroom() throws SQLException  {
        String query = "SELECT * FROM classroom";

        PreparedStatement st = this.myConnexion.prepareStatement(query);
        return st.executeQuery();
    }

    public ResultSet showClassroom(String name) throws SQLException  {
        String query = "SELECT * FROM classroom WHERE classname = ?";

        PreparedStatement st = this.myConnexion.prepareStatement(query);
        st.setString(1,name);
        return st.executeQuery();
    }

    public ResultSet getAll() throws SQLException {
        String query = "SELECT * FROM classroom";

        Statement st = this.myConnexion.createStatement();

        return st.executeQuery(query);
    }

    public void updateClassroom(Integer id, Integer nbEleve, String name) throws SQLException {
        String query = "UPDATE classroom SET nbEleve = ?, classname = ? WHERE idClassroom = ?";

        PreparedStatement ps = myConnexion.prepareStatement(query);

        ps.setInt(1,nbEleve);
        ps.setString(2,name);
        ps.setInt(3,id);
        ps.execute();
    }

    public void DeleteClassroom(Integer idClassroom) throws SQLException {
        String query = "DELETE FROM classroom WHERE idClassroom = ?";

        PreparedStatement ps = myConnexion.prepareStatement(query);

        ps.setInt(1,idClassroom);

        ps.execute();
    }

}
