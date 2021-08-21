package coffeeMachine.exception;

import lombok.Getter;

/**
 * @author shantanu
 * Main Exception class.
 */
@Getter
public abstract class CoffeeMachineException extends Exception {
    protected String machineOutput;
}
