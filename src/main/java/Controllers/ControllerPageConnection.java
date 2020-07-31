package Controllers;

import BDD.BddConnexion;
import BDD.Person;
import Enums.RoleId;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ControllerPageConnection {

    public static Stage primaryStage;
    private Person person;


    @FXML
    TextField TxtFld_login;
    @FXML
    TextField TxtFld_pass;
    @FXML
    Button btn_connexion;
    @FXML
    Text txt_error;

    @FXML
    public void initialize() throws IOException, SQLException {
        BddConnexion bddConnexion = BddConnexion.getINSTANCE();
        this.person = new Person(bddConnexion);
    }

    @FXML
    public void onButtonConnexionClick() throws SQLException, IOException {
        String login = TxtFld_login.getText();
        String pass = TxtFld_pass.getText();

        //Check into database
        ResultSet rs = this.person.showPerson(login);

        String bdd_pass = null;
        int bdd_role = 0;
        int bdd_id = 0;
        while(rs.next()){
            bdd_pass = rs.getString("password");
            bdd_role = rs.getInt("idRole");
            bdd_id = rs.getInt("idPerson");
        }

        if(bdd_pass != null && bdd_pass.equals(pass)){
            // OK
            redirectToPageRole(bdd_role,bdd_id);
        }else{
            // NOK
            txt_error.setVisible(true);
        }
    }

    @FXML
    public void onEditTextField(){
        txt_error.setVisible(false);
    }

    public void redirectToPageRole(int role,int person_id) throws IOException {
        switch(role){
            case RoleId.ADMINISTRATEUR:
                // Redirect to admin page
                this.redirectToAdminPage(person_id);
                break;
            case RoleId.ETUDIANT:
                // Redirect to student page
                this.redirectToEtudiantPage(person_id);
                break;
        }
    }

    public void redirectToPage(String fxml) throws IOException {
        Parent pane = FXMLLoader.load(getClass().getResource(fxml));

        Scene scene = new Scene( pane );
        primaryStage.setScene(scene);
    }

    public void redirectToAdminPage(int person_id) throws IOException {
        ControllerAdminAcceuil.primaryStage = primaryStage;
        ControllerAdminAcceuil.personId = person_id;
        this.redirectToPage("../adminAcceuil.fxml");
    }

    public void redirectToEtudiantPage(int person_id) throws IOException {
        ControllerPageEtudiant.primaryStage = primaryStage;
        ControllerPageEtudiant.personId = person_id;
        this.redirectToPage("../pageEtudiant.fxml");
    }



}
