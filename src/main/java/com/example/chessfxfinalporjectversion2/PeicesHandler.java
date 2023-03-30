package com.example.chessfxfinalporjectversion2;

import javafx.scene.Group;

public class PeicesHandler{
    Group root;
    public PeicesHandler(Group root){
        this.root = root;
        Pawn pawn = new Pawn(root, 100,200,200 );

    }

}
