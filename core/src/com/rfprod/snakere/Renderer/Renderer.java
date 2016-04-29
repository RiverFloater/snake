package com.rfprod.snakere.Renderer;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.rfprod.snakere.Game.World;

/**
 * Created by cjimene1 on 4/7/2016.
 */
public class Renderer {





    private OrthographicCamera camera;
    private SpriteBatch batch;


    private World world;
    private MapRenderer map;
    private ScoreBorder scoreBorder;

    public Renderer(World world)
    {
        this.world = world;



        batch = new SpriteBatch();


        map = new MapRenderer(this.world,this);
        scoreBorder = new ScoreBorder(0,world.getWorldSize_y(),world.getWorldSize_x(),world.getBlockSize(),batch,world.getScore());


        camera = new OrthographicCamera();
        camera.setToOrtho(false,world.getWorldSize_x(),world.getWorldSize_y()+scoreBorder.getBorderHeight());





    }

    public void render(float delta)
    {



            camera.update();

            clearScreen();
            batch.setProjectionMatrix(camera.combined);

            batch.begin();
            map.render(delta);
            scoreBorder.render(delta);



            batch.end();







    }


    private void clearScreen()
    {
        Gdx.gl.glClearColor(1, 1, 1, 1);
        Gdx.gl.glClear(Gdx.gl.GL_COLOR_BUFFER_BIT);
    }

    public void dispose()
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
