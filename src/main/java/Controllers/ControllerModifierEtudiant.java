package Controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

public class ControllerModifierEtudiant {

    @FXML
    Button btn_back;
    @FXML
    Button btn_logout;
    @FXML
    Button btn_modify;
    @FXML
    Button btn_delete;
    ListView<String> list_liste_etudiants;
    @FXML
    TextField TxtFld_search;
    @FXML
    TextField TxtFld_firstname;
    @FXML
    TextField TxtFld_lastname;

    @FXML
    public void initialize(){

    }

}
