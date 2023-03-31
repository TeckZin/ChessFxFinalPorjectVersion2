package com.example.chessfxfinalporjectversion2;



import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;

public class MainApplication extends javafx.application.Application {
    public Group root = new Group();

    @Override
    public void start(Stage primaryStage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("hello-view.fxml"));

        Color color = Color.web("#676767");

        System.out.println("Game Launch");

        Scene scene = new Scene(fxmlLoader.load());


        scene.setFill(color);

        primaryStage.setTitle("Chess -- Fx");
        primaryStage.setScene(scene);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch();
    }
}