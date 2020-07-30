package Controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.text.Text;

public class ControllerPageEtudiant {


    @FXML
    Text Txt_nom;
    @FXML
    Text Txt_prenom;
    @FXML
    Text Txt_promotion;
    @FXML
    Button btn_logout;
    ListView<String> list_liste_etudiants;

    @FXML
    public void initialize(){

    }

}
