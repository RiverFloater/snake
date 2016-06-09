package com.rfprod.snakere.Renderer.GameRender.HighScoreRenderer;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.rfprod.snakere.Game.HighScores;
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
    private final int midX = screenWidth/2;
    private final int midY = screenHeight/2;

    private TextContainer[] containers;

    private TextContainer mainInputContainer;
    private TextContainer headingInputContainer;
    private TextContainer[] charInputContainers;





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

        if(screen.expectingEntry())
            createInputPoriton();








    }

    public void render(float delta)
    {
        camera.update();
        clearScreen();
        batch.setProjectionMatrix(camera.combined);

        batch.begin();


            renderBackground();
            updateTextContainers();
            renderScores();

        if(screen.expectingEntry())
        {
            renderInputPortion();
        }

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

    public void updateTextContainers()
    {
        HighScores scores = this.screen.getScores();
        for(int count = 0;count < screen.getScores().MAX_HIGH_SCORES;count++)
        {
            containers[count].setText((scores.getScores()[count].getInitials() +"          " + scores.getScores()[count].getScore()));
        }
    }


    public void renderInputPortion()
    {

        char[] initials = screen.getInitialChars();
        for(int count = 0;count < 3;count++)
        {
            charInputContainers[count].setText(Character.toString(initials[count]));
        }

        this.mainInputContainer.render(this.batch);
        this.headingInputContainer.render(this.batch);
        for(TextContainer containers: charInputContainers)
        {
            containers.render(this.batch);
        }



    }

    private void createInputPoriton()
    {
        int mainSizeX = screenWidth/3;
        int mainSizeY = screenHeight/3;

        int headingSizeX = mainSizeX/2;
        int headingSizeY = mainSizeY/3;

        this.mainInputContainer = new TextContainer(this.midX-mainSizeX/2,this.midY-mainSizeY/2,mainSizeX,mainSizeY,this.font);
        this.headingInputContainer = new TextContainer(mainInputContainer.getOriginX(),mainInputContainer.getOriginY()+mainSizeY/2,headingSizeX,headingSizeY,this.font);

        headingInputContainer.setText("Initials: ");
        this.charInputContainers = new TextContainer[3];

        for(int count = 0;count < 3;count++)
        {
            if(count == 0)
                charInputContainers[count] =new TextContainer(headingInputContainer.getOriginX()+headingInputContainer.getSizeX(),headingInputContainer.getOriginY(),headingSizeX/3,headingSizeY,this.font);
            else
            {
                charInputContainers[count] =new TextContainer(charInputContainers[count-1].getOriginX()+charInputContainers[count-1].getSizeX(),charInputContainers[count-1].getOriginY(),headingSizeX/3,headingSizeY,this.font);
            }
        }






    }




    private void clearScreen()
    {
        Gdx.gl.glClearColor(1, 1, 1, 1);
        Gdx.gl.glClear(Gdx.gl.GL_COLOR_BUFFER_BIT);
    }





}
