package com.stanzaliving.statemachine;

import java.util.HashMap;
import java.util.Map;

public class StateMachineConfig<S extends State<?>, E extends Event<?>> {

    private final Map<S, StateRepresentation<S, E>> stateConfiguration = new HashMap<>();

    public StateRepresentation<S, E> getRepresentation(S state) {
        return stateConfiguration.get(state);
    }

    private StateRepresentation<S, E> getOrCreateRepresentation(S state) {
        StateRepresentation<S, E> result = stateConfiguration.get(state);
        if (result == null) {
            result = new StateRepresentation<>(state);
            stateConfiguration.put(state, result);
        }

        return result;
    }

    public StateConfiguration<S, E> configure(S state) {
        return new StateConfiguration<>(getOrCreateRepresentation(state));
    }
}
