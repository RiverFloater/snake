package com.rfprod.snakere.Util;

/**
 * Author: Carlos Jimenez
 * Revised: 6.14.16
 *
 * Purpose: Base Container for snake. Will be used to easier place objects on the screen in an confined area.
 */
public abstract class  BaseContainer {

    private int originX;
    private int originY;

    private int sizeX;
    private int sizeY;

    private int midX;
    private int midY;

    private int endX;
    private int endY;





    public BaseContainer(int originX,int originY,int sizeX,int sizeY)
    {
        this.originX = originX;
        this.originY = originY;
        this.sizeX = sizeX;
        this.sizeY = sizeY;


        calculateEnds();
        calculateMidPoints();


    }







    /*
       **************** GETTERS/SETTERS ******************
     */
    public void moveOrigion(int x, int y)
    {
        this.originX = x;
        this.originY = y;
        calculateEnds();
        calculateMidPoints();
    }

    public void changeSizeX(int x)
    {
        this.sizeX = x;
        calculateEnds();
        calculateMidPoints();
    }

    public void changeSizeY(int y)
    {
        this.sizeY = y;
        calculateEnds();
        calculateMidPoints();
    }

    public int getOriginX(){return this.originX;}
    public int getOriginY(){return this.originY;}
    public int getSizeX(){return this.sizeX;}
    public int getSizeY(){return this.sizeY;}
    public int getMidX(){return this.midX;}
    public int getMidY(){return this.midY;}


    private void calculateMidPoints()
    {
        this.midX = sizeX/2 + originX;
        this.midY = sizeY/2 + originY;
    }

    private void calculateEnds()
    {
        this.endX = originX + sizeX;
        this.endY = originY + sizeY;
    }



}
