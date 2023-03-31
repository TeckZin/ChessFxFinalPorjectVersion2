package com.example.chessfxfinalporjectversion2;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

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




     private DraggableMakerGrid gridMaker2;

     public void initialize(URL url, ResourceBundle resourceBundle){



          draggableMakerGrid = new DraggableMakerGrid(controlSize, file,rank,pane);
          gridMaker2 = new DraggableMakerGrid(controlSize, file, rank, pane);

          gridHandler = new GridHandler(controlSize, file, rank,pane);
          gridHandler.updateGrid();

          PeicesHandler peicesHandler = new PeicesHandler(pane, controlSize, draggableMaker);





     }


}