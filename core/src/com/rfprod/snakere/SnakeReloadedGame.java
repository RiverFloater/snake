package com.rfprod.snakere;

import com.badlogic.gdx.Game;


import com.rfprod.snakere.Screens.HighScoreScreen;
import com.rfprod.snakere.Screens.SplashScreen;





/**
 * Created by cjimene1 on 4/7/2016.
 */
public class SnakeReloadedGame extends Game {






    @Override
    public void create()
    {


        this.setScreen(new SplashScreen(this));


    }







}
