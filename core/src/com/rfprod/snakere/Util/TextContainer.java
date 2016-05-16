package com.rfprod.snakere.Util;


import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;

/**
 * Created by cjimene1 on 5/16/2016.
 */
public class TextContainer extends Container
{


    static final int LEFT = 0;
    static final int CENTER = 1;
    static final int RIGHT = 2;

    private final int DEFAULT_ALIGNMENT = 0;

    private int horizontaAlignment;
    private String containerText;




    public TextContainer(int startX, int startY, int width, int height)
    {
        super(startX,startY,width,height);
        this.horizontaAlignment = DEFAULT_ALIGNMENT;
        this.containerText = "";

    }

    public void setText(String text)
    {
        this.containerText = new String(text);
    }

    public void setHorizontaAlignment(int alignment)
    {
        if((alignment >= LEFT) && (alignment <= RIGHT))
        {
            this.horizontaAlignment = alignment;
        }

    }

    public void drawContent(BitmapFont font, Batch batch)
    {

        switch(horizontaAlignment)
        {
            case LEFT:

        }

    }

    private int getGlyphSpacing(BitmapFont font)
    {
        int spacingAdjustment = 0;
        for(char c: containerText.toCharArray())
        {
            spacingAdjustment += font.getData().getGlyph(c).width;
        }

        return spacingAdjustment;

    }





}
