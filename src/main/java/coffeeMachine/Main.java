package coffeeMachine;

import coffeeMachine.config.Beverage;
import coffeeMachine.models.Inventory;
import coffeeMachine.models.dto.CoffeeMachineInputDto;
import coffeeMachine.models.dto.InputDto;
import coffeeMachine.service.CoffeeMachineService;
import coffeeMachine.service.CoffeeWorkerService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

import static coffeeMachine.constant.Constants.NUMBER_OF_OUTLETS_KEY;
import static coffeeMachine.constant.Constants.TEST_JSON_INPUT;

/**
 * @author shantanu
 * Main class - entry point
 */
public class Main {
    private static ObjectMapper objectMapper = new ObjectMapper();

    public static void main(String[] args) throws JsonProcessingException {

        final CoffeeMachineInputDto coffeeMachineInputDto = getParsedInput();
        final Inventory inventory = Inventory.getInstance(coffeeMachineInputDto.getTotalItemsQuantity());
        final Beverage beverage = new Beverage(coffeeMachineInputDto.getBeverages());
        final List<String> beverages = beverage.getBeverages();
        final int outlets = coffeeMachineInputDto.getOutlets().get(NUMBER_OF_OUTLETS_KEY);

        ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(outlets);

        for(int i=0; i<beverages.size(); i++) {
            CoffeeMachineService coffeeMachineService = new CoffeeMachineService(inventory, beverage);
            Runnable coffeeMachineWorker =
                    new CoffeeWorkerService(coffeeMachineService, beverages.get(i));
            executor.execute(coffeeMachineWorker);
        }
        executor.shutdown();
    }

    public static CoffeeMachineInputDto getParsedInput() throws JsonProcessingException {
        String jsonInput = TEST_JSON_INPUT;
        InputDto inputDto = objectMapper.readValue(jsonInput, InputDto.class);
        return inputDto.getMachine();
    }
}
