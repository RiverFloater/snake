package com.rfprod.snakere.Actions;

/**
 * WIll dispense actions for the snake to receive input.
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
