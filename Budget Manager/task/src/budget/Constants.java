package budget;

import java.util.HashMap;

public class Constants {

    public static final String MAIN_MENU = setMenu();
    public static final String ADD_CATEGORIES_MENU = setCategoriesToAdd();
    public static final String SHOW_CATEGORIES_MENU = setCategoriesToShow();
    public static final String SORTING_MENU = setSortingMenu();
    public static final HashMap<Integer, String> CATEGORIES = setCategories();
    public static final String FILE_NAME = "purchases.txt";

    private static HashMap<Integer, String> setCategories() {
        HashMap<Integer, String> map = new HashMap<>();
        map.put(1, "Food");
        map.put(2, "Clothes");
        map.put(3, "Entertainment");
        map.put(4, "Other");
        return map;
    }

    private static String setMenu() {
        return "Choose your action:\n" +
                "1) Add income\n" +
                "2) Add purchase\n" +
                "3) Show list of purchases\n" +
                "4) Balance\n" +
                "5) Save\n" +
                "6) Load\n" +
                "7) Analyze (Sort)\n" +
                "0) Exit";
    }

    private static String setCategoriesToAdd() {
        return getCategoriesList()
                .append("\n5) Back")
                .toString();
    }

    private static String setCategoriesToShow() {
        return getCategoriesList()
                .append("\n5) All\n")
                .append("6) Back")
                .toString();
    }

    public static StringBuilder getCategoriesList() {
        StringBuilder builder = new StringBuilder();
        builder.append("\nChoose the type of purchases\n")
                .append("1) Food\n")
                .append("2) Clothes\n")
                .append("3) Entertainment\n")
                .append("4) Other");
        return builder;
    }

    private static String setSortingMenu() {
        return "\nHow do you want to sort?\n" +
                "1) Sort all purchases\n" +
                "2) Sort by type\n" +
                "3) Sort certain type\n" +
                "4) Back";
    }

    public static String getCategory(int category) {
        return CATEGORIES.get(category);
    }
}
