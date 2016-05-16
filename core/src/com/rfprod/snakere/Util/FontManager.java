package com.rfprod.snakere.Util;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;

/**
 *
 */
public class FontManager
{

    FreeTypeFontGenerator generator;
    FreeTypeFontGenerator.FreeTypeFontParameter parameter;

    public FontManager()
    {
        generator = new FreeTypeFontGenerator(Gdx.files.internal("FantasqueSansMono-Regular.tff"));
        parameter = new FreeTypeFontGenerator.FreeTypeFontParameter();
    }

    public BitmapFont getFont(int pixelSize)
    {
        parameter.size = pixelSize;

        return generator.generateFont(parameter);

    }

    public void dispose()
    {
        generator.dispose();
    }



}
