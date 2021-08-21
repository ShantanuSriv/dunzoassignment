package coffeeMachine.service;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class CoffeeWorkerService implements Runnable {
    private final CoffeeMachineService coffeeMachineService;
    private final String beverage;

    @Override
    public void run() {
        String output = coffeeMachineService.serve(beverage);
        System.out.println(output);
    }
}
