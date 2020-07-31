package Controllers;

import BDD.BddConnexion;
import BDD.Person;
import Enums.RoleId;
import ListObjects.PersonItem;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ControllerModifierEtudiant {

    public static Stage primaryStage;
    private Person person;
    private int current_id;


    @FXML
    Button btn_back;
    @FXML
    Button btn_logout;
    @FXML
    Button btn_modify;
    @FXML
    Button btn_delete;
    @FXML
    ListView<PersonItem> list_liste_etudiants;
    @FXML
    TextField TxtFld_search;
    @FXML
    TextField TxtFld_firstname;
    @FXML
    TextField TxtFld_lastname;
    @FXML
    Text txt_feedback;

    @FXML
    public void initialize() throws IOException, SQLException {
        this.person = new Person(BddConnexion.getINSTANCE());

        populateStudentList();
    }

    @FXML
    public void onStudentSelect() throws SQLException {
        // On student select, fill the text field
        PersonItem personItem = list_liste_etudiants.getSelectionModel().getSelectedItem();

        // Load from database
        ResultSet rs = this.person.showPerson(personItem.getId());

        while(rs.next()){
            TxtFld_firstname.setText(rs.getString("firstname"));
            TxtFld_lastname.setText(rs.getString("lastname"));
        }

        // Save id of student being edited
        this.current_id = personItem.getId();
    }

    @FXML
    public void onSaveClick() throws SQLException {
        // Get text field values
        String lastname = TxtFld_lastname.getText();
        String firstname = TxtFld_firstname.getText();

        // Update value in database
        this.person.updatePerson(this.current_id,firstname,lastname);

        // Show success messages
        txt_feedback.setText("Informations mises à jour !");
        txt_feedback.setFill(Color.GREEN);
        txt_feedback.setVisible(true);
    }

    @FXML
    public void onSupprimerClick() throws SQLException {
        // Check if the student still exist in database
        ResultSet rs = this.person.showPerson(this.current_id);

        String firstname = "", lastname = "";
        while(rs.next()){
            firstname = rs.getString("firstname");
            lastname = rs.getString("lastname");
        }

        if(firstname.equals("") || lastname.equals("")){
            // Does not exists
            txt_feedback.setText("Impossible de trouver l'utilisateur dans la base de donnée :(");
            txt_feedback.setFill(Color.RED);
            txt_feedback.setVisible(true);

            this.populateStudentList();
            return;
        }

        // Delete from database
        this.person.DeletePerson(this.current_id);
        this.current_id = -1;

        TxtFld_firstname.setText("");
        TxtFld_lastname.setText("");

        txt_feedback.setText("Étudiant "+firstname+" "+lastname+" supprimé !");
        txt_feedback.setFill(Color.GREEN);
        txt_feedback.setVisible(true);

        this.populateStudentList();
    }

    @FXML
    public void onUpdateSearch() throws SQLException {
        String search = TxtFld_search.getText();
        populateStudentList(search);
    }

    @FXML
    public void onInputUpdate(){
        txt_feedback.setVisible(false);
    }

    @FXML
    public void onAnnulerClick() throws IOException {
        Parent pane = FXMLLoader.load(getClass().getResource("/adminAcceuil.fxml"));
        ControllerAdminAcceuil.primaryStage = primaryStage;

        Scene scene = new Scene( pane );
        primaryStage.setScene(scene);
    }

    @FXML
    public void onLogout() throws IOException {
        Parent pane = FXMLLoader.load(getClass().getResource("/pageConnection.fxml"));
        ControllerPageConnection.primaryStage = primaryStage;

        Scene scene = new Scene( pane );
        primaryStage.setScene(scene);
    }

    private void populateStudentList(String search) throws SQLException {
        // Get all students
        ResultSet rs;
        if(search.equals("")){
            rs = this.person.showRolePerson(RoleId.ETUDIANT);
        } else{
            rs = this.person.showRolePersonLoginLike(RoleId.ETUDIANT,'%'+search+'%');
        }

        ArrayList<PersonItem> personItems = new ArrayList<>();
        while(rs.next()){
            personItems.add(new PersonItem(rs.getInt("idPerson"),rs.getString("login")));
        }

        ObservableList<PersonItem> observableList = FXCollections.observableList(personItems);
        list_liste_etudiants.setItems(observableList);
    }

    private void populateStudentList() throws SQLException {
        populateStudentList("");
    }



}
