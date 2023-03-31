package com.example.chessfxfinalporjectversion2;

import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.layout.AnchorPane;

public class DraggableMakerGrid extends GridBase{

        private double mouseAnchorX;
        private double mouseAnchorY;

        public DraggableMakerGrid(int controlSize, int file, int rank, AnchorPane anchorPane){
            super(controlSize, file, rank, anchorPane);

        }

        public void makeDraggable(Node node){
            node.setOnMouseReleased(mouseEvent -> {
                mouseAnchorX = mouseEvent.getSceneX();
                mouseAnchorY = mouseEvent.getSceneY();

                int x = (int) ((mouseAnchorX/getControlSize()) % getFile()) * getControlSize();
                int y = (int) ((mouseAnchorY/getControlSize()) % getRank()) * getControlSize();

                node.setLayoutX(x);
                node.setLayoutY(y);


            });



        }

    public void makeDraggable(PeicesComponents peicesComponents){
        Node node = peicesComponents.getRectangle();
        node.setOnMouseReleased(mouseEvent -> {
            mouseAnchorX = mouseEvent.getSceneX()- 100;
            mouseAnchorY = mouseEvent.getSceneY() - 100;



            int x = (int) ((mouseAnchorX/getControlSize()) % getFile()) * getControlSize();
            int y = (int) ((mouseAnchorY/getControlSize()) % getRank()) * getControlSize();

            node.setLayoutX(x - peicesComponents.getStartPositionX());
            node.setLayoutY(y - peicesComponents.getStartPositionY());


        });



    }

}
