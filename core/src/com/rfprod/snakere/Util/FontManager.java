package com.rfprod.snakere.Util;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;

/**
 Author: Carlos Jimenez
 * Revised: 6.14.16
 *
 * Purpose: Allows to return custom fonts using FreeTypeFont.. Also provides a static method to get the displacement of a string's total glyph size
 */
public class FontManager {

    FreeTypeFontGenerator generator;
    FreeTypeFontGenerator.FreeTypeFontParameter parameter;

    public FontManager() {
        generator = new FreeTypeFontGenerator(Gdx.files.internal("FantasqueSansMono-Regular.ttf"));
        parameter = new FreeTypeFontGenerator.FreeTypeFontParameter();
    }

    public BitmapFont getFont(int pixelSize) {
        parameter.size = pixelSize;

        return generator.generateFont(parameter);

    }

    public void dispose() {
        generator.dispose();
    }

    //gets the size of string in relation to the font that is currently being used;
    public static int getStringSize(BitmapFont font, String string)
    {
        int displacement = 0;

        for(char c: string.toCharArray())
        {
            displacement += font.getData().getGlyph(c).width;
        }

        return displacement;
    }




}
