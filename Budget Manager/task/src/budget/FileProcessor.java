package budget;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;

public class FileProcessor {

    public static void savePurchases() {
        File file = new File(Constants.FILE_NAME);
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                System.out.println("Unable to create file");
                System.out.println(e.getMessage());
            }
        }
        if (file.exists()) {
            try (PrintWriter printWriter = new PrintWriter(file)) {
                printWriter.printf("Balance:%.2f\n", BudgetValues.getInstance().getBalance());
                for (Map.Entry<Integer, ArrayList<String>> entry : BudgetValues.getInstance().getPurchases().entrySet()) {
                    entry.getValue()
                            .forEach(purchase -> printWriter.printf("%d|%s\n", entry.getKey(), purchase));
                }
                System.out.println("\nPurchases were saved!\n");
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static void loadPurchases() {
        File file = new File(Constants.FILE_NAME);
        if (file.exists()) {
            BudgetValues budgetValues = BudgetValues.getInstance();
            try (Scanner scanner = new Scanner(file)) {
                float balance = Float.parseFloat(scanner.nextLine().replace("Balance:", ""));

                while (scanner.hasNext()) {
                    String[] purchase = scanner.nextLine().split("\\|");
                    budgetValues.addPurchase(getCategory(purchase[0]), getPurchaseName(purchase[1]), getPurchasePrice(purchase[1]));
                }
                budgetValues.setBalance(balance);
                System.out.println("\nPurchases were loaded!\n");
            } catch (IOException e) {
                System.out.println("\nUnable to load purchases\n");
                System.out.println(e.getMessage());
            }
        }
    }

    private static String getPurchaseName(String s) {
        return s.substring(0, s.lastIndexOf("$") - 1);
    }

    private static float getPurchasePrice(String s) {
        return Float.parseFloat(s.substring(s.lastIndexOf("$") + 1));
    }

    private static int getCategory(String text) {
        return Integer.parseInt(text);
    }
}
