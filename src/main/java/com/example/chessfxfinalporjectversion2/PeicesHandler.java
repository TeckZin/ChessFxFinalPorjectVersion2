package com.example.chessfxfinalporjectversion2;

import javafx.scene.Node;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;

import java.nio.channels.Pipe;
import java.util.ArrayList;

public class PeicesHandler implements GridInterface{

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



    private ArrayList<Object> peicesOnBoard = new ArrayList<Object>();


    Pawn pawn;
    Rook rook;
    Knight knight;
    Bishop bishop;
    King king;
    Queen queen;

    int file = 0;
    int rank = 0;

    boolean consoleInDepthMessages;






    public PeicesHandler(AnchorPane pane, int controlSize, DraggableMaker draggableMaker, DraggableMakerGrid draggableMakerGrid, String FEN){
        this.pane = pane;
        this.controlSize = controlSize;
        this.draggableMaker = draggableMaker;
        this.draggableMakerGrid = draggableMakerGrid;
        this.FEN = FEN;
        file = 0;
        rank = 0;
        fenConverter(FEN);


    }


    // https://stackoverflow.com/questions/5762491/how-to-print-color-in-console-using-system-out-println
    public void fenConverter(String FEN){

        System.out.println("\033[1;92mLOADING FEN PEICES\033[0m");
        System.out.printf("\033[0;33mFEN STRING -->\033[0;36m%n<%s>%n\033[0m", FEN);

        consoleInDepthMessages = false;

        int fenLength = FEN.length();
        System.out.printf("\033[4;35mStarting LOOP%n\033[0m");
        System.out.printf("\033[1;95mREMINDER CONSOLE MESSAGES TURN OFF%n\033[0m");
        boolean newRank = true ;
        boolean emptyFirstFile = false;
        for(int i = 0; i < fenLength; i++) {


            char fenCharacter = FEN.charAt(i);
            if (consoleInDepthMessages){
                System.out.printf("\033[0;36mCurrecnt Character: <%c>%n\033[0m", fenCharacter);
                System.out.printf("\033[0;36mNewRank: <%b>, emptyFirstFile <%b>%n\033[0m", newRank, emptyFirstFile);
            }
            if(fenCharacter == ' '){
                if (consoleInDepthMessages) {
                    System.out.println("\033[4;31mSpace dected porgram break\033[0m");
                }
                break;
            } else if (fenCharacter == '/'){
                if (consoleInDepthMessages) {
                    System.out.printf("\033[0;33mGenerating new line </>Current Rank <%d> %n\033[0m", rank + 1);
                }
                rank++;
                newRank = true;
                file = 0;
            } else if(Character.isDigit(fenCharacter)){

                if (newRank){
                  emptyFirstFile = true;
                }
                newRank = false;
                int xAxis = Integer.parseInt(String.valueOf(fenCharacter));

                if(xAxis == 8){
                   continue;
                } else {
                    if (consoleInDepthMessages) {
                        System.out.printf("\033[0;32m" + "Adding xAxis: <%d> to file <%d> = <%d>%n\033[0m", xAxis, file, file + xAxis);
                    }
                    file += xAxis;


                }
            }else if(Character.isAlphabetic(fenCharacter)){

                if(!newRank){

                    file++;
                    if (consoleInDepthMessages) {
                        System.out.printf("\033[0;34mAdded one to file <%d>%n\033[0m", file);
                    }
                }
                if(emptyFirstFile){
                    file--;
                    if (consoleInDepthMessages) {
                        System.out.printf("\033[0;34mTook one away form file <%d>%n\033[0m", file);
                    }
                    emptyFirstFile = false;
                }



                if(Character.isUpperCase(fenCharacter)){ //white == 1, black == 0
                    loadPeice(1, fenCharacter);
                    newRank = false;

                } else {
                    loadPeice(0, fenCharacter);
                    newRank = false;

                }
            }

            if(rank == 8){
                if (consoleInDepthMessages) {
                    System.out.println("\033[4;31mRank is 8 Break\033[0m");
                }
                newRank = false;

                break;
            }

        }
        System.out.println("\033[1;92m<LOOP ENDED>Completed Loading Fen Peices\033[0m");
        System.out.println("-----------------------------------------");

    }

    private void loadPeice(int colorBit, char fenCharacter){
        if (consoleInDepthMessages) {
            System.out.println("Loading a Piece --> ");
        }
        fenCharacter = Character.toLowerCase(fenCharacter);

        if(fenCharacter == 'p'){
            if (consoleInDepthMessages) {
                System.out.printf("pawn Color: <%d>%n", colorBit);
                System.out.printf("File: <%d> Rank:<%d>%n", file, rank);
            }

           setPawnX((file)*100);
           setPawnY((rank)*100);




           pawn = new Pawn(pane, controlSize, getPawnX(), getPawnY()
                   , draggableMaker, draggableMakerGrid,
                   colorBit, Color.web("#5EC4BD"));




           peicesOnBoard.add(pawn);
        } else if (fenCharacter == 'r'){
            if (consoleInDepthMessages) {
                System.out.printf("rook Color: <%d>%n", colorBit);
                System.out.printf("File: <%d> Rank:<%d>%n", file, rank);
            }
            setRookX(file*100);
            setRookY(rank*100);

            rook = new Rook(pane, controlSize, getRookX(), getRookY(),
                            draggableMaker, draggableMakerGrid,
                            colorBit, Color.web("#65C45E"));
            peicesOnBoard.add(rook);

        } else if (fenCharacter == 'n'){
            if (consoleInDepthMessages) {
                System.out.printf("knight Color: <%d>%n", colorBit);
                System.out.printf("File: <%d> Rank:<%d>%n", file, rank);
            }
            setKnightX(file*100);
            setKnightY(rank*100);

            knight= new Knight(pane, controlSize, getKnightX(), getKnightY(),
                    draggableMaker, draggableMakerGrid,
                    colorBit, Color.web("#EB8801"));

            peicesOnBoard.add(knight);

        } else if (fenCharacter == 'b') {
            if (consoleInDepthMessages) {
                System.out.printf("bishop Color: <%d>%n", colorBit);
                System.out.printf("File: <%d> Rank:<%d>%n", file, rank);
            }
            setBishopX(file*100);
            setBishopY(rank*100);

            bishop = new Bishop(pane, controlSize, getBishopX(), getBishopY(),
                    draggableMaker, draggableMakerGrid,
                    colorBit, Color.web("#F207C7"));

            peicesOnBoard.add(bishop);

        } else if (fenCharacter == 'k'){
            if (consoleInDepthMessages) {
                System.out.printf("king Color: <%d>%n", colorBit);
                System.out.printf("File: <%d> Rank:<%d>%n", file, rank);
            }
            setKingX(file*100);
            setKingY(rank*100);

            king = new King(pane, controlSize, getKingX(), getKingY(),
                    draggableMaker, draggableMakerGrid,
                    colorBit, Color.web("#070FF2"));

            peicesOnBoard.add(king);

        } else if(fenCharacter == 'q'){
            if (consoleInDepthMessages) {
                System.out.printf("queen Color: <%d>%n", colorBit);
                System.out.printf("File: <%d> Rank:<%d>%n", file, rank);
            }
            setQueenX(file*100);
            setQueenY(rank*100);

            queen = new Queen(pane, controlSize, getQueenX(), getQueenY(),
                    draggableMaker, draggableMakerGrid,
                    colorBit, Color.web("#F20707"));
            peicesOnBoard.add(queen);


        }

    }



    public ArrayList<Object> getPeicesOnBoard() {
        return peicesOnBoard;
    }
    public PeicesHandler(){
        System.out.println("Admin Access");

    }


    public void loadDefaulStartPosition(){
        System.out.println("\033[1;92mLOADIGN FEN DEFAULT POSTION >>>>\033[0m");
        fenConverter("rnbqkbnr/pppppppp/8/8/8/8/PPPPPPPP/RNBQKBNR w KQkq - 0 1");



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
