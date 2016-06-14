package com.rfprod.snakere.Actions;

/**
 *
 * Author: Carlos Jimenez
 * Revised: 6.14.16
 *
 * Purpose: WIll dispense actions for the snake to receive input.
 *
 */


public class ActionQueue
{

    private Action currentAction;

   public ActionQueue()
    {
        currentAction = null;
    }

    public void queueAction(Action action)
    {
        this.currentAction = action;
    }

    public void performAction()
    {
        if(currentAction != null) {
            currentAction.performAction();
            currentAction = null;
        }

    }


}
