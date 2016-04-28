package com.rfprod.snakere.Renderer;

import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 * Created by cmjim on 4/27/2016.
 */
public class ScoreBorder
{
    private int borderSizeX;
    private int borderSizeY;

    private int x;
    private int y;

    private BitmapFont bitmapFont;

    public ScoreBorder(int x, int y,int borderSizeX,int borderSizeY,BitmapFont bitmapFont,SpriteBatch batch)
    {
        this.x = x;
        this.y = y;
        this.borderSizeX = borderSizeX;
        this.borderSizeY = borderSizeY;
        this.bitmapFont = bitmapFont;

    }

    public void renderScore(int score)
    {


    }

    public int getBorderSizeX()
    {return this.borderSizeX;}

    public int getBorderSizeY()
    {return this.borderSizeY;}

    private void centerText(String string, int size)
    {
        int length = string.length();
        int x = borderSizeX/2 - length/2;
        int y = borderSizeY/2;

    }




}
