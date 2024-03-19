package de.throsenheim.gui.locations;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class LocationsFxMain extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent dialog = FXMLLoader.load(this.getClass().getResource("Hello.fxml"));

        Scene scene = new Scene(dialog, 200, 200);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}


