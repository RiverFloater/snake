package com.rfprod.snakere.Game;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.TimeUtils;


import java.sql.Time;
import java.util.Iterator;


/**
 * Author: Carlos Jimenez
 * Revised: 4.7.16
 *
 * Purpose: The main world for the snake game. will hold the map and snake.
 * Game logic will take place here.
 *
 */

/*
    TODO Game runs very fast. Slow update so snake only moves every 30 frames? Maybe every second?
 */
public class World {



    public static final int EMPTY_SPACE = 0;
    public static final int SNAKE_SPACE = 1;
    public static final int MATERIAL_SPACE = 2;

    private final int BLOCK_SIZE = 10;

    private int[][] map;
    private int worldSize_x;
    private int worldSize_y;
    private int gridX, gridY;

    private Snake snake;
    private Material material;

    private boolean snakeCrashed = false;


    private long timeLastUpdate = 0;




    public World(int sizeX, int sizeY) {
        map = new int[sizeY][sizeX];
        gridX = sizeX;
        gridY = sizeY;
        worldSize_x = sizeX * BLOCK_SIZE;
        worldSize_y = sizeY * BLOCK_SIZE;

        initializeNewWorld();

    }

    private void initializeNewWorld() {
        for (int y = 0; y < gridY; y++) {
            for (int x = 0; x < gridX; x++)
            {
                map[y][x] = EMPTY_SPACE;
              }
        }

        //spawn snake in middle of the map and add snake to map grid
        snake = new Snake(new Vector2(this.gridX/2-1,this.gridY/2-1));
        this.map[(int)snake.getHead().x][(int)snake.getHead().y] = SNAKE_SPACE;

        material = new Material(gridX,gridY);
        while(checkMaterialCollision())
        {
            material.changeLocation();
        }
        this.map[material.getCurrentY()][material.getCurrentX()] = MATERIAL_SPACE;



    }


    public void update(float delta)
    {


        if(!snakeCrashed)
        {
            if (TimeUtils.nanoTime() - timeLastUpdate > 1000000000) {

                snake.move();
                updateMap();
                timeLastUpdate = TimeUtils.nanoTime();
            }
        }

    }


    public int getWorldSize_x(){return this.worldSize_x;}
    public int getWorldSize_y(){return this.worldSize_y;}
    public int getBlockSize(){return this.BLOCK_SIZE;}
    public int getGridX(){return this.gridX;}
    public int getGridY(){return this.gridY;}
    public Snake getSnake(){return this.snake;}

    public int[][] getMap()
    {
        return this.map;
    }

    private void updateMap()
    {


        if(((snake.getHead().x > gridX )||(snake.getHead().x < 0))||((snake.getHead().y > gridY)||(snake.getHead().y <0)))
        {
            snakeCrashed = false;
        }
        else
        {
            if(checkMaterialCollision())
            {
                snake.addBodySegment(gridX,gridY);
                material.changeLocation();
                while(checkMaterialCollision())
                {
                    material.changeLocation();
                }
            }

            //create mapbase
            for(int y = 0; y< gridY;y++)
            {
                for(int x = 0;x <gridX;x++)
                {
                    this.map[y][x] = EMPTY_SPACE;
                }
            }

            //add snake to map
            Iterator<Vector2> iterator =  snake.getSnakeBody().descendingIterator();
            while (iterator.hasNext()  )
            {
                Vector2 currentSegment = iterator.next();
                this.map[(int)currentSegment.y][(int)currentSegment.x] = SNAKE_SPACE;
            }



            map[material.getCurrentY()][material.getCurrentX()] = MATERIAL_SPACE;



        }










    }







    private boolean checkMaterialCollision()
    {
        Iterator<Vector2> iterator = snake.getSnakeBody().descendingIterator();
        Vector2 currentVector;
        boolean collisionFound = false;
        int x;
        int y;

        while (iterator.hasNext())
        {
            currentVector = iterator.next();
            x = (int)currentVector.x;
            y = (int) currentVector.y;

            if(x == material.getCurrentX())
            {
                if (y == material.getCurrentY())
                {
                    collisionFound = true;
                }
            }

            if(collisionFound == true)
                break;
        }

      return collisionFound;
    }













}
