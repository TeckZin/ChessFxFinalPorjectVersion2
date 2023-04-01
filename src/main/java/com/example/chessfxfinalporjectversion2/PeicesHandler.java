package com.example.chessfxfinalporjectversion2;

import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;

import java.nio.channels.Pipe;

public class PeicesHandler {

    private AnchorPane pane;
    private int controlSize;
    private DraggableMakerGrid draggableMakerGrid;
    private DraggableMaker draggableMaker;


    private String FEN;

    private int pawnX;
    private int rookX;
    private int knightX;
    private int bishopX;
    private int kingX;
    private int queenX;
    private int pawnY;
    private int rookY;
    private int knightY;
    private int bishopY;
    private int kingY;
    private int queenY;


    Pawn pawn;
    Rook rook;
    Knight knight;
    Bishop bishop;
    King king;
    Queen queen;

    int file = 0;
    int rank = 0;






    public PeicesHandler(AnchorPane pane, int controlSize, DraggableMaker draggableMaker, DraggableMakerGrid draggableMakerGrid, String FEN){
        this.pane = pane;
        this.controlSize = controlSize;
        this.draggableMaker = draggableMaker;
        this.draggableMakerGrid = draggableMakerGrid;
        this.FEN = FEN;
        fenConverter();



        loadDefaulStartPosition();









    }
    // https://stackoverflow.com/questions/5762491/how-to-print-color-in-console-using-system-out-println
    private void fenConverter(){
        System.out.println("Loading Fen Peices......");
        System.out.printf("FEN STRING --> <%s>", FEN);
        System.out.println("-------------------------------");
        boolean beforeIsLetter = false;
        int fenLength = FEN.length();
        System.out.printf("\033[4;35mStarting LOOP%n\033[0m");
        for(int i = 0; i < fenLength; i++){


            char fenCharacter = FEN.charAt(i);
            System.out.printf("\033[0;36mCurrecnt Character: <%c>%n\033[0m", fenCharacter);
            if(fenCharacter == ' '){
                System.out.println("\033[4;31mSpace dected porgram break\033[0m");
                break;
            } else if (fenCharacter == '/'){
                beforeIsLetter = false;
                System.out.printf("\033[0;33mGenerating new line%n\033[0m");
                rank++;
                file = 0;
            } else if(Character.isDigit(fenCharacter)){
                beforeIsLetter = false;
                int xAxis = Integer.parseInt(String.valueOf(fenCharacter));
                System.out.printf("\033[0;32m" + "Adding xAxis: <%d> to file <%d> = <%d>%n\033[0m", xAxis, file, file + xAxis);
                file += xAxis;
            }else if(Character.isAlphabetic(fenCharacter)){
                if(beforeIsLetter){
                    file++;
                }
                if(Character.isUpperCase(fenCharacter)){ //white == 1, black == 0
                    loadPeice(1, fenCharacter);
                    beforeIsLetter = true;
                } else {
                    loadPeice(0, fenCharacter);
                    beforeIsLetter = true;
                }
            }

            if(rank == 8){
                System.out.println("\033[4;31mRank is 8 Break\033[0m");
                break;
            }
        }
        System.out.println("Completed Loading Fen Peices");

    }

    private void loadPeice(int colorBit, char fenCharacter){
        System.out.println("Loading a Piece --> ");
        fenCharacter = Character.toLowerCase(fenCharacter);

        if(fenCharacter == 'p'){
            System.out.printf("pawn Color: <%d>%n", colorBit);
            System.out.printf("File: <%d> Rank:<%d>%n", file, rank);

           setPawnX((file)*100);
           setPawnY((rank)*100);

           pawn = new Pawn(pane, controlSize, getPawnX(), getPawnY()
                   , draggableMaker, draggableMakerGrid,
                   colorBit, Color.web("#5EC4BD"));
        } else if (fenCharacter == 'r'){
            System.out.printf("rook Color: <%d>%n", colorBit);
            System.out.printf("File: <%d> Rank:<%d>%n", file, rank);
            setRookX(file*100);
            setRookY(rank*100);

            rook = new Rook(pane, controlSize, getRookX(), getRookY(),
                            draggableMaker, draggableMakerGrid,
                            colorBit, Color.web("#65C45E"));

        } else if (fenCharacter == 'n'){
            System.out.printf("knight Color: <%d>%n", colorBit);
            System.out.printf("File: <%d> Rank:<%d>%n", file, rank);
            setKnightX(file*100);
            setKnightY(rank*100);

            knight= new Knight(pane, controlSize, getKnightX(), getKnightY(),
                    draggableMaker, draggableMakerGrid,
                    colorBit, Color.web("#EB8801"));


        } else if (fenCharacter == 'b') {
            System.out.printf("bishop Color: <%d>%n", colorBit);
            System.out.printf("File: <%d> Rank:<%d>%n", file, rank);
            setBishopX(file*100);
            setBishopY(rank*100);

            bishop = new Bishop(pane, controlSize, getBishopX(), getBishopY(),
                    draggableMaker, draggableMakerGrid,
                    colorBit, Color.web("#F207C7"));


        } else if (fenCharacter == 'k'){
            System.out.printf("king Color: <%d>%n", colorBit);
            System.out.printf("File: <%d> Rank:<%d>%n", file, rank);
            setKingX(file*100);
            setKingY(rank*100);

            king = new King(pane, controlSize, getKingX(), getKingY(),
                    draggableMaker, draggableMakerGrid,
                    colorBit, Color.web("#070FF2"));


        } else if(fenCharacter == 'q'){
            System.out.printf("queen Color: <%d>%n", colorBit);
            System.out.printf("File: <%d> Rank:<%d>%n", file, rank);
            setQueenX(file*100);
            setQueenY(rank*100);

            queen = new Queen(pane, controlSize, getQueenX(), getQueenY(),
                    draggableMaker, draggableMakerGrid,
                    colorBit, Color.web("#F20707"));


        }

    }


    public PeicesHandler(){
        System.out.println("Admin Access");

    }


    public void loadDefaulStartPosition(){
        System.out.println("Loading Deafault Start Position");


//        for (int i = 0; i <= 7; i++){
//            locatePeices.setPawnWhiteY(100);
//            locatePeices.setPawnWhiteX(i*100);
//            Pawn pawnBlack = new Pawn(pane, controlSize, locatePeices.getPawnWhiteX(), locatePeices.getPawnWhiteY(), draggableMaker, draggableMakerGrid, 0, Color.AQUA);
//            locatePeices.setPawnBlackY(600);
//            locatePeices.setPawnBlackX(i*100);
//            Pawn pawnWhite = new Pawn(pane, controlSize, locatePeices.getPawnBlackX(), locatePeices.getPawnBlackY(), draggableMaker, draggableMakerGrid, 1,Color.web("#0C7479"));
//
//        }
//
//
//        locatePeices.setKingWhiteX(400);
//        locatePeices.setKingWhiteY(0);
//        King kingBlack = new King(pane, controlSize, locatePeices.getKingWhiteX(), locatePeices.getKingWhiteY(), draggableMaker, draggableMakerGrid, 0, Color.RED);
//
//        locatePeices.setKingBlackX(400);
//        locatePeices.setKingBlackY(700);
//        King kingWhite = new King(pane, controlSize, locatePeices.getKingBlackX(), locatePeices.getKingBlackY(), draggableMaker, draggableMakerGrid, 1, Color.web("#720D15"));
//
//
//        Knight knight = new Knight(pane, controlSize, locatePeices.getKnightX(), locatePeices.getKnightY(), draggableMaker, draggableMakerGrid, 0);
//
//        Bishop bishop = new Bishop(pane, controlSize, locatePeices.getBishopX(), locatePeices.getBishopY(), draggableMaker, draggableMakerGrid, 0);
//
//        Rook rook = new Rook(pane, controlSize, locatePeices.getRookX(), locatePeices.getRookY(), draggableMaker, draggableMakerGrid, 0);
//
//        Queen queen = new Queen(pane, controlSize, locatePeices.getQueenX(), locatePeices.getQueenY(), draggableMaker, draggableMakerGrid, 0);


        System.out.println("Load competed");

    }
    public int getPawnX() {
        return pawnX;
    }

    public void setPawnX(int pawnX) {
        this.pawnX = pawnX;
    }

    public int getRookX() {
        return rookX;
    }

    public void setRookX(int rookX) {
        this.rookX = rookX;
    }

    public int getKnightX() {
        return knightX;
    }

    public void setKnightX(int knightX) {
        this.knightX = knightX;
    }

    public int getBishopX() {
        return bishopX;
    }

    public void setBishopX(int bishopX) {
        this.bishopX = bishopX;
    }

    public int getKingX() {
        return kingX;
    }

    public void setKingX(int kingX) {
        this.kingX = kingX;
    }

    public int getQueenX() {
        return queenX;
    }

    public void setQueenX(int queenX) {
        this.queenX = queenX;
    }

    public int getPawnY() {
        return pawnY;
    }

    public void setPawnY(int pawnY) {
        this.pawnY = pawnY;
    }

    public int getRookY() {
        return rookY;
    }

    public void setRookY(int rookY) {
        this.rookY = rookY;
    }

    public int getKnightY() {
        return knightY;
    }

    public void setKnightY(int knightY) {
        this.knightY = knightY;
    }

    public int getBishopY() {
        return bishopY;
    }

    public void setBishopY(int bishopY) {
        this.bishopY = bishopY;
    }

    public int getKingY() {
        return kingY;
    }

    public void setKingY(int kingY) {
        this.kingY = kingY;
    }

    public int getQueenY() {
        return queenY;
    }

    public void setQueenY(int queenY) {
        this.queenY = queenY;
    }

    public Pawn getPawn() {
        return pawn;
    }

    public void setPawn(Pawn pawn) {
        this.pawn = pawn;
    }

    public Rook getRook() {
        return rook;
    }

    public void setRook(Rook rook) {
        this.rook = rook;
    }

    public Knight getKnight() {
        return knight;
    }

    public void setKnight(Knight knight) {
        this.knight = knight;
    }

    public Bishop getBishop() {
        return bishop;
    }

    public void setBishop(Bishop bishop) {
        this.bishop = bishop;
    }

    public King getKing() {
        return king;
    }

    public void setKing(King king) {
        this.king = king;
    }

    public Queen getQueen() {
        return queen;
    }

    public void setQueen(Queen queen) {
        this.queen = queen;
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


}
