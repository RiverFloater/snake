package com.rfprod.snakere.Util;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;

/**
 * Created by cjimene1 on 5/24/2016.
 */
public class TextContainer extends BaseContainer
{


    private String text;
    private BitmapFont fontType;


    public TextContainer(int originX, int originY, int sizeX, int sizeY,BitmapFont font)
    {
        super(originX, originY, sizeX, sizeY);
        this.fontType = font;
        this.text = "";
    }


    public void setText(String text)
    {
        this.text = new String(text);
    }

    public void render(Batch batch)
    {
        renderCenter(batch);
    }

    private void renderCenter(Batch batch)
    {
        fontType.draw(batch,this.text,this.getMidX()-(FontManager.getStringSize(fontType,this.text))/2,this.getOriginY());
    }










}
