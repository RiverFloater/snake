package com.rfprod.snakere.Actions;

import com.rfprod.snakere.Game.Snake;
import com.rfprod.snakere.Game.World;

/**
 * Created by cmjim on 4/9/2016.
 */
public class MoveWest implements Action {
    Snake snake;

    public MoveWest(World world)
    {this.snake = world.getSnake();}


    @Override
    public boolean performAction() {
        this.snake.changeDirectionWest();
        return true;
    }
}
