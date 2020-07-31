package Controllers;

import BDD.BddConnexion;
import BDD.Classroom;
import BDD.Person;
import Enums.RoleId;
import ListObjects.Class;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

public class ControllerAdminStudentAdd {

    public static Stage primaryStage;
    private Person person;
    private Classroom classroom;

    @FXML
    TextField txt_nom;
    @FXML
    TextField txt_prenom;
    @FXML
    PasswordField txt_pass;
    @FXML
    Text txt_feedback;
    @FXML
    ChoiceBox<Class> cb_class;
    @FXML
    Button btn_logout;
    @FXML
    Button btn_confirm;
    @FXML
    Button btn_cancel;

    @FXML
    public void initialize() throws IOException, SQLException {
        this.person = new Person(BddConnexion.getINSTANCE());
        this.classroom = new Classroom(BddConnexion.getINSTANCE());

        populateClassroomList();
    }

    @FXML
    public void onAnnulerClick() throws IOException {
        Parent pane = FXMLLoader.load(getClass().getResource("/adminAcceuil.fxml"));
        ControllerAdminAcceuil.primaryStage = primaryStage;

        Scene scene = new Scene( pane );
        primaryStage.setScene(scene);
    }

    @FXML
    public void onLogoutClick() throws IOException {
        Parent pane = FXMLLoader.load(getClass().getResource("/pageConnection.fxml"));
        ControllerPageConnection.primaryStage = primaryStage;

        Scene scene = new Scene( pane );
        primaryStage.setScene(scene);
    }

    @FXML
    public void onValiderClick() throws SQLException {
        // Get all values from form
        String nom = txt_nom.getText().trim();
        String prenom = txt_prenom.getText().trim();
        String pass = txt_pass.getText().trim();
        Class c = cb_class.getSelectionModel().getSelectedItem();

        // Check if everything is filled
        if(nom.equals("") || prenom.equals("") || pass.equals("") || c == null){
            // NOK
            txt_feedback.setFill(Color.RED);
            txt_feedback.setText("Un ou plusieurs champs sont manquants !");
            txt_feedback.setVisible(true);
            return;
        }

        // Save in database
        String login = prenom.toLowerCase()+"."+nom.toLowerCase();

        //Check if the login already exists
        ResultSet rs = this.person.showPerson(login);
        while(rs.next()){
            // A login already exists
            txt_feedback.setText("Le login "+login+" existe déja !");
            txt_feedback.setFill(Color.RED);
            txt_feedback.setVisible(true);
            return;
        }

        this.person.insertPerson(prenom,nom,login,pass,c.getId(), RoleId.ETUDIANT);

        // Show success
        txt_feedback.setText("Etudiant "+prenom+" "+nom+" crée avec le login : "+login+" et le mot de passe donné");
        txt_feedback.setFill(Color.GREEN);
        txt_feedback.setVisible(true);
    }

    @FXML
    public void onTextUpdate(){
        txt_feedback.setVisible(false);
    }

    private void populateClassroomList() throws SQLException {
        // Get all classrooms
        ResultSet rs = this.classroom.getAll();

        ArrayList<Class> array = new ArrayList<>();
        while(rs.next()){
            array.add(new Class(rs.getInt("idClassroom"),rs.getString("classname")));
        }

        ObservableList<Class> observableList = FXCollections.observableList(array);
        cb_class.setItems(observableList);
    }
}
