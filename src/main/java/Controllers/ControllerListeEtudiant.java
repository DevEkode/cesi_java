package Controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

import java.io.IOException;


public class ControllerListeEtudiant {

    public static Stage primaryStage;
    @FXML
    Button btn_back;

    @FXML
    Button btn_logout;

    @FXML
    ListView<String> list_liste_etudiants;

    @FXML
    public void initialize(){

    }
    @FXML
    public void onLogout() throws IOException {
        Parent pane = FXMLLoader.load(getClass().getResource("/pageConnection.fxml"));
        ControllerPageConnection.primaryStage = primaryStage;

        Scene scene = new Scene( pane );
        primaryStage.setScene(scene);
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
}


