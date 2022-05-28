package machine;

import java.util.Scanner;

public class CoffeeMachine {
    public static int WATER = 400;
    public static int MILK = 540;
    public static int COFFEE = 120;
    public static int DISPOSABLE_CUPS = 9;
    public static int MONEY = 550;

    public static int getWATER() {
        return WATER;
    }

    public static int getMILK() {
        return MILK;
    }

    public static int getCOFFEE() {
        return COFFEE;
    }

    public static int getDisposableCups() {
        return DISPOSABLE_CUPS;
    }

    public static void main(String[] args) {
        showMenu();
    }


    public static void addIngredients() {
        System.out.println("Write how many ml of water the coffee machine has:");
        addWater(useScanner());

        System.out.println("Write how many ml of milk the coffee machine has:");
        addMilk(useScanner());

        System.out.println("Write how many grams of coffee beans the coffee machine has:");
        addCoffe(useScanner());

        System.out.println("Write how many disposable cups of coffee you want to add: ");
        addDisposableCups(useScanner());

        showMenu();
    }

    public static void addWater(int water) {
        WATER += water;
    }

    public static void addMilk(int milk) {
        MILK += milk;
    }

    public static void addMONEY(int money) {
        MONEY += money;
    }

    public static void addCoffe(int coffe) {
        COFFEE += coffe;
    }

    public static void addDisposableCups(int cups) {
        DISPOSABLE_CUPS += cups;
    }

    public static int takeWATER(int needWater) {
        if (WATER < needWater) {
            return 0;
        } else {
            WATER -= needWater;
            return needWater;
        }
    }

    public static int takeCOFFEE(int needCoffee) {
        if (COFFEE < needCoffee) {
            return 0;
        } else {
            COFFEE -= needCoffee;
            return needCoffee;
        }
    }

    public static int takeMILK(int needMilk) {
        if (MILK < needMilk) {
            return 0;
        } else {
            MILK -= needMilk;
            return needMilk;
        }
    }

    public static int takeDISPOSABLE_CUPS(int needCups) {
        if (DISPOSABLE_CUPS < needCups) {
            return 0;
        } else {
            DISPOSABLE_CUPS -= needCups;
            return needCups;
        }
    }

    public static int useScanner() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            try {
                int userInputInt = Integer.parseInt(scanner.next());
                return userInputInt;
            } catch (Exception e) {
                System.out.println("You need to enter a positive integer");
            }
        }
    }

    public static void showResources() {
        System.out.println("The coffee machine has:");
        System.out.printf("%d ml of water\n", WATER);
        System.out.printf("%d ml of milk\n", MILK);
        System.out.printf("%d g of coffee beans\n", COFFEE);
        System.out.printf("%d disposable cups\n", DISPOSABLE_CUPS);
        System.out.printf("$%d of money\n\n", MONEY);
        showMenu();
    }

    public static void showMenu() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.printf("Write action (buy, fill, take, remaining, exit): \n");
            String userInput = scanner.next();
            switch (userInput) {
                case "buy":
                    buy();
                    break;
                case "fill":
                    addIngredients();
                    break;
                case "take":
                    takeAllMoney();
                    break;
                case "remaining":
                    showResources();
                    break;
                case "exit":
                    System.exit(0);
                    break;
            }
        }
    }


    public static void buy() {
        System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu: ");
        Scanner scanner = new Scanner(System.in);

        switch (scanner.next()) {
            case "1":
                Coffee espresso = new Espresso();
                System.out.println(espresso.makeCoffee());
                break;
            case "2":
                Coffee latte = new Latte();
                System.out.println(latte.makeCoffee());
                break;
            case "3":
                Coffee cappuccino = new Cappuccino();
                System.out.println(cappuccino.makeCoffee());
                break;
            case "back":
                showMenu();
                break;
            default:
                System.out.println("Unfortunately this option is not available");
                showMenu();
                break;
        }
    }

    public static void takeAllMoney() {
        System.out.printf("I gave you $%d\n\n", MONEY);
        MONEY = 0;
        showMenu();
    }
}
