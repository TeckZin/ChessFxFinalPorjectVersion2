package com.example.chessfxfinalporjectversion2;

import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;



public class GridHandler extends GridBase implements GridInterface{





    public GridHandler( int controlSize, int file, int rank, AnchorPane anchorPane) {
        super(controlSize, file,rank ,anchorPane);

    }

    public void updateGrid() {

        System.out.println("\033[1;92mGENERATING BROAD\033[0m");


        /**
         *
         * @params generating the actual board of the game
         * @author Jagger
         */
        for (int file = 0; file < getFile(); ++file) {
            for (int rank = 0; rank < getRank(); ++rank) {
                boolean lightSqaureBoolean = (file + rank) % 2 != 0;
                Color color = Color.web("#D2B48D");
                if (lightSqaureBoolean) {
                    color = Color.web("#AF6E4D");
                }

                Rectangle rec = new Rectangle();
                rec.setX((double) (file * getControlSize()));
                rec.setY((double) (rank * getControlSize()));
                rec.setWidth((double) getControlSize());
                rec.setHeight((double) getControlSize());
                rec.setFill(color);



                getAnchorPane().getChildren().add(rec);





            }
        }

        System.out.println("\033[1;92mBOARD GENERATION COMPLETE\033[0m");
        System.out.println("-------------------------------------------");

    }
}
