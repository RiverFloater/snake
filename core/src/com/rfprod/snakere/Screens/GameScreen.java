package com.rfprod.snakere.Screens;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.rfprod.snakere.Game.World;
import com.rfprod.snakere.Input.InputManager;
import com.rfprod.snakere.Renderer.Renderer;

/**
 * Created by cjimene1 on 4/7/2016.
 */
public class GameScreen implements Screen {


    private Game game;
    private World world;
    private Renderer renderer;
    private InputManager inputManager;

    public GameScreen(Game game)
    {
        this.game = game;
        world = new World(10,10);
        renderer = new Renderer(this.world);
        inputManager = new InputManager(world);
        Gdx.input.setInputProcessor(inputManager);
    }


    @Override
    public void show() {

    }

    @Override
    public void render(float delta)
    {
        if(world.getGameState() != world.CHANGE_SCREEN) {
            inputManager.processInput();
            world.update(delta);
            renderer.render(delta);
        }
        else
        {
            game.setScreen(new SplashScreen(this.game));
        }
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
    public void dispose() {
        renderer.dispose();


    }
}
