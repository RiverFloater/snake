package com.rfprod.snakere.Screens;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.rfprod.snakere.Game.HighScores;




/**
 * Created by cmjim on 4/29/2016.
 */
public class SplashScreen implements Screen
{
    private final String GAME_NAME = "SNAKE RELOADED";
    private final String NEW_GAME = "PLAY";
    private final String HIGH_SCORES = "HIGH SCORES";

    private Game game;


    private Texture background;
    private SpriteBatch batch;
    private BitmapFont font;
    private OrthographicCamera camera;

    private final int screenWidth = 480;
    private final int screenHeight =320;

    private String currentSelectable;




    public SplashScreen(Game game)
    {
        this.game = game;

        camera = new OrthographicCamera(screenWidth,screenHeight);
        camera.position.set(screenWidth / 2, screenHeight / 2, 0);
        camera.update();

        background = new Texture(Gdx.files.internal("SplashBackground.png"));
        batch = new SpriteBatch();
        font = new BitmapFont();

        currentSelectable = NEW_GAME;







    }


    @Override
    public void show()
    {



    }

    @Override
    public void render(float delta)
    {


        handleInput();
       renderScreen();





    }




    private void drawText()
    {
        int glyphWidth;
        glyphWidth = getTextWidth(GAME_NAME);
        font.setColor(Color.BLACK);
        font.draw(batch, GAME_NAME, screenWidth / 2 - glyphWidth / 2, screenHeight * .5f);


        if(currentSelectable == NEW_GAME)
        {

            font.setColor(Color.WHITE);
            glyphWidth = getTextWidth(NEW_GAME);
            font.draw(batch, NEW_GAME, screenWidth / 2 - glyphWidth / 2, screenHeight / 3);

        }
        else
        {
            font.setColor(Color.BLACK);
            glyphWidth = getTextWidth(NEW_GAME);
            font.draw(batch, NEW_GAME, screenWidth / 2 - glyphWidth / 2, screenHeight / 3);
        }



        if(currentSelectable == HIGH_SCORES)
        {

            font.setColor(Color.WHITE);
            glyphWidth = getTextWidth(HIGH_SCORES);
            font.draw(batch, HIGH_SCORES, screenWidth / 2 - glyphWidth / 2, screenHeight / 4);
        }
        else
        {
            font.setColor(Color.BLACK);
            glyphWidth = getTextWidth(HIGH_SCORES);
            font.draw(batch, HIGH_SCORES, screenWidth / 2 - glyphWidth / 2, screenHeight / 4);
        }






    }




    @Override
    public void resize(int width, int height)
    {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose()
    {
            this.background.dispose();

    }


    private void handleInput()
    {

        if (Gdx.input.isKeyPressed(Input.Keys.W)||Gdx.input.isKeyJustPressed(Input.Keys.UP)||Gdx.input.isKeyJustPressed(Input.Keys.NUMPAD_8))
        {
            if(currentSelectable == NEW_GAME)
                currentSelectable = HIGH_SCORES;
            else
                currentSelectable = NEW_GAME;
        }
        if (Gdx.input.isKeyPressed(Input.Keys.S)||Gdx.input.isKeyJustPressed(Input.Keys.DOWN)||Gdx.input.isKeyJustPressed(Input.Keys.NUMPAD_5))
        {
            if(currentSelectable == NEW_GAME)
                currentSelectable = HIGH_SCORES;
            else
                currentSelectable = NEW_GAME;
        }
       if(Gdx.input.isKeyPressed(Input.Keys.SPACE))
       {
            if(currentSelectable == NEW_GAME)
                this.game.setScreen(new GameScreen(game));
          // else
              //  this.game.setScreen(new HighScoreScreen);

       }
    }

    private void drawBackground()
    {
        batch.draw(background, 0, 0,camera.viewportWidth,camera.viewportHeight);
    }


    private void clearScreen()
    {
        Gdx.gl.glClearColor(1, 1, 1, 1);
        Gdx.gl.glClear(Gdx.gl.GL_COLOR_BUFFER_BIT);
    }

    private void renderScreen()
    {
        clearScreen();
        batch.setProjectionMatrix(camera.combined);
        batch.begin();
        drawBackground();
        drawText();
        batch.end();
    }

    private int getTextWidth(String string)
    {
        int length = string.length();
        char currentChar;
        int glyphWidth = 0;
        for(int x = 0; x < length;x++)
        {
            currentChar = string.charAt(x);
            glyphWidth += font.getData().getGlyph(currentChar).width;
        }
        return glyphWidth;
    }
}
