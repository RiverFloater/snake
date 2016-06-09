package com.rfprod.snakere.Screens;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.rfprod.snakere.Game.HighScores;
import com.rfprod.snakere.Game.ScoreEntrySystem;
import com.rfprod.snakere.Renderer.GameRender.HighScoreRenderer.HighScoreRenderer;

/**
 * Created by cmjim on 5/9/2016.
 */
public class HighScoreScreen implements Screen
{

    private Game game;
    private HighScores scores;

    private HighScoreRenderer renderer;
    private ScoreEntrySystem entrySystem;

    private boolean entryAllowed = false;
    private int currentScore;







    public HighScoreScreen(Game game,int score)
    {
        this.game = game;
        scores = new HighScores();


        if(scores.possibleHighScore(score)) {
            entryAllowed = true;
            entrySystem = new ScoreEntrySystem();
            this.currentScore = score;
        }

        renderer = new HighScoreRenderer(this);


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

        processInput();
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


    private void submitScore()
    {

        scores.addScore(currentScore,stringFromEntrySystem());
        entryAllowed = false;

    }

    private String stringFromEntrySystem()
    {
        char[] initials = entrySystem.getInitials();

        String temp = (Character.toString(initials[0])+Character.toString(initials[1])+Character.toString(initials[2]));
        return temp;

    }

    public char[] getInitialChars(){return this.entrySystem.getInitials();}


    private void processInput()
    {

        if(Gdx.input.isKeyJustPressed(Input.Keys.A))
        {
            if(entryAllowed)
            entrySystem.prevPos();
        }
        if(Gdx.input.isKeyJustPressed(Input.Keys.D))
        {
            if(entryAllowed)
            entrySystem.nextPos();
        }
        if(Gdx.input.isKeyJustPressed(Input.Keys.W))
        {
            if(entryAllowed)
            entrySystem.nextChoice();
        }
        if(Gdx.input.isKeyJustPressed(Input.Keys.S))
        {
            if(entryAllowed)
            entrySystem.prevChoice();
        }
        if(Gdx.input.isKeyJustPressed(Input.Keys.SPACE))
        {
            if(entryAllowed)
            submitScore();
            scores.saveScores();
            this.game.setScreen(new SplashScreen(this.game));

        }



    }







}
