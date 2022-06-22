package com.stanzaliving.statemachine;


import com.stanzaliving.statemachine.actions.Action1;
import com.stanzaliving.statemachine.triggers.TriggerBehaviour;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class StateMachine<S extends State<?>, E extends Event<?>> {

    private final S initialState;
    private final StateMachineConfig<S, E> config;
    protected final Func<S> stateAccessor;
    protected final Action1<S> stateMutator;

    public StateMachine(S initialState, StateMachineConfig<S, E> config) {
        this.initialState = initialState;
        this.config = config;
        final StateReference<S> reference = new StateReference<>();
        reference.setState(initialState);
        stateAccessor = reference::getState;
        stateMutator = reference::setState;
    }

    public S getState() {
        return stateAccessor.call();
    }

    private void setState(S value) {
        stateMutator.doIt(value);
    }

    public final void fire(E event, Object... args) {
        TriggerBehaviour<S, E> triggerBehaviour = config.getRepresentation(getState()).findTriggerBehaviour(event);
        triggerBehaviour.performAction(args);
        S destination = triggerBehaviour.transitionsTo(initialState, args);
        setState(destination);
//        config.getRepresentation(initialState).setState(destination); //to set the initial state again (destination state)
    }

}
