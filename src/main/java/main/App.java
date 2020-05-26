package main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;


public class App extends Application {

    private static Scene scene;

    @Override
    public void start(Stage stage) throws IOException {
        scene = new Scene(loadFXML("shop"));
        stage.setScene(scene);
       stage.setWidth(1280);
       stage.setHeight(720);
       stage.show();
    }

    public static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
       System.out.println(App.class.getClassLoader().getResource("xml/" + fxml + ".fxml"));
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getClassLoader().getResource("xml/" + fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void main(String[] args) {
        launch();
    }

}