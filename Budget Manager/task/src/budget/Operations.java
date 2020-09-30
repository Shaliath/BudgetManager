package budget;

import java.util.ArrayList;
import java.util.Scanner;

public class Operations {

    public static void addIncome(Scanner myScanner) {
        System.out.println("\nEnter income:");
        BudgetValues.getInstance()
                .addIncomeToBalance(InputReader.readIncome(myScanner));
        System.out.println("Income was added!\n");
    }

    public static void printBalance() {
        BudgetValues.getInstance().printBalance();
    }

    public static void addPurchase(Scanner myScanner) {
        boolean run = true;
        while (run) {
            System.out.println(Constants.ADD_CATEGORIES_MENU);
            String input = myScanner.nextLine();
            try {
                int purchaseCategory = Integer.parseInt(input);
                if (purchaseCategory < 5) {
                    System.out.println("\nEnter purchase name:");
                    String purchaseName = myScanner.nextLine();
                    System.out.println("Enter its price:");
                    float price = myScanner.nextFloat();
                    myScanner.nextLine();
                    BudgetValues.getInstance().addPurchase(purchaseCategory, purchaseName, price);
                    System.out.println("Purchase was added!");
                } else if (purchaseCategory == 5) {
                    run = false;
                    System.out.println();
                } else {
                    System.out.println("Wrong category");
                }
            } catch (NumberFormatException e) {
                System.out.println("Wrong category");
            }
        }
    }

    public static void showPurchases(Scanner myScanner) {
        boolean run = true;
        while (run) {
            System.out.println(Constants.SHOW_CATEGORIES_MENU);
            String input = myScanner.nextLine();
            try {
                int category = Integer.parseInt(input);
                if (category <= 6) {
                    switch (category) {
                        case 6:
                            run = false;
                            System.out.println();
                            break;
                        case 5:
                            showAllPurchases();
                            break;
                        default:
                            showPurchasesInCategory(category);
                            break;
                    }
                } else {
                    System.out.println("Wrong category");
                }
            } catch (NumberFormatException e) {
                System.out.println("Wrong category");
            }
        }
    }

    private static void showAllPurchases() {
        System.out.println("\nAll:");
        ArrayList<String> allPurchases = new ArrayList<>();
        BudgetValues.getInstance().getPurchases()
                .forEach((key, value) -> allPurchases.addAll(value));
        System.out.println(InputProcessor.process(allPurchases));
    }

    private static void showPurchasesInCategory(int category) {
        System.out.println("\n" + Constants.CATEGORIES.get(category) + ":");
        System.out.println(InputProcessor.process(BudgetValues.getInstance().getPurchases().get(category)));
    }

    public static void save() {
        FileProcessor.savePurchases();
    }

    public static void load() {
        FileProcessor.loadPurchases();
    }

    public static void sortPurchases(Scanner myScanner) {
        boolean run = true;
        while (run) {
            System.out.println(Constants.SORTING_MENU);
            String input = myScanner.nextLine();
            try {
                int sortingType = Integer.parseInt(input);
                if (sortingType <= 4) {
                    switch (sortingType) {
                        case 4:
                            run = false;
                            System.out.println();
                            break;
                        case 1:
                            SortingProcessor.sortAllPurchases();
                            break;
                        case 2:
                            SortingProcessor.sortByType();
                            break;
                        case 3:
                            SortingProcessor.sortCertainType(myScanner);
                            break;
                        default:
                            break;
                    }
                } else {
                    System.out.println("Wrong sorting type");
                }

            } catch (NumberFormatException e) {
                System.out.println("Wrong sorting type");
            }
        }
    }
}
