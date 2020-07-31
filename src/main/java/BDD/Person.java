package BDD;

import java.sql.*;

public class Person {

    private Connection myConnexion;

    public Person(BddConnexion bdd) {
        this.myConnexion = bdd.getMaConnexion();
    }


    public void insertPerson(String firstname, String lastname,String login, String password, Integer idClassroom, Integer idRole) throws SQLException {
        String query = "Insert into person (firstname,lastname,login,password,idClassroom,idRole) values (?,?,?,?,?,?)";
        PreparedStatement ps = this.myConnexion.prepareStatement(query);

        ps.setString(1,firstname);
        ps.setString(2,lastname);
        ps.setString(3,login);
        ps.setString(4,password);
        ps.setInt(5,idClassroom);
        ps.setInt(6,idRole);
        ps.execute();
    }

    public ResultSet showPerson(Integer id) throws SQLException {
        String query = "SELECT * FROM person WHERE id = ?";

        PreparedStatement st = this.myConnexion.prepareStatement(query);
        st.setInt(1,id);

        return st.executeQuery();
    }

    public ResultSet showPerson(String login) throws SQLException {
        String query = "SELECT * FROM person WHERE login = ?";

        PreparedStatement st = this.myConnexion.prepareStatement(query);
        st.setString(1,login);

        return st.executeQuery();
    }

    public void updatePerson(Integer idPerson, String firstname, String lastname, String login, String password, Integer idClassroom,Integer idRole) throws SQLException {
        String query = "UPDATE person SET firstname = ?, lastname = ?,login = ?,password = ?, idClassroom = ?, idRole = ? WHERE idPerson = ?";

        PreparedStatement ps = myConnexion.prepareStatement(query);

        ps.setString(1,firstname);
        ps.setString(2,lastname);
        ps.setString(3,login);
        ps.setString(4,password);
        ps.setInt(5,idClassroom);
        ps.setInt(6,idRole);
        ps.setInt(7,idPerson);
        ps.execute();
    }

    public void DeletePerson(Integer idPerson) throws SQLException {
        String query = "DELETE FROM person WHERE idPerson = ?";

        PreparedStatement ps = myConnexion.prepareStatement(query);

        ps.setInt(1,idPerson);

        ps.execute();
    }


}
