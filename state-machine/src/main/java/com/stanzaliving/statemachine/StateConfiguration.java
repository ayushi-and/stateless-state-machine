package com.stanzaliving.statemachine;

import com.stanzaliving.statemachine.actions.Action1;
import com.stanzaliving.statemachine.triggers.TriggerBehaviour;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class StateConfiguration<S extends State<?>, E extends Event<?>> {

    private final StateRepresentation<S, E> representation;

    public StateConfiguration<S, E> permit(E event, S destinationState, Action1<Object[]> action) {
        return publicPermit(event, destinationState, action);
    }

    StateConfiguration<S, E> publicPermit(E event, S destinationState, Action1<Object[]> action) {
        representation.addTriggerBehaviour(new TriggerBehaviour(event, destinationState, action));
        return this;
    }

    /**
     * public StateConfiguration onEntry(final Action entryAction) {
     *         return onEntry(new Action1<Transition<S, T>>() {
     *             @Override
     *             public void doIt(Transition<S, T> t) {
     *                 entryAction.doIt();
     *             }
     *         });
     *     }
     *
     *     public StateConfiguration onEntry(final Action entryAction) {
     *         representation.addEntryAction(entryAction);
     *         return this;
     */


}
