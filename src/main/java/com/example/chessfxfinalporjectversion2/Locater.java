package com.example.chessfxfinalporjectversion2;

import javafx.scene.shape.Rectangle;

import java.nio.file.DirectoryNotEmptyException;
import java.util.ArrayList;
import java.util.Objects;

public class Locater {

    private ArrayList<Object> piecesOnBoard;




    public Locater(ArrayList<Object> piecesOnBoard){
        this.piecesOnBoard = piecesOnBoard;


    }





    public Rectangle locateRectangleInArrayList(Rectangle locateThisRectangle){
        for(Object o : piecesOnBoard){
            int x1 = (int) locateThisRectangle.getX();
            int y1 = (int) locateThisRectangle.getY();

            Rectangle rectangle = (Rectangle) o;
            int x2 = (int) rectangle.getX();
            int y2 = (int) rectangle.getY();

            if(x1 == x2 && y1 == y2){
               return rectangle;

            }

        }
        return null;
    }

    public void upadateRectangleLocation(Rectangle changeThisRectangle, int x, int y){
        for(Object o : piecesOnBoard){
            Rectangle rectangle = (Rectangle) o;
            if(Objects.equals(rectangle, changeThisRectangle)){
                rectangle.setX((double) x);
                rectangle.setY((double) y);

            }

        }


    }

    public void updateArrayList(){



    }
}
