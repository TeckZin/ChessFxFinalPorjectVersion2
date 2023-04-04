package com.example.chessfxfinalporjectversion2;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.event.EventTarget;
import javafx.scene.Node;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;

public class Interactions {

    private Rectangle rectangle;

    private AnchorPane pane;
    private Object actionObject;
    private Object stillObject;
    private Pawn pawn;
    private Rook rook;
    private Knight knight;
    private Bishop bishop;
    private King king;
    private Queen queen;



    private boolean pressed;

    private boolean sameLoaction;


    public Interactions(Object actionObject, Object stillObject){
            this.pane = pane;
            this.actionObject = actionObject;
            this.stillObject = stillObject;
    }

    public Interactions(AnchorPane pane, Rectangle actionObject){

        this.pane = pane;
        this.actionObject = actionObject;




        this.rectangle = actionObject;
        
//        rectangle.setOnMousePressed(event -> preseed(event, actionObject));
//        rectangle.setOnMouseDragged(event -> dragged(event, actionObject));
//        rectangle.setOnMousePressed(event -> preseed(event, actionObject));



    }

    public Interactions(){}

    public void addEventHandlers(AnchorPane pane){
        pane.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {


                EventTarget target = mouseEvent.getTarget();
                try{
                    System.out.println("Working");
                    Rectangle rectangle =  (Rectangle) target;

                    System.out.println(rectangle.getId());


                } catch (Exception e){
                    System.out.println("AnchorPane");
                }

            }
        });

    }



//    public void preseed(MouseEvent event, Rectangle rectangle){
//        int x = (int) rectangle.getX();
//        int y = (int) rectangle.getY();
//
//        System.out.printf("\033[0;33m(x: %d, y: %d) --> \033[0;35mPressed \033[0m%n", x, y);
//
//
//
//    }

//    public void dragged(MouseEvent event, Rectangle pawn){
//        System.out.println("Dragged");
//
//    }
//




    public void objectOnObject(){
        Rectangle rectangleAction = getRectangleObject(actionObject);
        Rectangle rectangleStill = getRectangleObject(stillObject);
        int actionX = (int) rectangleAction.getX();
        int actionY = (int) rectangleAction.getY();
        int stillX = (int) rectangleStill.getX();
        int stillY = (int) rectangleStill.getY();

        if(actionX == stillX && stillY == actionY){
            sameLoaction = true;
            peiceRemovel(rectangleStill);

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

    public boolean getPressed() {
        return pressed;
    }

    public void setPressed(boolean pressed) {
        this.pressed = pressed;
    }

    public void peiceRemovel(Rectangle rectangle){

        System.out.println("Object Remove");
        pane.getChildren().remove(rectangle);



    }


}
