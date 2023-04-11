package com.example.chessfxfinalporjectversion2;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.nio.file.Path;
import java.nio.file.Paths;
/**
 *
 * @params setting the path to the images,
 *              as well as the foundation of all the peices generated
 * @author Jagger
 */

public class  PeicesComponents extends ImageView {

    private String color;
    private String type;

    private Rectangle rectangle;
    private int startPositionY;
    private int startPositionX;

    private Path absoulutPath = Paths.get("");

    private String path = absoulutPath.toAbsolutePath() + "\\src\\main\\java\\PiecesImages\\";

    private ImageView myImageView;

    public PeicesComponents(int size, int startPositionX, int startPositionY){
//        System.out.println(absoulutPath.toAbsolutePath());
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


