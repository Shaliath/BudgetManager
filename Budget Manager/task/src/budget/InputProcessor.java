package budget;

import java.util.ArrayList;

public class InputProcessor {

    public static String process(ArrayList<String> input) {
        if (input.size() == 0) {
            return "Purchase list is empty";
        }
        StringBuilder builder = new StringBuilder();
        float total = 0;
        for (String item : input) {
            builder.append(item).append("\n");
            total = total + parsePurchase(item);
        }
        builder.append(String.format("Total: $%.2f", total));
        return builder.toString();
    }

    private static float parsePurchase(String purchase) {
        return Float.parseFloat(purchase.substring(purchase.lastIndexOf("$") + 1));
    }
}
