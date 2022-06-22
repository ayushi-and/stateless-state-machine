package com.stanzaliving.statemachine;


import com.stanzaliving.statemachine.triggers.TriggerBehaviour;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

@Getter
@Setter
@AllArgsConstructor
public class StateRepresentation<S extends State<?>, E extends Event<?>> {

    private S state;
    private final Map<E, TriggerBehaviour<S, E>> triggerBehaviours = new HashMap<>();

    public void addTriggerBehaviour(TriggerBehaviour<S, E> transitioningTriggerBehaviour) {
        triggerBehaviours.put(transitioningTriggerBehaviour.getEvent(), transitioningTriggerBehaviour);
    }

    public TriggerBehaviour<S, E> findTriggerBehaviour(E trigger) {
        return triggerBehaviours.get(trigger);
    }
}
