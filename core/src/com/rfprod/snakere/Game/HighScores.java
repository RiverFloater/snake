package com.rfprod.snakere.Game;


import com.sun.xml.internal.ws.api.server.EndpointReferenceExtensionContributor;

/**
 * Will hold the 5 highest scores in the game.
 */
public class HighScores {


    private final int SCORES_KEPT = 5;

    private class Record
    {

        public Record()
        {
            int score = 0;
            String initials = null;
        }

    }

   private Record[] records;

    public HighScores()
    {
        records = new Record[SCORES_KEPT];




    }










}
