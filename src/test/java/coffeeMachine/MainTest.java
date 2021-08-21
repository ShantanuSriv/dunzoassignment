package coffeeMachine;


import coffeeMachine.config.Beverage;
import coffeeMachine.models.Inventory;
import coffeeMachine.service.CoffeeMachineService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.junit.Test;

import static coffeeMachine.Constants.*;
import static org.junit.Assert.assertEquals;

public class MainTest {

    @Test
    public void whenIngredientsAvailableThenServe() throws JsonProcessingException {
        Inventory inventory = Inventory.getInstance(Utils.getMockedInventory());
        Beverage beverage = new Beverage(Utils.getMockedBeverageConfig());
        CoffeeMachineService coffeeMachineService = new CoffeeMachineService(inventory, beverage);
        String output = coffeeMachineService.serve(HOT_TEA_BEVERAGE);
        assertEquals(String.format(BEVERAGE_PREPARATION_SUCCESS_MESSAGE, HOT_TEA_BEVERAGE), output);
    }

    @Test
    public void whenIngredientsUnavailableThenDoNotServe() throws JsonProcessingException {
        Inventory inventory = Inventory.getInstance(Utils.getMockedInventory());
        Beverage beverage = new Beverage(Utils.getMockedBeverageConfig());
        CoffeeMachineService coffeeMachineService = new CoffeeMachineService(inventory, beverage);
        String output = coffeeMachineService.serve(GREEN_TEA_BEVERAGE);
        assertEquals(String.format(BEVERAGE_PREPARATION_NOT_AVAILABLE_FAILURE_MESSAGE, GREEN_TEA_BEVERAGE, GREEN_MIXTURE_INGREDIENT), output);
    }

    @Test
    public void whenIngredientAvailableServeMany() throws JsonProcessingException {
        Inventory inventory = Inventory.getInstance(Utils.getMockedInventory());
        Beverage beverage = new Beverage(Utils.getMockedBeverageConfig());
        CoffeeMachineService coffeeMachineService = new CoffeeMachineService(inventory, beverage);
        String output1 = coffeeMachineService.serve(HOT_TEA_BEVERAGE);
        String output2 = coffeeMachineService.serve(HOT_COFFEE_BEVERAGE);
        assertEquals(String.format(BEVERAGE_PREPARATION_SUCCESS_MESSAGE, HOT_TEA_BEVERAGE), output1);
        assertEquals(String.format(BEVERAGE_PREPARATION_SUCCESS_MESSAGE, HOT_COFFEE_BEVERAGE), output2);
    }

    @Test
    public void whenIngredientInsufficientDoNotServe() throws JsonProcessingException {
        Inventory inventory = Inventory.getInstance(Utils.getMockedInventory());
        Beverage beverage = new Beverage(Utils.getMockedBeverageConfig());
        CoffeeMachineService coffeeMachineService = new CoffeeMachineService(inventory, beverage);
        String output1 = coffeeMachineService.serve(HOT_TEA_BEVERAGE);
        String output2 = coffeeMachineService.serve(HOT_COFFEE_BEVERAGE);
        String output3 = coffeeMachineService.serve(BLACK_TEA_BEVERAGE);
        assertEquals(String.format(BEVERAGE_PREPARATION_SUCCESS_MESSAGE, HOT_TEA_BEVERAGE), output1);
        assertEquals(String.format(BEVERAGE_PREPARATION_SUCCESS_MESSAGE, HOT_COFFEE_BEVERAGE), output2);
        assertEquals(String.format(BEVERAGE_PREPARATION_INSUFFICIENT_FAILURE_MESSAGE, BLACK_TEA_BEVERAGE, HOT_WATER_INGREDIENT), output3);
    }
}
