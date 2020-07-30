package Controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

public class ControllerAdminClassEdit {

    @FXML
    Button btn_logout;
    Button btn_cancel;
    Button btn_save;
    Button btn_delete;
    TextField txt_search;
    TextField txt_class_name;
    ListView<String> list_classes;

    @FXML
    public void initialize(){

    }
}
