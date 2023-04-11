package com.example.chessfxfinalporjectversion2;

import javafx.geometry.Insets;
import javafx.scene.layout.AnchorPane;

/**
 *
 * @params basic infomation for allg rid
 * @author Teck
 */

public class GridBase implements GridInterface {
    private int controlSize;
    private int file;
    private int rank;
    private AnchorPane anchorPane;



    public GridBase(int controlSize, int file, int rank, AnchorPane  anchorPane){
        this.controlSize = controlSize;
        this.file = file;
        this.rank = rank;
        this.anchorPane = anchorPane;





    }

    public int getControlSize() {
        return controlSize;
    }

    public void setControlSize(int controlSize) {
        this.controlSize = controlSize;
    }

    public int getFile() {
        return file;
    }

    public void setFile(int file) {
        this.file = file;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public AnchorPane getAnchorPane() {
        return anchorPane;
    }

    public void setAnchorPane(AnchorPane anchorPane) {
        this.anchorPane = anchorPane;
    }




}
