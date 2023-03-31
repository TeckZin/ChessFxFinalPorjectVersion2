package com.example.chessfxfinalporjectversion2;

import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Bishop extends PeicesAbstract {

    private Rectangle rectangle;
    private int positionX;
    private int positionY;

    private int controlSize;

    private Color color;
    private String name = "Bishop";
    public Bishop(AnchorPane pane, int controlSize, int positionX, int positionY, DraggableMaker draggableMaker, DraggableMakerGrid draggableMakerGrid, int colorBit, Color color) {
        Color textColor = Color.web("#000000");

        setPositionX(positionX);
        setPositionY(positionY);
        setControlSize(controlSize);
        setColor(color);

//        Text text = new Text();
//        text.setText(name);
//        text.setX(positionX);
//        text.setY(positionY);
//        text.setFill(textColor);
//        text.setFont(Font.font("Verdana",20));




        PeicesComponents peicesComponents = new PeicesComponents(controlSize, positionX, positionY);
        this.rectangle = peicesComponents.getRectangle();


        rectangle.setFill(color);
        pane.getChildren().add(peicesComponents.getRectangle());





        draggableMakerGrid.makeDraggable(peicesComponents);
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

    @Override
    public Color getColor() {
        return color;
    }

    @Override
    public void setColor(Color color) {
        this.color = color;

    }


}