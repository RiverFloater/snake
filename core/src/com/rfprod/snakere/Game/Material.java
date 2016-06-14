package com.rfprod.snakere.Game;

import com.badlogic.gdx.math.MathUtils;

/**
 * * Author: Carlos Jimenez
 * Revised: 6.14.16
 *
 * Purpose: MAterial for the snake to eat. Will randomly move around a range of inputs defined on object creation.
 *
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
