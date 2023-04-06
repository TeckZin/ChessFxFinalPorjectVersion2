package com.example.chessfxfinalporjectversion2;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class  PeicesComponents {

    private Rectangle rectangle;
    private int startPositionY;
    private int startPositionX;

    public PeicesComponents(int size, int startPositionX, int startPositionY){
        Color color = Color.web("#18B3BB");

        this.startPositionX = startPositionX;
        this.startPositionY = startPositionY;

        rectangle = new Rectangle(startPositionX, startPositionY, size, size);
        rectangle.setFill(color);



    }

    public Rectangle getRectangle(){
        return rectangle;
    }
    public int getStartPositionX(){
        return startPositionX;
    }

    public int getStartPositionY(){
        return startPositionY;
    }

}


