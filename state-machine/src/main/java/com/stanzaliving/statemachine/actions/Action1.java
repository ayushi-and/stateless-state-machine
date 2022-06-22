package com.stanzaliving.statemachine.actions;

@FunctionalInterface
public interface Action1<T> {
    void doIt(T arg1);
}
