package Controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;

public class ControllerAdminStudentAdd {

    @FXML
    TextField txt_nom;
    TextField txt_prenom;
    ChoiceBox<String> cb_class;
    Button btn_logout;
    Button btn_confirm;
    Button btn_cancel;

    @FXML
    public void initialize(){

    }
}