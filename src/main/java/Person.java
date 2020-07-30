import java.sql.*;

public class Person {

    private Connection myConnexion ;

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

    public void showPerson() {
        String query = "SELECT * FROM person";


        try {
            Statement st = this.myConnexion.createStatement();
            ResultSet rs = st.executeQuery(query);

            while (rs.next()) {
                System.out.format("Name : %s\n", rs.getString("firstname"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

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
