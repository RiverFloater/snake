package com.rfprod.snakere.Actions;

import com.rfprod.snakere.Game.Snake;
import com.rfprod.snakere.Game.World;

/**
 * Created by cmjim on 4/9/2016.
 */
public class MoveEast implements Action {
    Snake snake;

    public MoveEast(World world)
    {this.snake = world.getSnake();}


    @Override
    public boolean performAction() {
        this.snake.changeDirectionEast();
        return true;
    }
}
