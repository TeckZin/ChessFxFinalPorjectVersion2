package com.example.chessfxfinalporjectversion2;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.util.concurrent.RecursiveAction;
/**
 *
 * @params the foundation for all the peices method it needs to contain
 * @author Jagger
 */
public abstract class PeicesAbstract {
//List of setters and getters for position, temp position, size, name
    private Rectangle rectangle;
    private int positionX;
    private int positionY;

    private int tempX;

    private int tempY;
    private int size;
    private String name;

//    @FXML
//    public abstract void generateImage();

    public abstract int getPositionX();
    public abstract int getPositionY();

    public abstract int getControlSize();

    public abstract void setPositionX(int positionX);
    public abstract void setPositionY(int positionY);

    public abstract void setControlSize(int controlSize);

    public abstract Rectangle getRectangle();
    public abstract void setRectangle(Rectangle rectangle);

    public abstract Color getColor();

    public abstract void setColor(Color color);

    public abstract void setTempX(int x);
    public abstract  void setTempY(int y);

    public abstract int getTempX();
    public abstract  int getTempY();


}
