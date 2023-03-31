package com.example.chessfxfinalporjectversion2;


import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

import java.util.concurrent.RecursiveAction;

public class Pawn extends PeicesAbstract {


    private Rectangle rectangle;
    private int positionX;
    private int positionY;

    private int controlSize;
    private String name = "pawn";




    public Pawn(AnchorPane pane, int controlSize, int positionX, int positionY, DraggableMaker draggableMaker, DraggableMakerGrid draggableMakerGrid){
        Color textColor = Color.web("#000000");

        setPositionX(positionX);
        setPositionY(positionY);
        setControlSize(controlSize);

//        Text text = new Text();
//        text.setText(name);
//        text.setX(positionX);
//        text.setY(positionY);
//        text.setFill(textColor);
//        text.setFont(Font.font("Verdana",20));




        PeicesComponents peicesComponents = new PeicesComponents(controlSize, positionX, positionY);
        this.rectangle = peicesComponents.getRectangle();
        Color color = Color.web("#18B3BB");

        rectangle.setFill(color);
        pane.getChildren().addAll(peicesComponents.getRectangle());





        draggableMakerGrid.makeDraggable(peicesComponents);
        draggableMaker.makeDraggable(peicesComponents.getRectangle());







    }

//    @FXML
//    public void generatedImage(){
//        Image img = new Image("");
//        rectangle.setFill(new ImagePattern(img));
//    }


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
