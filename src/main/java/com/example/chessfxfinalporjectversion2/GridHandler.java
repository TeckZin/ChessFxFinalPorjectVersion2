package com.example.chessfxfinalporjectversion2;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class GridHandler extends GridBase {





    public GridHandler( int controlSize, int file, int rank, AnchorPane anchorPane) {
        super(controlSize, file,rank ,anchorPane);

    }

    public void updateGrid() {
        System.out.println("Board Generated");


        for (int file = 0; file < getFile(); ++file) {
            for (int rank = 0; rank < getRank(); ++rank) {
                boolean lightSqaureBoolean = (file + rank) % 2 != 0;
                Color color = Color.web("#F06774");
                if (lightSqaureBoolean) {
                    color = Color.web("#D5DF71");
                }

                Rectangle rec = new Rectangle();
                rec.setX((double) (file * getControlSize() + 100));
                rec.setY((double) (rank * getControlSize()  + 100));
                rec.setWidth((double) getControlSize());
                rec.setHeight((double) getControlSize());
                rec.setFill(color);
                getAnchorPane().getChildren().add(rec);

            }
        }

    }
}
