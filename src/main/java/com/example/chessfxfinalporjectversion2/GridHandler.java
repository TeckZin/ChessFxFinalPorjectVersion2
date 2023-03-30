package com.example.chessfxfinalporjectversion2;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class GridHandler {





    public GridHandler(Group root) {
        System.out.println("Board Generated");
        int controlSize = 70;

        for (int file = 0; file < 8; ++file) {
            for (int rank = 0; rank < 8; ++rank) {
                boolean lightSqaureBoolean = (file + rank) % 2 != 0;
                Color color = Color.web("#F06774");
                if (lightSqaureBoolean) {
                    color = Color.web("#D5DF71");
                }

                Rectangle rec = new Rectangle();
                rec.setX((double) (file * controlSize + 100));
                rec.setY((double) (rank * controlSize + 80));
                rec.setWidth((double) controlSize);
                rec.setHeight((double) controlSize);
                rec.setFill(color);
                root.getChildren().add(rec);
            }
        }
    }
}
