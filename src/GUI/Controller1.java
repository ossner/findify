package GUI;
import FileParser.FileCrawler;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.DirectoryChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;

public class Controller1 {

    private Stage thisStage;
    private Controller2 controller2;
    public Button projectButton;

    public Controller1() throws IOException {
        thisStage = new Stage();

        FXMLLoader loader = new FXMLLoader(getClass().getResource("projectSelectorScene.fxml"));
        loader.setController(this);

        thisStage.setScene(new Scene(loader.load()));
        thisStage.setTitle("findify");
    }


    //executes the button actionEvent for the project file opening
    public void projectButtonFired(){
        DirectoryChooser chooser = new DirectoryChooser();
        chooser.setTitle("Project Path");

        String os = System.getProperty("os.name").toLowerCase();
        String defaultPath = "";
        if (os.equals("linux") || os.equals("mac os x")) {
            defaultPath = "/home/";
        } else if (os.contains("windows")) {
            defaultPath = "C:\\Users\\";
        }

        File defaultDir = new File(defaultPath);
        chooser.setInitialDirectory(defaultDir);
        File selected = chooser.showDialog(thisStage);

        FileCrawler.crawl(selected.getPath());

        thisStage.close();
        initializeController2();

    }

    //creates and initializes our second controller and stage
    private void initializeController2(){
        try {
            controller2 = new Controller2();
            controller2.showStage();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public void showStage() {
        thisStage.show();
    }
}
