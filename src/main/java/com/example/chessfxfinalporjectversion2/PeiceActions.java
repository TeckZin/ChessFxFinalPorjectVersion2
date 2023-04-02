package com.example.chessfxfinalporjectversion2;

import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Rectangle;

public class PeiceActions {
    private String name;
    private Rectangle rectangle;
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
      Interactions interactions = new Interactions();
      rectangle = interactions.getRectangleObject(o);
      pane.getChildren().remove(rectangle);


    }
}
