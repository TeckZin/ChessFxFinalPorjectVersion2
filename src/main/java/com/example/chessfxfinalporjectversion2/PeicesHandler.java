package com.example.chessfxfinalporjectversion2;

import javafx.scene.Group;
import javafx.scene.layout.AnchorPane;

public class PeicesHandler{



    public PeicesHandler(AnchorPane pane, int controlSize, DraggableMaker draggableMaker, DraggableMakerGrid draggableMakerGrid){
        LocatePeices locatePeices = new LocatePeices();


        Pawn pawn = new Pawn(pane, controlSize, locatePeices.getPawnX(), locatePeices.getPawnY(), draggableMaker, draggableMakerGrid);




    }

}
