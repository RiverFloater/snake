package com.rfprod.snakere.Game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.MathUtils;
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
        snake = new Snake(this.gridX/2-1,this.gridY/2-1);
        this.map[snake.getHead().getY()][snake.getHead().getX()] = SNAKE_SPACE;

        material = new Material(gridX,gridY);
        while(checkMaterialCollision())
        {
            material.changeLocation();
        }
        this.map[material.getCurrentY()][material.getCurrentX()] = MATERIAL_SPACE;



    }


    public void update(float delta)
    {



            if (TimeUtils.nanoTime() - timeLastUpdate > 100000000) {

                snake.move();
                updateMap();
                timeLastUpdate = TimeUtils.nanoTime();
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


        if(!gameOver()) {

            if (checkMaterialCollision()) {

                createNewSegment();
                material.changeLocation();
                while (checkMaterialCollision()) {
                    material.changeLocation();
                }
            }


            for (int y = 0; y < gridY; y++) {
                for (int x = 0; x < gridY; x++) {
                    map[y][x] = EMPTY_SPACE;
                }
            }


            Iterator<BodySegment> it = snake.bodySegmentIterator();
            BodySegment currentSegment;
            while (it.hasNext()) {
                currentSegment = it.next();
                map[currentSegment.getY()][currentSegment.getX()] = SNAKE_SPACE;
            }

            map[material.getCurrentY()][material.getCurrentX()] = MATERIAL_SPACE;


        }

    }



    private void createNewSegment()
    {
        Iterator<BodySegment> it = snake.bodySegmentIterator();
        BodySegment prevSegment = null;
        BodySegment currentSegment = null;

        int xDifference;
        int yDifference;

        while(it.hasNext())
        {
            currentSegment = it.next();
            if(it.hasNext())
            {
                prevSegment = currentSegment;
            }

        }

        if(prevSegment == null)
        {
           switch(snake.getCurrentDirection())
           {
               case Snake.NORTH:
                   snake.addBodySegment(snake.getHead().getX(),snake.getHead().getY()-1);
                   break;
               case Snake.SOUTH:
                   snake.addBodySegment(snake.getHead().getX(),snake.getHead().getY()+1);
                   break;
               case Snake.WEST:
                   snake.addBodySegment(snake.getHead().getX()+1,snake.getHead().getY());
                   break;
               case Snake.EAST:
                   snake.addBodySegment(snake.getHead().getX()-1,snake.getHead().getY());
                   break;


           }
        }
        else
        {
            xDifference = prevSegment.getX() - currentSegment.getX();
            yDifference = prevSegment.getY() - currentSegment.getY();

            if(((currentSegment.getX() + xDifference < 0 )|| (currentSegment.getX() + xDifference >= gridX))||((currentSegment.getY() + yDifference < 0)||(currentSegment.getY() + yDifference >= gridY)))
            {
                //look for an empty space to put new segment


            }
            else
            {
                snake.addBodySegment(currentSegment.getX()+xDifference,currentSegment.getY() + yDifference);
            }
        }




    }



    private boolean gameOver()
    {
        if(collisionSnake()|| collisionWall())
            return true;
        else
        return false;





    }

    private boolean collisionWall()
    {

        BodySegment head = snake.getHead();

        if(((head.getX() >= gridX || head.getX() < 0))||((head.getY()>=gridY || head.getY() < 0)))
        {
            return true;
        }
        else
            return false;
    }

    private boolean collisionSnake()
    {
        


    }


    private boolean checkMaterialCollision()
    {
        Iterator<BodySegment> iterator = snake.bodySegmentIterator();
        BodySegment currentSegment;
        boolean collisionFound = false;
        int x;
        int y;

        while (iterator.hasNext())
        {
            currentSegment = iterator.next();
            x =  currentSegment.getX();
            y =  currentSegment.getY();

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
