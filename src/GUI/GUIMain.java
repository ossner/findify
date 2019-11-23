package GUI;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.DirectoryChooser;
import javafx.stage.Stage;

import java.io.File;

public class GUIMain extends Application {

    Stage window;
    Scene startupScene, classScene, methodScene, attributeScene;
    Button classButton, methodButton, attributeButton;

    @Override
    public void start(Stage primaryStage) throws Exception{
        DirectoryChooser chooser = new DirectoryChooser();
        chooser.setTitle("Project Path");

        String os = System.getProperty("os.name").toLowerCase();
        String defaultPath = "";
        if (os.equals("linux") || os.equals("mac os x")) {
            defaultPath = "/home/";
        } else if (os.contains("windows")) {
            defaultPath = "%userprofile%";
        }

        System.out.println(System.getProperty("os.name").toLowerCase());

        File defaultDir = new File(defaultPath);
        chooser.setInitialDirectory(defaultDir);
        File selected = chooser.showDialog(primaryStage);
        System.out.println(selected.getPath());

    }
    public static void main(String[] args) {launch(args);}
}
