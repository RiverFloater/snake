package com.rfprod.snakere.Renderer.GameRender;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.rfprod.snakere.Game.Score;



/**
 * Will handle the Score display at the top of the map.
 *
 * TODO: Implement smaller font type as current font is ugly. Also grab a base border texture for stand in.
 *
 *
 */


public class ScoreBorder
{

    private SpriteBatch batch;
    private BitmapFont font;
    private Texture borderBackground;


    private int startX;
    private int startY;
    private int endX;
    private int endY;

    private int borderWidth;
    private int borderHeight;


    private Score score;



    public ScoreBorder(int startX, int startY, int borderWidth, int borderHeight, SpriteBatch batch, Score score)
    {
        this.batch = batch;

        this.font = new BitmapFont();
        font.getData().setScale(.5f,.5f);


        this.startX = startX;
        this.startY = startY;
        this.borderWidth = borderWidth;
        this.borderHeight = borderHeight;
        this.endX = startX + borderWidth;
        this.endY = startY + borderHeight;

        this.score = score;



        this.font.setColor(Color.BLACK);




    }


    public void render(float delta)
    {

        font.draw(batch,"Score: " + score.getScore() ,endX/2,endY);

    }

    public int getBorderWidth()
    {return this.borderWidth;}

    public int getBorderHeight()
    {
        return this.borderHeight;
    }
    public void dispose()
    {
        this.font.dispose();
        this.borderBackground.dispose();
        this.batch.dispose();
    }





}
