package budget;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);
        boolean run = true;
        while (run) {
            showMenu();
            String command = myScanner.nextLine().toLowerCase();
            switch (command) {
                case "1":
                    Operations.addIncome(myScanner);
                    break;
                case "2":
                    Operations.addPurchase(myScanner);
                    break;
                case "3":
                    Operations.showPurchases(myScanner);
                    break;
                case "4":
                    Operations.printBalance();
                    break;
                case "5":
                    Operations.save();
                    break;
                case "6":
                    Operations.load();
                    break;
                case "7":
                    Operations.sortPurchases(myScanner);
                    break;
                case "0":
                    System.out.println("\nBye!");
                    run = false;
                    myScanner.close();
                    break;
                default:
                    System.out.println("Wrong operation!");
            }
        }
    }

    private static void showMenu() {
        System.out.println(Constants.MAIN_MENU);
    }

}
