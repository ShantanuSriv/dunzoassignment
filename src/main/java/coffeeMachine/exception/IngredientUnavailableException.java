package coffeeMachine.exception;

import lombok.Getter;

/**
 * @author shantanu
 * When ingredient is unavailable
 */
@Getter
public class IngredientUnavailableException extends CoffeeMachineException {

    public IngredientUnavailableException(String machineOutput) {
        this.machineOutput = machineOutput;
    }
}
