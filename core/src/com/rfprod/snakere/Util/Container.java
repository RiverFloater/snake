package com.rfprod.snakere.Util;



/**
 * Container will serve as a container. In the case of Snake Reloaded it can be used to display text at set locations and hold multiple items.
 * Cant have a background.
 * Will essentially be a UI element.
 *
 */
abstract class Container
{



    protected int width;
    protected int height;

    protected int locX;
    protected int locY;

    protected int endX;
    protected int endY;



    public Container()
    {

        this.locX = 0;
        this.locY = 0;

        this.width = 0;
        this.height = 0;

        this.endX = 0;
        this.endY = 0;

    }


    public Container(int startX,int startY,int width,int height)
    {

        this.locX = startX;
        this.locY = startY;

        this.width = width;
        this.height = height;

        this.endX = startX + width;
        this.endY = startY + height;

    }



    /*****
        Returns
     *****/
    public int getStartX()
    {return this.locX;}

    public int getStartY()
    {return this.locY;}

    public int getWidth()
    {return this.width;}

    public int getHeight()
    {return this.height;}















}
