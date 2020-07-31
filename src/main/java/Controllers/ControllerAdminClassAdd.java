package Controllers;

import BDD.BddConnexion;
import BDD.Classroom;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ControllerAdminClassAdd {

    public static Stage primaryStage;
    private Classroom classroom;



    @FXML
    Button btn_logout;
    @FXML
    Button btn_confirm;
    @FXML
    Button btn_cancel;
    @FXML
    TextField txt_class_name;
    @FXML
    Text txt_feedback;

    @FXML
    public void initialize() throws IOException, SQLException {
        BddConnexion bddConnexion = BddConnexion.getINSTANCE();
        this.classroom = new Classroom(bddConnexion);
    }


    @FXML
    public void onButtonValidClick() throws SQLException, IOException {
        String classname = null;
        classname = txt_class_name.getText().trim();

        //Check into database
        ResultSet rs = this.classroom.showClassroom(classname);


        while(rs.next()){
           // A classname is already exist
            txt_feedback.setText("La classe " + classname + " existe déjà" );
            txt_feedback.setFill(Color.RED);
            txt_feedback.setVisible(true);
            return;
        }

        this.classroom.insertClassroom(classname);

        // success
        txt_feedback.setText("La classe " + classname + " a bien été créée !" );
        txt_feedback.setFill(Color.GREEN);
        txt_feedback.setVisible(true);
    }

    public void redirectToPage(String fxml) throws IOException {
        Parent pane = FXMLLoader.load(getClass().getResource(fxml));

        Scene scene = new Scene(pane);
        primaryStage.setScene(scene);
    }
    public void redirectToConnexionPage() throws IOException {
       ControllerPageConnection.primaryStage = primaryStage;
        this.redirectToPage("../pageConnection.fxml");
    }
    public void redirectToHomeAdminPage() throws IOException {
        ControllerAdminAcceuil.primaryStage = primaryStage;
        this.redirectToPage("../adminAcceuil.fxml");
    }
}
