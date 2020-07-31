package Controllers;

import BDD.Person;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class ControllerAdminAcceuil {

    public static Stage primaryStage;
    public static int personId;

    @FXML
    Button btn_logout;
    Button btn_student_edit;
    Button btn_student_add;
    Button btn_student_delete;
    Button btn_student_list;
    Button btn_class_create;
    Button btn_class_edit;
    Button btn_class_delete;

    @FXML
    public void initialize(){

    }

}
