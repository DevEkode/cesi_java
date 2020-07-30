import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;
import java.sql.SQLException;

public class Main extends Application {

    public static void main(String[] args) throws SQLException {


        try {
            BddConnexion maCo = new BddConnexion("C:\\Users\\guill\\IdeaProjects\\cesi_java\\src\\main\\resources\\db.properties");
            maCo.seConnecter();
            Classroom classroom = new Classroom(maCo);
            Person person = new Person(maCo);
            Role role = new Role(maCo);

           // role.insertRole("administratrice");

           // role.showRole();
            System.out.println("------------------------------------------");
            classroom.DeleteClassroom(2);
            classroom.showClassroom();
            //System.out.println("------------------------------------------");
            //maCo.eraseAll();
            //person.showClassroom();
            //System.out.println("------------------------------------------");


        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("main.fxml"));
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 720, 480));
        primaryStage.show();
    }


}
