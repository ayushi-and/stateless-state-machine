package com.stanzaliving.statemachine.triggers;


import com.stanzaliving.statemachine.actions.Action1;

public class TriggerBehaviour<S,E> {

    private S destination = null;
    private E trigger = null;
    private Action1<Object[]> action = null;

    public TriggerBehaviour(E trigger, S destination, Action1<Object[]> action) {
        this.trigger = trigger;
        this.destination = destination;
        this.action = action;
    }

    public void performAction(Object[] args) {
        action.doIt(args);
    }

    public S transitionsTo(S source, Object[] args) {
        return destination;
    }

    public E getEvent() {
        return trigger;
    }
}
