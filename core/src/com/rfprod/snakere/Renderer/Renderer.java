package com.rfprod.snakere.Renderer;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.rfprod.snakere.Game.World;

/**
 * Created by cjimene1 on 4/7/2016.
 */
public class Renderer {


    private final float  TIME_STEP = 30f;
    private float deltaPassed = 0f;


    private OrthographicCamera camera;
    private SpriteBatch batch;

    private World world;
    private MapRenderer map;

    public Renderer(World world)
    {
        this.world = world;

        Gdx.graphics.getHeight();


        camera = new OrthographicCamera();
        camera.setToOrtho(false,world.getWorldSize_x(),world.getWorldSize_y());



        batch = new SpriteBatch();
        
        map = new MapRenderer(this.world,this);

    }

    public void render(float delta)
    {

        deltaPassed += delta;


            camera.update();

            clearScreen();
            batch.setProjectionMatrix(camera.combined);

            batch.begin();

            map.render(delta);


            batch.end();





    }


    private void clearScreen()
    {
        Gdx.gl.glClearColor(1, 1, 1, 1);
        Gdx.gl.glClear(Gdx.gl.GL_COLOR_BUFFER_BIT);
    }

    private void dispose()
    {
        batch.dispose();
    }

    public SpriteBatch getBatch()
    {
        return this.batch;
    }

    public OrthographicCamera getCamera()
    {
        return this.camera;
    }

}
