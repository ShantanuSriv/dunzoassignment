package coffeeMachine.service;

import coffeeMachine.config.Beverage;
import coffeeMachine.models.Inventory;
import coffeeMachine.exception.CoffeeMachineException;
import lombok.AllArgsConstructor;

import java.util.Map;

import static coffeeMachine.constant.Constants.BEVERAGE_PREPARED_SUCCESS;

/**
 * @author shantanu
 * managing specified beverage.
 */
@AllArgsConstructor
public class CoffeeMachineService {
    private final Inventory inventory;
    private final Beverage beverage;

    public String serve(String beverage) {
        try {
            Map<String, Integer> ingredients = this.beverage.getIngredients(beverage);
            inventory.reduceIngredients(ingredients, beverage);
        } catch (final CoffeeMachineException exception) {
            return handleException(exception, beverage);
        }
        return String.format(BEVERAGE_PREPARED_SUCCESS, beverage);
    }

    String handleException(final CoffeeMachineException exception, final String beverage) {
        return exception.getMachineOutput();
    }

}
