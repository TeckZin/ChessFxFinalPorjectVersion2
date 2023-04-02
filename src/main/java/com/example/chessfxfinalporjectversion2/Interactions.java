package com.example.chessfxfinalporjectversion2;

import javafx.scene.Node;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Rectangle;

import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;

public class Interactions {

    private AnchorPane pane;
    private Object actionObject;
    private Object stillObject;
    private Pawn pawn;
    private Rook rook;
    private Knight knight;
    private Bishop bishop;
    private King king;
    private Queen queen;

    private boolean sameLoaction;


    public Interactions(AnchorPane pane, Object actionObject, Object stillObject){
            this.pane = pane;
            this.actionObject = actionObject;
            this.stillObject = stillObject;
    }

    public Interactions(AnchorPane pane, Object actionObject){
        this.pane = pane;
        this.actionObject = actionObject;
    }

    public Interactions(){}

    public void objectOnObject(){
        Rectangle rectangleAction = getRectangleObject(actionObject);
        Rectangle rectangleStill = getRectangleObject(stillObject);
        int actionX = (int) rectangleAction.getX();
        int actionY = (int) rectangleAction.getY();
        int stillX = (int) rectangleStill.getX();
        int stillY = (int) rectangleStill.getY();

        if(actionX == stillX && stillY == actionY){
            sameLoaction = true;
            PeiceActions peiceActions = new PeiceActions(pane, rectangleStill);

        }


    }


    public Rectangle getRectangleObject(Object o){
        String name = o.getClass().getName();

        if(name.equals(pawn.getName())){
            pawn = (Pawn) o;
            return pawn.getRectangle();
        }else if (name.equals(rook.getName())){
            rook = (Rook) o;
            return rook.getRectangle();
        }else if (name.equals(knight.getName())){
            knight = (Knight) o;
            return knight.getRectangle();
        }else if (name.equals(bishop.getName())){
            bishop = (Bishop) o;
            return bishop.getRectangle();
        }else if (name.equals(king.getName())){
            king = (King) o;
            return king.getRectangle();
        }else if (name.equals(queen.getName())) {
            queen = (Queen) o;
            return queen.getRectangle();
        }


        return null;
    }

    public void isBeingDrag(Node node){

    }










}
