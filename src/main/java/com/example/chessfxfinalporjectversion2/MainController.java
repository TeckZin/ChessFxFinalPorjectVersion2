package com.example.chessfxfinalporjectversion2;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Rectangle;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.Scanner;

public class MainController implements Initializable {
     private Scanner sc;
     private Interactions interactions;
     private int controlSize = 100;
     private int file = 8;
     private int rank = 8;
     @FXML
     private AnchorPane pane;
     private GridHandler gridHandler;

     private DraggableMakerGrid draggableMakerGrid;
     private DraggableMaker draggableMaker = new DraggableMaker();
     private String FEN = "r1bqkb1r/pp3ppp/2pn1n2/1B1pp3/4P3/5N2/PPPPQPPP/RNB1K2R w KQkq - 0 1";

     private PeicesHandler piecesHandler;

     private ArrayList<Object> piecesOnBoard;

     private DraggableMakerGrid gridMaker2;
     //Creates the objects of the chess board, the pieces on the board, and the interactions
     /**
      *
      * @params making the foundation fo the game, and start to generate the pieces
      * @author Teck
      */

     @Override
     public void initialize(URL url, ResourceBundle resourceBundle){
          sc = new Scanner(System.in);


          draggableMakerGrid = new DraggableMakerGrid(controlSize, file,rank,pane);
          gridMaker2 = new DraggableMakerGrid(controlSize, file, rank, pane);

          gridHandler = new GridHandler(controlSize, file, rank,pane);
          gridHandler.updateGrid();


          piecesHandler = new PeicesHandler(pane, controlSize, draggableMaker, draggableMakerGrid, FEN);
          piecesOnBoard = piecesHandler.getPeicesOnBoard();



          interactions = new Interactions(pane);
          interactions.addEventHandlers(pane, piecesOnBoard);

     }
     //<AnchorPane fx:id="pane" layoutX="100.0" layoutY="100.0" maxHeight="-Infinity" maxWidth="-Infinity" minHeight="-Infinity" minWidth="-Infinity" prefHeight="805.0" prefWidth="849.0" xmlns="http://javafx.com/javafx/19" xmlns:fx="http://javafx.com/fxml/1" fx:controller="com.example.chessfxfinalporjectversion2.MainController" />


     public PeicesHandler getPiecesHandler(){
          return piecesHandler;
     }

     @FXML
     protected void onResetDefault(){

          for(Object o : piecesOnBoard){
               Rectangle rectangle = interactions.getRectangleObject(o);
               interactions.peiceRemovel(rectangle);

          }
          piecesHandler.loadDefaulStartPosition();

     }

     @FXML
     protected void onResetFEN() {
          piecesHandler.fenConverter(FEN);
     }


     @FXML
     protected void onInputFen(){
          System.out.println("---------------------------------------");
          System.out.println("\033[0;107m\033[1;37mSCANNER GENERATED");
          System.out.print("\033[0;34mEnter FEN: ");
          this.FEN = sc.nextLine();
          System.out.println("\033[0;32mFEN LOADED IN\033[0m");
          System.out.println("---------------------------------------");
     }



}






