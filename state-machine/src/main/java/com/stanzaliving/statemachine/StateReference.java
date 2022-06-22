package com.stanzaliving.statemachine;

public class StateReference<S> {

    private S state;

    public S getState() {
        return state;
    }

    public void setState(S value) {
        state = value;
    }
}
