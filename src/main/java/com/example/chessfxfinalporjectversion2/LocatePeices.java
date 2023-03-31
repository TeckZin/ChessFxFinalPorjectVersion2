package com.example.chessfxfinalporjectversion2;

import javafx.scene.layout.AnchorPane;

public class LocatePeices {




    private int pawnX;
    private int pawnY;
    private int kingX;
    private int kingY;
    private int rookX;
    private int rookY;
    private int queenX;
    private int queenY;
    private int knightX;
    private int knightY;
    private int bishopX;
    private int bishopY;

    private String FEN;

    public LocatePeices(String FEN){
        System.out.println("FEN CALL");
        this.FEN = FEN;
        convertFen();


    }

    private void convertFen(){
//        int file = 0, rank = 0;
//        int fenLength = FEN.length();
//        for(int i = 0; i < 8; i++){
//            String value = "";
//            char c = FEN.charAt(i);
//            if (Character.isDigit(c)) {
//                convertNewLine(value, file, rank);
//            } else if (c == '/') {
//                rank++;
//            }
//            else {
//                value += c;
//            }
//
//
//        }


//
        }
//
//    private void convertNewLine(String value, int file, int rank){
//        file = value.charAt(0);
//
//
//
//    }


    public int getPawnX(){
        return pawnX;
    }

    public void setPawnX(int pawnX) {
        this.pawnX = pawnX;
    }

    public int getPawnY(){
        return pawnY;
    }

    public void setPawnY(int pawnY) {
        this.pawnY = pawnY;
    }

    public int getKingX() {
        return kingX;
    }

    public void setKingX(int kingX) {
        this.kingX = kingX;
    }

    public int getKingY() {
        return kingY;
    }

    public void setKingY(int kingY) {
        this.kingY = kingY;
    }

    public int getRookX() {
        return rookX;
    }

    public void setRookX(int rookX) {
        this.rookX = rookX;
    }

    public int getRookY() {
        return rookY;
    }

    public void setRookY(int rookY) {
        this.rookY = rookY;
    }

    public int getQueenX() {
        return queenX;
    }

    public void setQueenX(int queenX) {
        this.queenX = queenX;
    }

    public int getQueenY() {
        return queenY;
    }

    public void setQueenY(int queenY) {
        this.queenY = queenY;
    }

    public int getKnightX() {
        return knightX;
    }

    public void setKnightX(int knightX) {
        this.knightX = knightX;
    }

    public int getKnightY() {
        return knightY;
    }

    public void setKnightY(int knightY) {
        this.knightY = knightY;
    }

    public int getBishopX() {
        return bishopX;
    }

    public void setBishopX(int bishopX) {
        this.bishopX = bishopX;
    }

    public int getBishopY() {
        return bishopY;
    }

    public void setBishopY(int bishopY) {
        this.bishopY = bishopY;
    }



}
