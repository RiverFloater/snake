package com.rfprod.snakere.Game;

import com.badlogic.gdx.math.Vector2;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * Player.
 * Snake like avatar. will begin as a single link? (the head) as the snake collects materials he will be come longer.
 * Snake will collide with its self and the wall.
 *
 * Use a linked list of vector2? Can follow through for position. Will never have to remove as object will only grown in length.
 *
 */
public class Snake {


    public static final int NOT_SET = 0;
    public static final int NORTH = 1;
    public static final int EAST = 2;
    public static final int SOUTH = 3;
    public static final int WEST = 4;

    private LinkedList<Vector2> snakeBody;
    private int lastDirection;
    private int currentDirection;
    private int speed;


    public Snake(Vector2 startingPos) {
        this.snakeBody = new LinkedList<Vector2>();
        this.snakeBody.add(startingPos);
        this.currentDirection = NOT_SET;
        this.lastDirection = NOT_SET;
        this.speed = 1;



    }


    public Vector2 getHead()
    {
        return this.snakeBody.getFirst();
    }

    public void addBodySegment(int boundsX, int boundsY)
    {
        if(snakeBody.size() == 1) {
            switch (currentDirection) {
                case NORTH:
                    snakeBody.add(new Vector2(snakeBody.getFirst().x, snakeBody.getFirst().y - 1));
                    break;
                case SOUTH:
                    snakeBody.add(new Vector2(snakeBody.getFirst().x, snakeBody.getFirst().y +1 ));
                    break;
                case WEST:
                    snakeBody.add(new Vector2(snakeBody.getFirst().x-1,snakeBody.getFirst().y));
                    break;
                case EAST:
                    snakeBody.add(new Vector2(snakeBody.getFirst().x+1,snakeBody.getFirst().y));
                    break;
            }
        }
        else
        {
            Vector2 lastSegment = this.snakeBody.getLast();
            Vector2 beforeLast = this.snakeBody.get(snakeBody.size());
            int currentX, currentY;
            int futureX, futureY;
            int xDiff;
            int yDiff;

            //get future direction from link
            futureX = (int)beforeLast.x;
            futureY = (int) beforeLast.y;
            currentX = (int) lastSegment.x;
            currentY = (int) lastSegment.y;

            xDiff = futureX - currentX;
            yDiff = futureY - currentY;

            if((currentX - xDiff != boundsX)||(currentY -yDiff != boundsY))
            {
                snakeBody.add(new Vector2(currentX - xDiff,currentY - yDiff));
            }
            else
            {
                if(currentX - xDiff == boundsX)
                {
                    snakeBody.add(new Vector2(currentX+xDiff,currentY));
                }
                else
                    snakeBody.add(new Vector2(currentX, currentY + yDiff));
            }

        }







    }



    public void changeDirectionNorth()
    {
        if(this.currentDirection != NORTH)
        {
            this.lastDirection = this.currentDirection;
            this.currentDirection = NORTH;

        }
    }
    public void changeDirectionSouth()
    {
        if(this.currentDirection != SOUTH)
        {
            this.lastDirection = this.currentDirection;
            this.currentDirection = SOUTH;
        }
    }

    public void changeDirectionEAST()
    {
        if(this.currentDirection != EAST)
        {
            this.lastDirection = this.currentDirection;
            this.currentDirection = EAST;
        }
    }
    public void changeDirectionWest()
    {
        if(this.currentDirection != WEST) {
            this.lastDirection = this.currentDirection;
            this.currentDirection = WEST;
        }
    }

    public void changeSpeed(int speed)
    {
        this.speed = speed;
    }


    /*will move the snake in the current direction (N,S,W,E)
     *  if the snake has multiple segments, the segments will take the spot of the next segment and follow the same direction.
     *
     */
    public void move( )
    {

        boolean headMoved = false;
        float oldX =0f;
        float oldY=0f;
        float newX=0f;
        float newY=0f;


        Iterator<Vector2> iterator = snakeBody.descendingIterator();

        Vector2 currentSegment;


        if(illegalMove())
            currentDirection = lastDirection;

        while (iterator.hasNext())
        {
            currentSegment = iterator.next();
            if(!headMoved)
            {
                oldX = currentSegment.x;
                oldY = currentSegment.y;

                switch (currentDirection)
                {
                    case NORTH:
                        currentSegment.y += speed;
                        break;
                    case SOUTH:
                        currentSegment.y -= speed;
                        break;
                    case WEST:
                        currentSegment.x -= speed;
                        break;
                    case EAST:
                        currentSegment.x += speed;
                        break;
                }

                headMoved = true;
            }
            else
            {
                newX = oldX;
                newY = oldY;
                oldX = currentSegment.x;
                oldY = currentSegment.y;
                currentSegment.x = newX;
                currentSegment.y = newY;


            }
        }









    }





    private boolean illegalMove()
    {
        if(snakeBody.descendingIterator().hasNext())
        {
            switch (this.currentDirection)
            {
                case NORTH:
                    if ((int) snakeBody.getFirst().y + 1 == (int)snakeBody.descendingIterator().next().y)
                    {
                        return true;

                    }
                    else
                     return false;

                case WEST:
                    if ((int) snakeBody.getFirst().x - 1  == (int)snakeBody.descendingIterator().next().x)
                    {

                        return true;
                    }
                    else
                     return false;

                case SOUTH:
                    if ((int) snakeBody.getFirst().y - 1 == (int)snakeBody.descendingIterator().next().y)
                    {

                        return true;
                    }
                    else
                        return false;

                case EAST:
                    if ((int) snakeBody.getFirst().x + 1 == (int)snakeBody.descendingIterator().next().x)
                    {
                        return true;
                    }
                    else
                        return false;
            }
        }
            return false;

    }




    public LinkedList<Vector2> getSnakeBody()
    {return this.snakeBody;}






}
