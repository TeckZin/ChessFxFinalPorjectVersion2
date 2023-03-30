package com.example.chessfxfinalporjectversion2;


import javafx.scene.Group;
import javafx.scene.shape.Rectangle;

public class Pawn {

    Group root;

    public Pawn(Group root){
        this.root = root;
        Peices peice = new Peices(200,220,220);

        Rectangle rec = peice.getRectangle();

        root.getChildren().add(rec);


    }


}
