package com.rfprod.snakere.Game;

import com.badlogic.gdx.Gdx;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;


/**
 * Created by cmjim on 5/3/2016.
 */
public class HighScores
{

    public final int MAX_HIGH_SCORES = 5;

    private final String FILE_NAME = "HighScore.txt";

    private Record[] scores;




    public HighScores()
    {

        scores = new Record[MAX_HIGH_SCORES];
        loadScores();


    }


    // will read the file and enter score data. If file does not exist it will load default scores.
    /*

    File Format:
    X,***
    X,***
    X,***

    where X denotes the score and * denotes the users initials;
    SPECIAL CASE: - will count as blank space;
     */
    private void loadScores()
    {

        if(Gdx.files.local(FILE_NAME).exists())
        {
            BufferedReader reader = new BufferedReader(Gdx.files.local(FILE_NAME).reader());
            try
            {
                String line;

                for(int count = 0; (line=reader.readLine())!= null; count++)
                {
                     String[] data = line.split(",");
                    scores[count] = new Record(Integer.parseInt(data[0]),data[1]);
                }

                reader.close();
            }
            catch(IOException e )
            {
                Gdx.app.log("IOEXCEPT", FILE_NAME+"NOT FOUND AT INTERNAL");
            }

        }
        else
        {
            for(int count = 0;count < MAX_HIGH_SCORES;count++)
            {
                this.scores[count] = new Record();
            }
        }

    }


    public boolean possibleHighScore(int score)
    {
        boolean acceptableScore = false;


        for(Record record: scores)
        {
            if(score > record.getScore())
                acceptableScore = true;
        }

        return acceptableScore;
    }



    public void addScore(int score,String initials)
    {



           if(possibleHighScore(score))
           {

                Record temp = new Record(score,initials);
                Record temp2;


                for(int count = MAX_HIGH_SCORES - 1;count != -1; count --)
                {

                    if(temp.getScore() > this.scores[count].getScore())
                    {
                        temp2 = this.scores[count];
                        this.scores[count] = temp;
                        temp = temp2;
                    }

                }


           }




       



    }


    public void saveScores()
    {
        if(Gdx.files.local(FILE_NAME).exists())
        {
            Gdx.files.local(FILE_NAME).delete();
        }

        Gdx.files.local(FILE_NAME).write(false);
        for(Record score: scores)
        {
            Gdx.files.local(FILE_NAME).writeString(score.getScore() + "," + score.getInitials() + "\n", true);
        }

    }




    public Record[] getScores(){return this.scores;}







}
