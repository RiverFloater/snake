package com.rfprod.snakere.Renderer.GameRender;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import com.rfprod.snakere.Game.World;



/**
 * Created by cjimene1 on 4/7/2016.
 */
public class MapRenderer
{


    private World world;
    private SpriteBatch batch;

    private Texture emptyTexture;
    private Texture snakeTexture;
    private Texture materialTexture;

    //debug renderer
    //private ShapeRenderer shapes;
    //-----

    public MapRenderer(World world,Renderer renderer)
    {
        emptyTexture = new Texture(Gdx.files.internal("GRASS_64.png"));
        snakeTexture = new Texture(Gdx.files.internal("SNAKE_64.png"));
        materialTexture = new Texture(Gdx.files.internal("MATERIAL_64.png"));

        this.world = world;
        this.batch = renderer.getBatch();





       // shapes = new ShapeRenderer();

    }

    public void render(float delta)
    {
        int[][] map = world.getMap();

        batch.draw(emptyTexture,0,0,world.getWorldSize_x(),world.getWorldSize_y());

        for (int y = 0;y < world.getGridY();y++)
        {
            for(int x = 0; x < world.getGridX();x++)
            {

                switch (map[y][x])
                {

                    case World.SNAKE_SPACE:
                        batch.draw(snakeTexture,x*world.getBlockSize(),y*world.getBlockSize(),world.getBlockSize(),world.getBlockSize());
                        break;
                    case World.MATERIAL_SPACE:
                        batch.draw(materialTexture,x*world.getBlockSize(),y*world.getBlockSize(),world.getBlockSize(),world.getBlockSize());
                        break;

                }

            }
        }





       //debugGrid();
    }



    public void dispose()
    {
        emptyTexture.dispose();
        snakeTexture.dispose();
        materialTexture.dispose();
    }


    /*****************************
    private void debugGrid()
    {

        shapes.setProjectionMatrix(renderer.getCamera().combined );
        shapes.begin(ShapeRenderer.ShapeType.Line);
        shapes.setColor(Color.GOLD);

    }
    ******************************/


}
