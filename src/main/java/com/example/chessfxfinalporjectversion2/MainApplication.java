package com.example.chessfxfinalporjectversion2;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class MainApplication extends Application {


    @Override
    public void start(Stage primaryStage) throws Exception {
        System.out.println("Game Launch");
        Color backgroundColor = Color.web("#555555");
        Group root = new Group();
        Scene scene = new Scene(root, 1280.0, 720.0, backgroundColor);
        primaryStage.setX(20.0);
        primaryStage.setY(200.0);
        GridHandler gridHandler = new GridHandler(root, primaryStage);
        primaryStage.setTitle("Chess -- Fx");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}