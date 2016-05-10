package com.rfprod.snakere.Renderer.GameRender.HighScoreRenderer;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.rfprod.snakere.Screens.HighScoreScreen;


/**
 * Created by cmjim on 5/9/2016.
 */
public class HighScoreRenderer
{

    private HighScoreScreen screen;
    private Texture background;
    private SpriteBatch batch;


    private BitmapFont font;
    private OrthographicCamera camera;

    private final int screenWidth = 480;
    private final int screenHeight = 320;


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

    private int containerSizeWidth;
    private int containerSizeHeight;

    private int scoreHeightMaxSize;
    private int containerX;
    private int containerY;
    private int[] divisionsX;
    private int[] divisionsY;




    public HighScoreRenderer(HighScoreScreen screen)
    {

        this.screen = screen;
        background = new Texture(Gdx.files.internal("SplashBackground.png"));

        batch = new SpriteBatch();



        camera = new OrthographicCamera(screenWidth, screenHeight);
        camera.position.set(screenWidth / 2, screenHeight / 2, 0);
        camera.update();

        createContainer();




    }

    public void render(float delta)
    {
        camera.update();
        clearScreen();
        batch.setProjectionMatrix(camera.combined);

        batch.begin();
        renderBackground();


        batch.end();


    }



    private void renderBackground()
    {
        batch.draw(background, 0, 0, screenWidth, screenHeight);
    }



    private void createContainer()
    {
        containerSizeWidth = screenWidth/2;
        containerSizeHeight = screenHeight/2;
        scoreHeightMaxSize = containerSizeHeight/(this.screen.getScores().MAX_HIGH_SCORES);
        containerX = (screenWidth - containerSizeWidth -(containerSizeWidth/2) );
        containerY = (screenHeight - containerSizeHeight - (containerSizeHeight/2));



        createDivisions(screen.getScores().MAX_HIGH_SCORES);


    }

    private void createDivisions(int numOfDivisions)
    {
        divisionsX = new int[numOfDivisions];
        divisionsY = new int[numOfDivisions];

        for(int loc = 0; loc < numOfDivisions;loc++)
        {
            divisionsX[loc] = containerX;
            divisionsY[loc] = containerY + (scoreHeightMaxSize*loc);
        }
    }




    private void clearScreen()
    {
        Gdx.gl.glClearColor(1, 1, 1, 1);
        Gdx.gl.glClear(Gdx.gl.GL_COLOR_BUFFER_BIT);
    }





}
