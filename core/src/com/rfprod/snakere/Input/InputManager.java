package com.rfprod.snakere.Input;

import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.rfprod.snakere.Actions.Action;
import com.rfprod.snakere.Actions.ActionQueue;
import com.rfprod.snakere.Actions.MoveEast;
import com.rfprod.snakere.Actions.MoveNorth;
import com.rfprod.snakere.Actions.MoveSouth;
import com.rfprod.snakere.Actions.MoveWest;
import com.rfprod.snakere.Game.World;

/**
 * Author: Carlos Jimenez
 * EDITED: 4.9.16
 *
 * Purpose will get input from the user and send it to the world for use.
 *
 *
 *
 */


public class InputManager implements InputProcessor
{

    private World world;
    private ActionQueue queue;


    private Action moveNorth;
    private Action moveEast;
    private Action moveSouth;
    private Action moveWest;





    public InputManager(World world)
    {

        this.world = world;

        moveNorth = new MoveNorth(world);
        moveEast = new MoveEast(world);
        moveSouth = new MoveSouth(world);
        moveWest = new MoveWest(world);
        queue = new ActionQueue();

    }

    public void processInput()
    {
        queue.performAction();
    }




    @Override
    public boolean keyDown(int keycode) {


        switch(keycode)
        {
            case Input.Keys.A:
            case Input.Keys.LEFT:
            case Input.Keys.NUM_4:
                queue.queueAction(moveWest);
                return true;

            case Input.Keys.W:
            case Input.Keys.UP:
            case Input.Keys.NUM_8:
                queue.queueAction(moveNorth);
                return true;

            case Input.Keys.D:
            case Input.Keys.RIGHT:
            case Input.Keys.NUM_6:
                queue.queueAction(moveEast);
                return true;

            case Input.Keys.S:
            case Input.Keys.DOWN:
            case Input.Keys.NUM_5:
                queue.queueAction(moveSouth);
                return true;



        }

        return false;



    }

    @Override
    public boolean keyUp(int keycode) {
        return false;
    }

    @Override
    public boolean keyTyped(char character)
    {

        return false;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        return false;
    }

    @Override
    public boolean scrolled(int amount) {
        return false;
    }
}
