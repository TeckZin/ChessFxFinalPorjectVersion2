package com.example.chessfxfinalporjectversion2;

import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Peices {

    private Rectangle rectangle;
    private int startPositionY;
    private int startPositionX;

    public Peices(int size, int startPositionX, int startPositionY){
        Color color = Color.web("#FF0000");

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
