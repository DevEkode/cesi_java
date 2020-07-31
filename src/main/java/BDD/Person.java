package BDD;

import Enums.RoleId;

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
        String query = "SELECT * FROM person WHERE idPerson = ?";

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

    public ResultSet showFirstName(int firstname) throws SQLException {
        String query = "SELECT * FROM person WHERE idPerson = ?";

        PreparedStatement st = this.myConnexion.prepareStatement(query);
        st.setInt(1,firstname);

        return st.executeQuery();
    }

    public ResultSet showLastName(int lastname) throws SQLException {
        String query = "SELECT LastName FROM person WHERE idPerson = ?";

        PreparedStatement st = this.myConnexion.prepareStatement(query);
        st.setInt(1, lastname);

        return st.executeQuery();
    }

    public ResultSet showClasse(int idClassroom) throws SQLException {
        String query = "SELECT idClassroom FROM person";

        PreparedStatement st = this.myConnexion.prepareStatement(query);
        st.setInt(1,idClassroom);

        return st.executeQuery();
    }

    public ResultSet showRolePerson(Integer roleId) throws SQLException {
        String query = "SELECT * FROM person WHERE idRole = ?";

        PreparedStatement st = this.myConnexion.prepareStatement(query);
        st.setInt(1,roleId);

        return st.executeQuery();
    }

    public ResultSet showRolePersonClass(Integer idRole, Integer idClassroom) throws SQLException {
        String query = "SELECT * FROM person " +
                "WHERE idClassroom = ? AND idRole = ?";

        PreparedStatement st = this.myConnexion.prepareStatement(query);
        st.setInt(1,idClassroom);
        st.setInt(2,idRole);

        return st.executeQuery();
    }


    public ResultSet showRolePersonLoginLike(Integer RoleId,String like) throws SQLException {
        String query = "SELECT * FROM person WHERE idRole = ? AND login LIKE ?";

        PreparedStatement st = this.myConnexion.prepareStatement(query);
        st.setInt(1,RoleId);
        st.setString(2,like);

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

    public void updatePerson(Integer idPerson,String firstname, String lastname, int idClassroom) throws SQLException {
        String query = "UPDATE person SET firstname = ?, lastname = ?, idClassroom = ? WHERE idPerson = ?";

        PreparedStatement ps = this.myConnexion.prepareStatement(query);
        ps.setString(1,firstname);
        ps.setString(2,lastname);
        ps.setInt(3,idClassroom);
        ps.setInt(4,idPerson);

        ps.execute();
    }

    public void DeletePerson(Integer idPerson) throws SQLException {
        String query = "DELETE FROM person WHERE idPerson = ?";

        PreparedStatement ps = myConnexion.prepareStatement(query);

        ps.setInt(1,idPerson);

        ps.execute();
    }


}
