package com.example.chessfxfinalporjectversion2;

import javafx.scene.layout.AnchorPane;

public class PeiceActions {
    String name;
    private AnchorPane pane;
    private Object o;
    private Pawn pawn;
    private Rook rook;
    private Knight knight;
    private Bishop bishop;
    private King king;
    private Queen queen;


    public PeiceActions(AnchorPane pane, Object o){
        this.pane =  pane;
        this.o = o;
        this.name = o.getClass().getName();
    }

    public void peiceRemovel(){
        if(name.equals(pawn.getName())){
            pawn = (Pawn) o;
            pane.getChildren().remove(pawn.getRectangle());
        }else if (name.equals(rook.getName())){
            rook = (Rook) o;
            pane.getChildren().remove(rook.getRectangle());
        }else if (name.equals(knight.getName())){
            knight = (Knight) o;
            pane.getChildren().remove(knight.getRectangle());
        }else if (name.equals(bishop.getName())){
            bishop = (Bishop) o;
            pane.getChildren().remove(bishop.getRectangle());
        }else if (name.equals(king.getName())){
            king = (King) o;
            pane.getChildren().remove(king.getRectangle());
        }else if (name.equals(queen.getName())) {
            queen = (Queen) o;
            pane.getChildren().remove(queen.getRectangle());
        }

    }
}
