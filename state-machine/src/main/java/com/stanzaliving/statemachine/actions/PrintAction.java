package com.stanzaliving.statemachine.actions;

import com.stanzaliving.statemachine.actions.Action1;

public class PrintAction implements Action1<String> {

    public PrintAction(Object[] objects) {

    }

    public void perform(String statement) {
        System.out.println(statement);
    }

    @Override
    public void doIt(String arg1) {

    }
}
