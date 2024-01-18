package group.example.demo;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.Parent;
import javafx.stage.Stage;
import javafx.scene.Group;
import javafx.scene.image.Image;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.lang.String;
import javafx.scene.paint.Color;

import java.util.function.Function;

public class HelloApplication extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("hello-view.fxml"));
        primaryStage.setTitle("Editor");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
