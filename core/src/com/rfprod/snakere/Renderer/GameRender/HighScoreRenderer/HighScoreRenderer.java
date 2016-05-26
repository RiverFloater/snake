package com.rfprod.snakere.Renderer.GameRender.HighScoreRenderer;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.rfprod.snakere.Game.HighScores;
import com.rfprod.snakere.Game.Record;
import com.rfprod.snakere.Game.Score;
import com.rfprod.snakere.Screens.HighScoreScreen;
import com.rfprod.snakere.Util.FontManager;
import com.rfprod.snakere.Util.TextContainer;


/**
 * TODO: CREATE CUSTOM FONTS USING FREETYPE. Will be its own class
 */
public class HighScoreRenderer
{

    private HighScoreScreen screen;
    private Texture background;
    private SpriteBatch batch;
    private FontManager fontManager;
    private BitmapFont font;



    private OrthographicCamera camera;

    private final int screenWidth = 480;
    private final int screenHeight = 320;

    private TextContainer[] containers;


    /*
    Will use a container to display Scores
    container will be divided into 5 sections
      EX:
         SCORE INITIAL
      1)   X    CMJ
      2)   X    DJT
      3)   X    DFJ
      4)   X    DJF
      5)   X    DKF
     */






    public HighScoreRenderer(HighScoreScreen screen)
    {

        this.screen = screen;
        background = new Texture(Gdx.files.internal("SplashBackground.png"));

        batch = new SpriteBatch();
        fontManager = new FontManager();
        font = fontManager.getFont(20);



        camera = new OrthographicCamera(screenWidth, screenHeight);
        camera.position.set(screenWidth / 2, screenHeight / 2, 0);
        camera.update();

        createTextContainers();








    }

    public void render(float delta)
    {
        camera.update();
        clearScreen();
        batch.setProjectionMatrix(camera.combined);

        batch.begin();
        renderBackground();
        renderScores();

        batch.end();


    }



    private void renderBackground()
    {
        batch.draw(background, 0, 0, screenWidth, screenHeight);
    }

    private void renderScores()
    {

        for(TextContainer container: containers)
        {
            container.render(this.batch);
        }


    }




    //create a group on containers in the center of the screen to display the scores
    //5 containers at the time.. can change
    private void createTextContainers()
    {

        int totalWidth = screenWidth/2;
        int totalHeight = screenHeight/2;
        int startX = 0 + totalWidth/2;
        int startY = 0 + totalHeight/2;

        int containerHeight = totalHeight/screen.getScores().MAX_HIGH_SCORES;

        containers = new TextContainer[screen.getScores().MAX_HIGH_SCORES];
        HighScores scores = this.screen.getScores();
        for(int count = 0;count < screen.getScores().MAX_HIGH_SCORES;count++)
        {
            containers[count] = new TextContainer(startX,startY +(containerHeight*count),totalWidth,containerHeight,this.font);
            containers[count].setText((scores.getScores()[count].getInitials() +"          " + scores.getScores()[count].getScore()));
        }







    }


    private void clearScreen()
    {
        Gdx.gl.glClearColor(1, 1, 1, 1);
        Gdx.gl.glClear(Gdx.gl.GL_COLOR_BUFFER_BIT);
    }





}
