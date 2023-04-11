package com.example.chessfxfinalporjectversion2;



import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;

public class MainApplication extends javafx.application.Application{


    //Sets up the initial scene of the application, sets background color and window layout
    @Override
    public void start(Stage primaryStage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("hello-view.fxml"));
        Color color = Color.web("#676767");


        System.out.println("\033[1;92mGAME LAUNCH\033[0m");


        Scene scene = new Scene(fxmlLoader.load());


        scene.setFill(color);

        primaryStage.setResizable(false);

        primaryStage.setTitle("Chess -- Fx");
        primaryStage.setScene(scene);

        primaryStage.show();

        loadAdminControl();
    }


    //Loads
    public void loadAdminControl() {
        try {
            FXMLLoader adminFxmlLoader = new FXMLLoader(getClass().getResource("Admin.fxml"));
            Parent root1 = (Parent) adminFxmlLoader.load();
            Stage stage = new Stage();
            Scene scene = new Scene(root1);


            Color color = Color.web("#676767");
            scene.setFill(color);
            stage.setTitle("Admin Control");
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

    }

    //Launches project
    public static void main(String[] args) {
        launch();
    }
}

