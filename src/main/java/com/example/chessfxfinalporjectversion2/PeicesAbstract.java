package com.example.chessfxfinalporjectversion2;

public abstract class PeicesAbstract {
    private int positionX;
    private int positionY;

    private int size;
    private String name;


    public abstract int getPositionX();

    public abstract int getPositionY();

    public abstract int getSize();

    public abstract void setPositionX(int positionX);
    public abstract void setPositionY(int positionY);

    public abstract void setSize(int size);

    public abstract String getName();

    public abstract void setName(String name);


}
