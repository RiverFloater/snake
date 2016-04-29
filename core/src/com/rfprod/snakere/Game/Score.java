package com.rfprod.snakere.Game;

/**
 * Created by cmjim on 4/27/2016.
 * Will keep track of the score in the game.
 * Score will be based on the number of materials eaten.
 */
public class Score
{

    private final int MULTIPLIER_BASE = 1;
    private final int MULTIPLIER_SECOND = 2;
    private final int MULTIPLIER_FINAL = 3;

    private int currentScore;
    private int materialsEaten;
    private int currentMultiplier;


    public Score()
    {
        this.currentScore = 0;
        this.materialsEaten = 0;
        this.currentMultiplier = 1;
    }

    public int getScore()
    {
        return this.currentScore;
    }

    public void increaseScore()
    {
        materialsEaten += 1;
        currentScore += 1*currentMultiplier;
        adjustMultiplier();
    }

    private void adjustMultiplier()
    {

        if(materialsEaten > 9)
        {
            this.currentMultiplier = MULTIPLIER_FINAL;
        }
       else if(materialsEaten > 4)
        {
           this.currentMultiplier= MULTIPLIER_SECOND;
        }
        else
            this.currentMultiplier = MULTIPLIER_BASE;




    }







}
