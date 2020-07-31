package Controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class ControllerModifierEtudiant {

    public static Stage primaryStage;
    @FXML
    Button btn_back;
    Button btn_logout;
    Button btn_modify;
    Button btn_delete;
    ListView<String> list_liste_etudiants;
    TextField TxtFld_search;
    TextField TxtFld_firstname;
    TextField TxtFld_lastname;

    @FXML
    public void initialize(){

    }

}
