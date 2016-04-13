package com.rfprod.snakere.Game;

import com.badlogic.gdx.math.MathUtils;

/**
 * Created by cmjim on 4/11/2016.
 */
public class Material {

    private int maxX, maxY;
    private int currentX = 0, currentY = 0;


    public Material(int maxX, int maxY)
    {
        this.maxX = maxX;
        this.maxY = maxY;
        currentX = 0;
        currentY = 0;
    }

    public void changeLocation()
    {
        this.currentX = MathUtils.random(0,maxX-1);
        this.currentY = MathUtils.random(0,maxY-1);
    }

    public int getCurrentX()
    {return this.currentX;}
    public int getCurrentY()
    {return this.currentY;}



}
