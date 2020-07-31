import Controllers.ControllerPageConnection;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;

public class Main extends Application {

    public static void main(String[] args) throws IOException, SQLException {
        Application.launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("pageEtudiant.fxml"));
        ControllerPageConnection.primaryStage = primaryStage;
        primaryStage.setTitle("Application de gestion des classes");
        primaryStage.getIcons().add(new Image("/icon.png"));
        primaryStage.setScene(new Scene(root, 720, 480));
        primaryStage.show();
    }

}
