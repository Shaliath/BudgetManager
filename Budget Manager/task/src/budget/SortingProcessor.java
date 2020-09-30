package budget;

import java.util.*;

public class SortingProcessor {

    public static void sortAllPurchases() {
        System.out.println("\nAll:");
        System.out.println();
        ArrayList<String> allPurchases = new ArrayList<>();
        BudgetValues.getInstance().getPurchases()
                .forEach((key, value) -> allPurchases.addAll(value));
        System.out.println(InputProcessor.process(sort(allPurchases)));
    }

    public static void sortByType() {
        System.out.println("\nTypes:");
        ArrayList<String> purchasesByCategory = new ArrayList<>();
        for (Map.Entry<Integer, ArrayList<String>> category : BudgetValues.getInstance().getPurchases().entrySet()) {
            String result = String.format("%s - $%.2f",
                    Constants.getCategory(category.getKey()),
                    category.getValue().stream().mapToDouble(SortingProcessor::getPrice).sum());
            purchasesByCategory.add(result);
        }
        System.out.println(InputProcessor.process(sort(purchasesByCategory)));
    }

    public static void sortCertainType(Scanner myScanner) {
        System.out.println(Constants.getCategoriesList());
        try {
            int category = Integer.parseInt(myScanner.nextLine());
            if (category <= 4) {
                ArrayList<String> purchases = BudgetValues.getInstance().getPurchases().get(category);
                System.out.println();
                if (purchases.size() > 0) {
                    System.out.println(Constants.getCategory(category) + ":");
                }
                System.out.println(InputProcessor.process(sort(purchases)));
            } else {
                System.out.println("No such category");
            }
        } catch (NumberFormatException e) {
            System.out.println("Wrong category");
        }

    }

    private static ArrayList<String> sort(ArrayList<String> array) {
        array.sort(Comparator.naturalOrder());
        array.sort(Comparator.comparingDouble(SortingProcessor::getPrice));
        Collections.reverse(array);
        return array;
    }

    private static double getPrice(String purchase) {
        return Double.parseDouble(purchase.substring(purchase.lastIndexOf("$") + 1));
    }
}
