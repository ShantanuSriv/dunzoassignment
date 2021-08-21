package coffeeMachine.models.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class CoffeeMachineInputDto {
    Map<String, Integer> outlets;
    @JsonProperty(value = "total_items_quantity")
    ConcurrentHashMap<String, Integer> totalItemsQuantity;
    Map<String, Map<String, Integer>> beverages;
}
