package budget;

import java.util.Scanner;

public class InputReader {

    public static float readIncome(Scanner myScanner) {
        float income = myScanner.nextFloat();
        myScanner.nextLine();
        return income;
    }
}
