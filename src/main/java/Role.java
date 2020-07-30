import java.sql.*;

public class Role {


    private Connection myConnexion ;

    public Role(BddConnexion bdd) {

        this.myConnexion = bdd.getMaConnexion();
    }


    public void insertRole(String rolename) throws SQLException {
        String query = "Insert into role (rolename) values (?)";
        PreparedStatement ps = this.myConnexion.prepareStatement(query);

        ps.setString(1,rolename);

        ps.execute();
    }

    public void showRole() {
        String query = "SELECT * FROM role";


        try {
            Statement st = this.myConnexion.createStatement();
            ResultSet rs = st.executeQuery(query);

            while (rs.next()) {
                System.out.format("Name : %s\n", rs.getString("rolename"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void updateRole(Integer idRole, String rolename) throws SQLException {
        String query = "UPDATE role SET rolename = ? WHERE idRole = ?";

        PreparedStatement ps = myConnexion.prepareStatement(query);

        ps.setInt(2,idRole);
        ps.setString(1,rolename);

        ps.execute();
    }

    public void DeleteRole(Integer idRole) throws SQLException {
        String query = "DELETE FROM role WHERE idRole = ?";

        PreparedStatement ps = myConnexion.prepareStatement(query);

        ps.setInt(1,idRole);

        ps.execute();
    }





}

