package Controllers;


import BDD.Person;
import Enums.RoleId;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class ControllerAdminAcceuil {

    public static int personId;

    public static Stage primaryStage;

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
    public void redirectToPage(String fxml) throws IOException {
        Parent pane = FXMLLoader.load(getClass().getResource(fxml));

        Scene scene = new Scene(pane);
        primaryStage.setScene(scene);
    }

    public void redirectToEditStudent() throws IOException {
        ControllerModifierEtudiant.primaryStage = primaryStage;
        this.redirectToPage("../modifierEtudiant.fxml");
    }

    public void redirectToAddStudent() throws IOException {
        ControllerAdminStudentAdd.primaryStage = primaryStage;
        this.redirectToPage("../adminStudentAdd.fxml");
    }


    public void redirectToListStudent() throws IOException {
        ControllerListeEtudiant.primaryStage = primaryStage;
        this.redirectToPage("../listeEtudiant.fxml");
    }

    public void redirectToAddClass() throws IOException {
        ControllerAdminClassAdd.primaryStage = primaryStage;
        this.redirectToPage("/adminClassAdd.fxml");
    }

    public void redirectToEditClass() throws IOException {
        ControllerAdminClassEdit.primaryStage = primaryStage;
        this.redirectToPage("../adminClassEdit.fxml");
    }



}
