package coffeeMachine.exception;

import lombok.Getter;

/**
 * @author shantanu
 * when beverage is unavailable
 */
@Getter
public class BeverageUnavailableException extends CoffeeMachineException {
    public BeverageUnavailableException(String machineOutput) {
        this.machineOutput = machineOutput;
    }
}
