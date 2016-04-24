package com.rfprod.snakere.Game;

/**
 * Snake will be composed of different body segments. each segment will have its own location.
 * depending on if it is the head or not it will move to the next position.
 */
public class BodySegment
{
    private int x;
    private int y;

   public BodySegment(int x, int y)
    {
        this.x = x;
        this.y = y;
    }

    public int getX()
    {
        return this.x;
    }

    public int getY()
    {
        return this.y;
    }

    public void move(int x,int y)
    {
        this.x = x;
        this.y = y;
    }







}
