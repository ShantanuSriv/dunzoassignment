package coffeeMachine.constant;

/**
 * @author shantanu
 * Strings constants related to CoffeeMachine.
 */
public class Constants {
    public static final String NO_SUCH_BEVERAGE_FAILURE_MESSAGE = "Cannot serve %s beverage";
    public static final String NUMBER_OF_OUTLETS_KEY = "count_n";
    public static final String BEVERAGE_PREPARED_SUCCESS = "%s is prepared";
    public static final String BEVERAGE_INSUFFICIENT = "%s cannot be prepared because %s is not sufficient";
    public static final String BEVERAGE_FAILED = "%s cannot be prepared because %s is not available";
    public static final String TEST_JSON_INPUT = "{\n" +
            "  \"machine\": {\n" +
            "    \"outlets\": {\n" +
            "      \"count_n\": 3\n" +
            "    },\n" +
            "    \"total_items_quantity\": {\n" +
            "      \"hot_water\": 500,\n" +
            "      \"hot_milk\": 500,\n" +
            "      \"ginger_syrup\": 100,\n" +
            "      \"sugar_syrup\": 100,\n" +
            "      \"tea_leaves_syrup\": 100\n" +
            "    },\n" +
            "    \"beverages\": {\n" +
            "      \"hot_tea\": {\n" +
            "        \"hot_water\": 200,\n" +
            "        \"hot_milk\": 100,\n" +
            "        \"ginger_syrup\": 10,\n" +
            "        \"sugar_syrup\": 10,\n" +
            "        \"tea_leaves_syrup\": 30\n" +
            "      },\n" +
            "      \"hot_coffee\": {\n" +
            "        \"hot_water\": 100,\n" +
            "        \"ginger_syrup\": 30,\n" +
            "        \"hot_milk\": 400,\n" +
            "        \"sugar_syrup\": 50,\n" +
            "        \"tea_leaves_syrup\": 30\n" +
            "      },\n" +
            "      \"black_tea\": {\n" +
            "        \"hot_water\": 300,\n" +
            "        \"ginger_syrup\": 30,\n" +
            "        \"sugar_syrup\": 50,\n" +
            "        \"tea_leaves_syrup\": 30\n" +
            "      },\n" +
            "      \"green_tea\": {\n" +
            "        \"hot_water\": 100,\n" +
            "        \"ginger_syrup\": 30,\n" +
            "        \"sugar_syrup\": 50,\n" +
            "        \"green_mixture\": 30\n" +
            "      }\n" +
            "    }\n" +
            "  }\n" +
            "}";
}
