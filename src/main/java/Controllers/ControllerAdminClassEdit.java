package Controllers;

import BDD.BddConnexion;
import BDD.Classroom;
import Enums.RoleId;
import ListObjects.Class;
import ListObjects.PersonItem;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ControllerAdminClassEdit {

    public static Stage primaryStage;
    private Classroom classroom;
    private int current_id;

    @FXML
    Button btn_logout;
    @FXML
    Button btn_cancel;
    @FXML
    Button btn_save;
    @FXML
    Button btn_delete;
    @FXML
    TextField txt_search;
    @FXML
    TextField txt_class_name;
    @FXML
    ListView<Class> list_classes;
    @FXML
    Text txt_feedback;

    @FXML
    public void initialize() throws IOException, SQLException {
        this.classroom = new Classroom(BddConnexion.getINSTANCE());

        populateClassList();
    }

    @FXML
    public void onAnnulerClick() throws IOException {
        Parent pane = FXMLLoader.load(getClass().getResource("/adminAcceuil.fxml"));
        ControllerAdminAcceuil.primaryStage = primaryStage;

        Scene scene = new Scene( pane );
        primaryStage.setScene(scene);
    }

    @FXML
    public void onLogout() throws IOException {
        Parent pane = FXMLLoader.load(getClass().getResource("/pageConnection.fxml"));
        ControllerPageConnection.primaryStage = primaryStage;

        Scene scene = new Scene( pane );
        primaryStage.setScene(scene);
    }

    @FXML
    public void onSearchUpdate() throws SQLException {
        String search = txt_search.getText();
        this.populateClassList(search);
    }

    @FXML
    public void onListSelect(){
        Class aClass = list_classes.getSelectionModel().getSelectedItem();

        txt_class_name.setText(aClass.getName());
        this.current_id = aClass.getId();
    }

    @FXML
    public void onEnregistrerClick() throws SQLException {
        String classname = txt_class_name.getText().trim();

        if(this.current_id == -1) return;

        this.classroom.updateClassroom(this.current_id,classname);

        txt_feedback.setText("Mis à jour avec succès !");
        txt_feedback.setFill(Color.GREEN);
        txt_feedback.setVisible(true);

        this.populateClassList();
    }

    @FXML
    public void onSupprimerClick() throws SQLException {
        if(this.current_id == -1) return;

        // Check if the class exists
        ResultSet rs = this.classroom.showClassroom(this.current_id);

        String classname = "";
        while(rs.next()){
            classname = rs.getString("classname");
        }

        if(classname.equals("")){
            txt_feedback.setText("Impossible de trouver cette classe dans la base de donnée :(");
            txt_feedback.setFill(Color.RED);
            txt_feedback.setVisible(true);

            return;
        }

        this.classroom.DeleteClassroom(this.current_id);
        this.current_id = -1;

        txt_class_name.setText("");

        txt_feedback.setText("Classe "+classname+" supprimée avec succès !");
        txt_feedback.setFill(Color.GREEN);
        txt_feedback.setVisible(true);

        this.populateClassList();
    }

    @FXML
    public void onInputUpdate(){
        txt_feedback.setVisible(false);
    }

    private void populateClassList(String search) throws SQLException {
        // Get all class
        ResultSet rs;
        if(search.equals("")){
            rs = this.classroom.getAll();
        } else{
            rs = this.classroom.getAllLike('%'+search+'%');
        }

        ArrayList<Class> classes = new ArrayList<>();
        while(rs.next()){
            classes.add(new Class(rs.getInt("idClassroom"),rs.getString("classname")));
        }

        ObservableList<Class> observableList = FXCollections.observableList(classes);
        list_classes.setItems(observableList);
    }

    private void populateClassList() throws SQLException {
        this.populateClassList("");
    }
}
