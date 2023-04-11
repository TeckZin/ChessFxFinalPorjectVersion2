package com.example.chessfxfinalporjectversion2;

import javafx.scene.Node;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Rectangle;

public class DraggableMaker {
    private double mouseAnchorX;
    private double mouseAnchorY;

    private MouseEvent event;
    public void makeDraggable(Node node){

        node.setOnMousePressed(mouseEvent -> {
            mouseAnchorX = mouseEvent.getX();
            mouseAnchorY = mouseEvent.getY();



        });



        node.setOnMouseDragged(mouseEvent -> {

            node.setLayoutX(mouseEvent.getSceneX() - mouseAnchorX - 100);
            node.setLayoutY(mouseEvent.getSceneY() - mouseAnchorY - 100);



        });












//        Rectangle rectangle = (Rectangle) node;
//        rectangle.setOnMousePressed(event -> pressed(event, rectangle));
//        rectangle.setOnMouseReleased(event -> released(event, rectangle));




    }

//    public void pressed(MouseEvent event, Rectangle rectangle){
//        int x = (int) rectangle.getX();
//        int y = (int) rectangle.getY();
//
//
//        System.out.printf("\033[0;33m(x: %d, y: %d) --> \033[0;35mPressed \033[0m%n", x, y);
//
//
//
//    }

//    public void released(MouseEvent event, Rectangle rectangle){
////        rectangle.setX(mouseAnchorX);
////        rectangle.setY(mouseAnchorY);
//        int x = (int) rectangle.getX();
//        int y = (int) rectangle.getY();
//
//        System.out.printf("\033[0;33m(x: %d, y: %d) --> \033[0;35mRealsed \033[0m%n", x, y);
//
//    }



}
