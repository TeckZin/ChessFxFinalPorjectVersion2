package com.example.chessfxfinalporjectversion2;

import javafx.fxml.FXML;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.util.concurrent.RecursiveTask;

public abstract class PeicesAbstract {

    private Rectangle rectangle;
    private int positionX;
    private int positionY;

    private int size;
    private String name;

//    @FXML
//    public abstract void generateImage();


    public abstract int getPositionX();

    public abstract int getPositionY();

    public abstract int getControlSize();

    public abstract void setPositionX(int positionX);
    public abstract void setPositionY(int positionY);

    public abstract void setControlSize(int controlSize);

    public abstract String getName();

    public abstract void setName(String name);

    public abstract void getRectangle();
    public abstract Rectangle setRectangle();

    public abstract Color getColor();

    public abstract void setColor(Color color);


}
