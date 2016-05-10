package com.rfprod.snakere.Game;

/**
 * Hold the score and initials of a user's high score;
 */
public class Record
{

    private final int MAX_INITIALS = 3;
    private final int DEFUALT_SCRORE = 0;
    private final String DEFUALT_INITIALS = "---";

    private int score;
    private String initials;

    public Record(int score,String initials)
    {
        this.score = score;
        if(initials.length()>MAX_INITIALS) {
            this.initials = initials.substring(0, MAX_INITIALS - 1);

        }
        else
        {
            this.initials = initials;
        }


    }

    public Record()
    {

        this.score = DEFUALT_SCRORE;
        this.initials = DEFUALT_INITIALS;
    }


    public int getScore()
    {
        return this.score;
    }

    public String getInitials()
    {
        return this.initials;
    }





}
