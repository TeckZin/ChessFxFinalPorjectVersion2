package com.example.chessfxfinalporjectversion2;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MainController implements Initializable {

     private int controlSize = 100;
     private int file = 8;
     private int rank = 8;

     @FXML
     private AnchorPane pane;



     private GridHandler gridHandler;

     private DraggableMakerGrid draggableMakerGrid;
     private DraggableMaker draggableMaker = new DraggableMaker();
     private String FEN = "rnbqkbnr/pppppppp/8/8/8/8/PPPPPPPP/RNBQKBNR w KQkq - 0 1";

     private PeicesHandler peicesHandler;





     private DraggableMakerGrid gridMaker2;
     @Override
     public void initialize(URL url, ResourceBundle resourceBundle){



          draggableMakerGrid = new DraggableMakerGrid(controlSize, file,rank,pane);
          gridMaker2 = new DraggableMakerGrid(controlSize, file, rank, pane);

          gridHandler = new GridHandler(controlSize, file, rank,pane);
          gridHandler.updateGrid();


          peicesHandler = new PeicesHandler(pane, controlSize, draggableMaker, draggableMakerGrid, FEN);


     }
     //<AnchorPane fx:id="pane" layoutX="100.0" layoutY="100.0" maxHeight="-Infinity" maxWidth="-Infinity" minHeight="-Infinity" minWidth="-Infinity" prefHeight="805.0" prefWidth="849.0" xmlns="http://javafx.com/javafx/19" xmlns:fx="http://javafx.com/fxml/1" fx:controller="com.example.chessfxfinalporjectversion2.MainController" />


     public PeicesHandler getPeicesHandler(){
          return peicesHandler;
     }

     @FXML
     protected void onResetDefault(){
          peicesHandler.loadDefaulStartPosition();


     }






}






