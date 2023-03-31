package com.example.chessfxfinalporjectversion2;

import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;

public class PeicesHandler {

    private AnchorPane pane;
    private int controlSize;
    private DraggableMakerGrid draggableMakerGrid;
    private DraggableMaker draggableMaker;

    private LocatePeices locatePeices;
    private String FEN;





    public PeicesHandler(AnchorPane pane, int controlSize, DraggableMaker draggableMaker, DraggableMakerGrid draggableMakerGrid, String FEN){
        this.pane = pane;
        this.controlSize = controlSize;
        this.draggableMaker = draggableMaker;
        this.draggableMakerGrid = draggableMakerGrid;
        this.FEN = FEN;

        locatePeices  = new LocatePeices(FEN);
        loadDefaulStartPosition();









    }


    public void loadDefaulStartPosition(){
        System.out.println("Loading Deafault Start  Position");


        for (int i = 0; i <= 7; i++){
            locatePeices.setPawnY(100);
            locatePeices.setPawnX(i*100);
            Pawn pawnBlack = new Pawn(pane, controlSize, locatePeices.getPawnX(), locatePeices.getPawnY(), draggableMaker, draggableMakerGrid, 0, Color.AQUA);
        }

        for (int i = 0; i <= 7; i++){
            locatePeices.setPawnY(600);
            locatePeices.setPawnX(i*100);
            Pawn pawnWhite = new Pawn(pane, controlSize, locatePeices.getPawnX(), locatePeices.getPawnY(), draggableMaker, draggableMakerGrid, 1,Color.AQUA);
        }

        locatePeices.setKingX(400);
        locatePeices.setKingY(0);
        King kingBlack = new King(pane, controlSize, locatePeices.getKingX(), locatePeices.getKingY(), draggableMaker, draggableMakerGrid, 0, Color.RED);

        locatePeices.setKingY(700);
        King kingWhite = new King(pane, controlSize, locatePeices.getKingX(), locatePeices.getKingY(), draggableMaker, draggableMakerGrid, 1, Color.PURPLE);
//
//
//        Knight knight = new Knight(pane, controlSize, locatePeices.getKnightX(), locatePeices.getKnightY(), draggableMaker, draggableMakerGrid, 0);
//
//        Bishop bishop = new Bishop(pane, controlSize, locatePeices.getBishopX(), locatePeices.getBishopY(), draggableMaker, draggableMakerGrid, 0);
//
//        Rook rook = new Rook(pane, controlSize, locatePeices.getRookX(), locatePeices.getRookY(), draggableMaker, draggableMakerGrid, 0);
//
//        Queen queen = new Queen(pane, controlSize, locatePeices.getQueenX(), locatePeices.getQueenY(), draggableMaker, draggableMakerGrid, 0);
//



    }

}
