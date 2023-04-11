package com.example.chessfxfinalporjectversion2;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.event.EventTarget;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;

public class Interactions {

    private Rectangle rectangle;

    private AnchorPane pane;
    private Object actionObject;
    private Object stillObject;
    private Pawn pawn = new Pawn();
    private Rook rook = new Rook();
    private Knight knight = new Knight();
    private Bishop bishop = new Bishop();
    private King king = new King();
    private Queen queen = new Queen();

    private ArrayList<Object> peicesOnBoard;

    private boolean pressed;

    private Image image;

    private boolean sameLoaction;

    private boolean dragged;

    private boolean changes;

    private int startingX = 1000;
    private int startingY = 1000;

    private int afterX = 1000;
    private int afterY = 1000;


    public Interactions(AnchorPane pane, Object actionObject, Object stillObject){
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

    public Interactions(AnchorPane pane){
        this.pane = pane;

    }

    public void addEventHandlers(AnchorPane pane, ArrayList<Object> peicesOnBoard){
        this.peicesOnBoard = peicesOnBoard;


        pane.setOnDragDetected(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent mouseEvent) {


                EventTarget target = mouseEvent.getTarget();




                try{
                    System.out.println("Working");
                    startingX = (int) Math.floor(mouseEvent.getX()/100)*100;
                    startingY = (int) Math.floor(mouseEvent.getY()/100)*100;

                    for(Object o : peicesOnBoard) {
                        int tempXO = getObjectTempX(o);
                        int tempYO = getObjectTempY(o);
                        if(startingX == tempXO && startingY == tempYO) {
                            changes = true;
                            stillObject = o;
                            break;
                        }


                    }

                    dragged = true;
//                    System.out.println(mouseEvent.getX());
//                    System.out.println(mouseEvent.getY());


                } catch (Exception e){
                    System.out.println("AnchorPane");
                }

            }
        });

        pane.setOnMouseReleased(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                EventTarget target = mouseEvent.getTarget();

                try{


                    System.out.println("Realsed");



                    afterX = (int) Math.floor(mouseEvent.getX()/100)*100;
                    afterY = (int) Math.floor(mouseEvent.getY()/100)*100;





                    ArrayList<Object> movingPeices = new ArrayList<Object>();
                    int index = 0;
                    if(dragged){

                        if(changes){
                            int x = getObjectTempX(stillObject);
                            int y = getObjectTempY(stillObject);

                            System.out.printf("Moving Object: <%d, %d> Target: <%d, %d>%n"
                                                , x, y, afterX, afterY);

                            for (Object o : peicesOnBoard){
                                int locaterX = getObjectTempX(o);
                                int locaterY = getObjectTempY(o);
                                if(locaterY == afterY && locaterX == afterX){
                                    System.out.printf("Moving Object: <%d, %d> ObjectTarget: <%d, %d>%n"
                                                    , x, y, locaterX, locaterY);
                                    Rectangle rectangle1 = getRectangleObject(o);
                                    System.out.println(o);
                                    peicesOnBoard.remove(o);
                                    peiceRemovel(rectangle1);
                                }


//                                if(locaterY == y && locaterX == x){
//                                    movingPeices.add(o);
//                                    System.out.println("moving");
//                                    break;
//
//                                }


                            }

//                            System.out.printf("Before: <x: %d, y: %d> After: <x: %d, y: %d>%n",x,y,afterX,afterY );
                            setObjectTempXY(afterX, afterY, stillObject);


                        }







//                       isTaken(stillObject, actionObject);
                        dragged = false;
                    }


                } catch (Exception e){
                    System.out.println("Realsed Anchor");
                }



            }
        });



    }

    public void isTaken(Object stillObject, Object actionObject){
        System.out.println(stillObject);
        System.out.println(actionObject);
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




//    public void objectOnObject(){
//        Rectangle rectangleAction = getRectangleObject(actionObject);
//        Rectangle rectangleStill = getRectangleObject(stillObject);
//        int actionX = (int) rectangleAction.getX();
//        int actionY = (int) rectangleAction.getY();
//        int stillX = (int) rectangleStill.getX();
//        int stillY = (int) rectangleStill.getY();
//
//        if(actionX == stillX && stillY == actionY){
//            sameLoaction = true;
//            peiceRemovel(rectangleStill);
//
//        }
//
//
//    }

    public void peiceRemovel(Rectangle rectangle){

        System.out.println("Object Remove");

        pane.getChildren().remove(rectangle);



    }



    public Rectangle getRectangleObject(Object o){
        String name = o.getClass().getName();

        if(name.equals(pawn.getClass().getName())){
            pawn = (Pawn) o;
            return pawn.getRectangle();
        }else if (name.equals(rook.getClass().getName())){
            rook = (Rook) o;
            return rook.getRectangle();
        }else if (name.equals(knight.getClass().getName())){
            knight = (Knight) o;
            return knight.getRectangle();
        }else if (name.equals(bishop.getClass().getName())){
            bishop = (Bishop) o;
            return bishop.getRectangle();
        }else if (name.equals(king.getClass().getName())){
            king = (King) o;
            return king.getRectangle();
        }else if (name.equals(queen.getClass().getName())) {
            queen = (Queen) o;
            return queen.getRectangle();
        }


        return null;
    }

    public int getObjectTempX(Object o){
        String name = o.getClass().getName();

        if(name.equals(pawn.getClass().getName())){
            pawn = (Pawn) o;
            return pawn.getTempX();
        }else if (name.equals(rook.getClass().getName())){
            rook = (Rook) o;
            return rook.getTempX();
        }else if (name.equals(knight.getClass().getName())){
            knight = (Knight) o;
            return knight.getTempX();
        }else if (name.equals(bishop.getClass().getName())){
            bishop = (Bishop) o;
            return bishop.getTempX();
        }else if (name.equals(king.getClass().getName())){
            king = (King) o;
            return king.getTempX();
        }else if (name.equals(queen.getClass().getName())) {
            queen = (Queen) o;
            return queen.getTempX();
        }


        return 0;
    }

    public int getObjectTempY(Object o){
        String name = o.getClass().getName();

        if(name.equals(pawn.getClass().getName())){
            pawn = (Pawn) o;
            return pawn.getTempY();
        }else if (name.equals(rook.getClass().getName())){
            rook = (Rook) o;
            return rook.getTempY();
        }else if (name.equals(knight.getClass().getName())){
            knight = (Knight) o;
            return knight.getTempY();
        }else if (name.equals(bishop.getClass().getName())){
            bishop = (Bishop) o;
            return bishop.getTempY();
        }else if (name.equals(king.getClass().getName())){
            king = (King) o;
            return king.getTempY();
        }else if (name.equals(queen.getClass().getName())) {
            queen = (Queen) o;
            return queen.getTempY();
        }
        return 0;
    }

    public void setObjectTempXY(int x1, int y1, Object o){

        int x = (int) x1;
        int y = (int) y1;


        String name = o.getClass().getName();
        if(name.equals(pawn.getClass().getName())){
            pawn = (Pawn) o;
            pawn.setTempX(x);
            pawn.setTempY(y);
        }else if (name.equals(rook.getClass().getName())){
            rook = (Rook) o;
            pawn.setTempX(x);
            pawn.setTempY(y);
        }else if (name.equals(knight.getClass().getName())){
            knight = (Knight) o;
            pawn.setTempX(x);
            pawn.setTempY(y);
        }else if (name.equals(bishop.getClass().getName())){
            bishop = (Bishop) o;
            pawn.setTempX(x);
            pawn.setTempY(y);
        }else if (name.equals(king.getClass().getName())){
            king = (King) o;
            pawn.setTempX(x);
            pawn.setTempY(y);
        }else if (name.equals(queen.getClass().getName())) {
            queen = (Queen) o;
            pawn.setTempX(x);
            pawn.setTempY(y);
        }
    }




    public boolean getPressed() {
        return pressed;
    }

    public void setPressed(boolean pressed) {
        this.pressed = pressed;
    }



}
