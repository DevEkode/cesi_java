
import java.sql.*;

public class Classroom {

    private Connection myConnexion ;

    public Classroom(BddConnexion bdd) {

        this.myConnexion = bdd.getMaConnexion();
    }

    public void insertClassroom(Integer nbEleve, String classname) throws SQLException {
        String query = "Insert into classroom (nbEleve,classname) values (?,?)";
        PreparedStatement ps = this.myConnexion.prepareStatement(query);

        ps.setInt(1,nbEleve);
        ps.setString(2,classname);
        ps.execute();
    }

    public void showClassroom() {
        String query = "SELECT classname FROM classroom";


        try {
            Statement st = this.myConnexion.createStatement();
            ResultSet rs = st.executeQuery(query);

            while (rs.next()) {
                System.out.format("Name : %s\n", rs.getString("classname"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

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
