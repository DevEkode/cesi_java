package Controllers;

import BDD.BddConnexion;
import BDD.Person;
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
import java.sql.ResultSet;
import java.sql.SQLException;

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
    TableView<Model_pageEtudiant> Table_liste_etudiants;
    TableColumn<Model_pageEtudiant,String> col_prenom;
    TableColumn<Model_pageEtudiant,String> col_nom;
    TableColumn<Model_pageEtudiant,String> col_classe;

    ObservableList<Model_pageEtudiant> oblist = FXCollections.observableArrayList();

    public void initialize() throws IOException, SQLException {

        BddConnexion bddConnexion = BddConnexion.getINSTANCE();
        this.person = new Person(bddConnexion);

        // ResultSet rs = Connection.createStatement().executeQuery("select firstname,lastname,classe FROM person ");

    }


}
