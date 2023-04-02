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



    }



}
