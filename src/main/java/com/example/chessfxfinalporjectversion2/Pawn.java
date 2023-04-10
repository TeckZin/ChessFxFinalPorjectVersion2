package com.example.chessfxfinalporjectversion2;


import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;

public class Pawn extends PeicesAbstract {




    private Rectangle rectangle;
    private int positionX;
    private int positionY;

    private int tempX;
    private int tempY;

    private int controlSize;
    private String name = "Pawn";

    private Color color;

    private String type;
    private String colorType;

    private String path;
    private int colorBit;






    public Pawn(AnchorPane pane, int controlSize, int positionX, int positionY, DraggableMaker draggableMaker, DraggableMakerGrid draggableMakerGrid,int colorBit, Color color){



        setTempX(positionX);
        setTempY(positionY);
        setPositionX(positionX);
        setPositionY(positionY);
        setControlSize(controlSize);
        setColor(color);
        this.colorBit = colorBit;



        if (colorBit == 1){
            colorType = "White";

        } else {
            colorType = "Black";
        }


        this.type = "PawnPNG";





        PeicesComponents peicesComponents = new PeicesComponents(controlSize, positionX, positionY);
        this.rectangle = peicesComponents.getRectangle();


//        peicesComponents.setImage(colorType, type);

        Image img = new Image(peicesComponents.getPath() + colorType + type + ".png");
        this.rectangle.setFill(new ImagePattern(img));

        draggableMakerGrid.makeDraggable(peicesComponents);
        draggableMaker.makeDraggable(rectangle);


        pane.getChildren().add(rectangle);





    }

    public Pawn(){}



//    @FXML
//    public void generatedImage(){
//        Image img = new Image("");
//        rectangle.setFill(new ImagePattern(img));
//    }


    @Override
    public int getPositionX() {
        return positionX;
    }

    @Override
    public int getPositionY() {
        return positionY;
    }

    @Override
    public int getControlSize() {
        return controlSize;
    }

    @Override
    public void setPositionX(int positionX) {
        this.positionX = positionX;

    }

    @Override
    public void setPositionY(int positionY) {
        this.positionY = positionY;

    }

    @Override
    public void setControlSize(int controlSize) {
        this.controlSize = controlSize;

    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public Rectangle getRectangle() {

        return rectangle;
    }

    @Override
    public void setRectangle(Rectangle rectangle) {
        this.rectangle = rectangle;
    }

    @Override
    public Color getColor() {
        return color;
    }

    @Override
    public void setColor(Color color) {
        this.color = color;

    }

    @Override
    public void setTempX(int x) {
        this.tempX = x;

    }

    @Override
    public void setTempY(int y) {
        this.tempY = y;
    }

    @Override
    public int getTempX() {
        return tempX;
    }

    @Override
    public int getTempY() {
        return tempY;
    }


}
