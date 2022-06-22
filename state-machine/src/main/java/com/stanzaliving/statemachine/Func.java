package com.stanzaliving.statemachine;

/**
 * Represents a function that accepts no input and produces a result
 *
 * @param <R> Result type
 */
@FunctionalInterface
public interface Func<R> {

    /**
     * Applies this function
     *
     * @return Result
     */
    R call();
}
