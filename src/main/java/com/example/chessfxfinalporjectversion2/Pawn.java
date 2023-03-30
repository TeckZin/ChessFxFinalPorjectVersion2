package com.example.chessfxfinalporjectversion2;


import javafx.scene.Group;
import javafx.scene.shape.Rectangle;

public class Pawn extends PeicesAbstract {



    private int positionX;
    private int positionY;

    private int size;
    private String name = "pawn";


    public Pawn(Group root, int size, int positionX, int positionY){
        setPositionX(positionX);
        setPositionY(positionY);
        setSize(size);

        PeicesMethod peice = new PeicesMethod(size,positionX,positionY);

        Rectangle rec = peice.getRectangle();

        root.getChildren().add(rec);




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
    public int getSize() {
        return size;
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
    public void setSize(int size) {
        this.size = size;

    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }
}
