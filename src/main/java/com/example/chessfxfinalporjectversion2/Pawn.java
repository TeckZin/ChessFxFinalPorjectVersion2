package com.example.chessfxfinalporjectversion2;


import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Rectangle;

public class Pawn extends PeicesAbstract {


    private Rectangle rectangle;
    private int positionX;
    private int positionY;

    private int controlSize;
    private String name = "pawn";


    public Pawn(AnchorPane pane, int controlSize, int positionX, int positionY, DraggableMaker draggableMaker){
        setPositionX(positionX);
        setPositionY(positionY);
        setControlSize(controlSize);




        PeicesComponents peicesComponents = new PeicesComponents(controlSize, positionX, positionY);
        pane.getChildren().add(peicesComponents.getRectangle());


        draggableMaker.makeDraggable(peicesComponents.getRectangle());



    }


    @Override
    public int getPositionX() {
        return positionX;
    }

    @Override
    public int getPositionY() {
        return positionY;
    }

    @Override
    public int getControlSize() {
        return controlSize;
    }

    @Override
    public void setPositionX(int positionX) {
        this.positionX = positionX;

    }

    @Override
    public void setPositionY(int positionY) {
        this.positionY = positionY;

    }

    @Override
    public void setControlSize(int controlSize) {
        this.controlSize = controlSize;

    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void getRectangle() {

    }

    @Override
    public Rectangle setRectangle() {
        return rectangle;
    }


}
