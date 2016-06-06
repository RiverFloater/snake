package com.rfprod.snakere.Screens;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Screen;
import com.rfprod.snakere.Game.HighScores;
import com.rfprod.snakere.Renderer.GameRender.HighScoreRenderer.HighScoreRenderer;

/**
 * Created by cmjim on 5/9/2016.
 */
public class HighScoreScreen implements Screen
{

    private Game game;
    private HighScores scores;

    private HighScoreRenderer renderer;

    private boolean entryAllowed = false;






    public HighScoreScreen(Game game,int score)
    {
        this.game = game;
        scores = new HighScores();
        renderer = new HighScoreRenderer(this);

        if(scores.possibleHighScore(score))
            entryAllowed = true;

    }

    public HighScoreScreen(Game game)
    {
        this.game = game;
        scores = new HighScores();
        renderer = new HighScoreRenderer(this);

    }




    @Override
    public void show() {

    }

    @Override
    public void render(float delta)
    {

        if(this.entryAllowed)
        {

        }
        renderer.render(delta);

    }

    @Override
    public void resize(int width, int height) {

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

    }

    public HighScores getScores()
    {return this.scores;}


    public boolean expectingEntry(){return this.entryAllowed;}

    //will update if expecting input
    private void update()
    {



    }

    private void processInput()
    {



    }





}
