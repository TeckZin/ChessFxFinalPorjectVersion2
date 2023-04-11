package com.example.chessfxfinalporjectversion2;

import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.layout.AnchorPane;

/**
 *
 * @extend GridBase -- the layout of the baord
 * @implements GRidInterface --- the const value for all the Grid and Layout
 * @params make the snapping effect the peices by using rounding to the nearest 100;
 * @author Teck
 */

public class DraggableMakerGrid extends GridBase implements GridInterface{

        private double mouseAnchorX;
        private double mouseAnchorY;

        public DraggableMakerGrid(int controlSize, int file, int rank, AnchorPane anchorPane) {
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

    /**
     *
     * @params the snapping effect of the peices
     * @author Teck
     */

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
