package budget;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.stream.IntStream;

public class BudgetValues {

    private static BudgetValues instance;
    private float balance = 0;

    private HashMap<Integer, ArrayList<String>> purchases = createPurchasesMap();

    private BudgetValues() {}

    public float getBalance() {
        return balance;
    }

    public void setBalance(float balance) {
        this.balance += balance;
    }

    public static BudgetValues getInstance() {
        if (instance == null) {
            instance = new BudgetValues();
        }
        return instance;
    }

    public void addIncomeToBalance(float value) {
        this.balance += value;
    }

    public void printBalance() {
        System.out.println(String.format("\nBalance: $%.2f\n", this.balance));
    }

    public void addPurchase(int category, String purchaseName, float price) {
        this.purchases.get(category).add(String.format("%s $%.2f", purchaseName, price));
        this.balance -= price;
        if (this.balance < 0) {
            this.balance = 0;
        }
    }

    public HashMap<Integer, ArrayList<String>> getPurchases() {
        return this.purchases;
    }

    private HashMap<Integer, ArrayList<String>> createPurchasesMap() {
        HashMap<Integer, ArrayList<String>> map = new HashMap<>();
        IntStream.range(1, 5).forEach(key -> map.put(key, new ArrayList<>()));
        return map;
    }
}
