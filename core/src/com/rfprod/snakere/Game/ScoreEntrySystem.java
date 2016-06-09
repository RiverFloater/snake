package com.rfprod.snakere.Game;

/**
 * Created by cmjim on 6/5/2016.
 */
public class ScoreEntrySystem
{
    private final int TOTAL_POSITIONS = 3;
    private final int TOTAL_CHOICES = 26;
    private final int STARTING_CHAR_RANGE = 65;

    private int[] currentSelections;
    private int currentPos;

    public ScoreEntrySystem()
    {
        currentSelections = new int[TOTAL_POSITIONS];
        for(int pos = 0; pos < TOTAL_POSITIONS; pos++)
        {
            currentSelections[pos] = TOTAL_CHOICES;
        }

        currentPos = 0;

    }

    public void nextPos()
    {
        changePos(1);
    }

    public void prevPos()
    {
        changePos(-1);
    }

    public void nextChoice(){changeChoice(1);}

    public void prevChoice(){changeChoice(-1);}

    private void changeChoice(int change)
    {
        currentSelections[currentPos] += change;
        if(currentSelections[currentPos] >= TOTAL_CHOICES)
            currentSelections[currentPos] = 0;
        if(currentSelections[currentPos] <0)
            currentSelections[currentPos] = TOTAL_CHOICES;
    }

    private void changePos(int change)
    {
        currentPos += change;
        if(currentPos >= TOTAL_POSITIONS)
            currentPos = 0;
        if(currentPos < 0)
            currentPos = TOTAL_POSITIONS ;
    }

    public char[] getInitials()
    {
        char[] initials;
        initials = new char[TOTAL_POSITIONS];

        for(int pos = 0; pos< TOTAL_POSITIONS;pos++)
        {
            if(currentSelections[pos] != TOTAL_CHOICES)
            {
              initials[pos] = Character.toChars(currentSelections[pos] + STARTING_CHAR_RANGE)[0];
            }
            else
                initials[pos] = '-';

        }
        return initials;
    }

    public int getCurrentPos(){return this.currentPos;}















}
