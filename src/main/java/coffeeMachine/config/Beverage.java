package coffeeMachine.config;

import coffeeMachine.exception.BeverageUnavailableException;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static coffeeMachine.constant.Constants.NO_SUCH_BEVERAGE_FAILURE_MESSAGE;

/**
 * @author shantanu
 */
public class Beverage {
    Map<String, Map<String, Integer>> beverageIngredients;

    public Beverage(Map<String, Map<String, Integer>> beverageIngredients) {
        this.beverageIngredients = beverageIngredients;
    }

    /**
     * @param beverage
     * @return ingredients
     * @throws BeverageUnavailableException
     */
    public Map<String, Integer> getIngredients(String beverage) throws BeverageUnavailableException {
        Map<String, Integer> ingredients = beverageIngredients.get(beverage);
        if(ingredients == null) {
            throw new BeverageUnavailableException(String.format(NO_SUCH_BEVERAGE_FAILURE_MESSAGE, beverage));
        }
        return ingredients;
    }

    /**
     * @return List
     */
    public List<String> getBeverages() {
        return beverageIngredients.keySet().stream().collect(Collectors.toList());
    }
}
