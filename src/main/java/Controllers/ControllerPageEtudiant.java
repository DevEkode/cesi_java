package Controllers;


import BDD.BddConnexion;
import BDD.Classroom;
import BDD.Person;
import Enums.RoleId;
import ListObjects.PersonItem;
import Models.Model_pageEtudiant;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ControllerPageEtudiant {

    public static Stage primaryStage;
    public static int personId;
    private Person person;

    @FXML
    Text Txt_nom;
    @FXML
    Text Txt_prenom;
    @FXML
    Text Txt_promotion;
    @FXML
    Button btn_logout;
    @FXML
    ListView<Model_pageEtudiant> liste_etudiants;
    private Classroom classroom;


    public void initialize() throws IOException, SQLException {
        ArrayList<Model_pageEtudiant> oblist =  new ArrayList<>();


        try {
            BddConnexion bddConnexion = BddConnexion.getINSTANCE();
            this.classroom = new Classroom(bddConnexion);
            this.person = new Person(bddConnexion);
            ResultSet rt = this.person.showPerson(personId);
            int classroomId = -1;
            while (rt.next()){
                classroomId = rt.getInt("idClassroom");
            }

            ResultSet rs = this.person.showRolePersonClass(RoleId.ETUDIANT,classroomId);


            while(rs.next()){
                    oblist.add(new Model_pageEtudiant(rs.getString("firstname"),rs.getString("lastname")));
            }

        } catch(SQLException ex){

            Logger.getLogger(ControllerListeEtudiant.class.getName()).log(Level.SEVERE,null,ex);
        }


            ObservableList<Model_pageEtudiant> maListeModel = FXCollections.observableList(oblist);
            liste_etudiants.setItems(maListeModel);

            ResultSet XT = this.person.showPerson(personId);

            while(XT.next()){
                String firstName = XT.getString("firstname");
                String lastName =  XT.getString("lastname");
                Txt_prenom.setText(firstName);
                Txt_nom.setText(lastName);
            }



    }


}
