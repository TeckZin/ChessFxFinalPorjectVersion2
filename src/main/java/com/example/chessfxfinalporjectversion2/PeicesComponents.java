package com.example.chessfxfinalporjectversion2;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class  PeicesComponents extends ImageView {

    private String color;
    private String type;

    private Rectangle rectangle;
    private int startPositionY;
    private int startPositionX;

    private String path =  "C:\\Users\\Jagger Hershey\\Desktop\\Semester 2\\Comp Sci 2\\Labs and Projects\\Intellij Projects\\ChessFxFinalPorjectVersion2\\src\\main\\java\\PiecesImages\\";

    private ImageView myImageView;

    public PeicesComponents(int size, int startPositionX, int startPositionY){
        Color color = Color.web("#18B3BB");

        this.startPositionX = startPositionX;
        this.startPositionY = startPositionY;

        rectangle = new Rectangle(startPositionX, startPositionY, size, size);
//        rectangle.setFill(color);

    }

    public void setPiece(Image image){
        myImageView.setImage(image);
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

    public String getPath(){
        return path;
    }

}


