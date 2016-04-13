package com.rfprod.snakere;

import com.badlogic.gdx.Game;
import com.rfprod.snakere.Screens.GameScreen;

/**
 * Created by cjimene1 on 4/7/2016.
 */
public class SnakeReloadedGame extends Game
{



    @Override
    public void create()
    {
        this.setScreen(new GameScreen());


    }

}
