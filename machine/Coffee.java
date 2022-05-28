package machine;

public abstract class Coffee {
    private int NEED_WATER;
    private int NEED_MILK;
    private int NEED_COFFEE_BEANS;
    private int NEED_CUPS;
    private int COST;

    private static final String COMPLETE_MESSAGE = "I have enough resources, making you a coffee!";
    private static String NOT_ENOUGH_MESSAGE = "Sorry, not enough";

    public void setNEED_WATER(int NEED_WATER) {
        this.NEED_WATER = NEED_WATER;
    }

    public void setNEED_MILK(int NEED_MILK) {
        this.NEED_MILK = NEED_MILK;
    }

    public void setNEED_COFFEE_BEANS(int NEED_COFFEE_BEANS) {
        this.NEED_COFFEE_BEANS = NEED_COFFEE_BEANS;
    }

    public void setNEED_CUPS(int NEED_CUPS) {
        this.NEED_CUPS = NEED_CUPS;
    }

    public void setCOST(int COST) {
        this.COST = COST;
    }

    public String makeCoffee() {
        if (chekResources()) {
            CoffeeMachine.takeWATER(NEED_WATER);
            CoffeeMachine.takeMILK(NEED_MILK);
            CoffeeMachine.takeCOFFEE(NEED_COFFEE_BEANS);
            CoffeeMachine.takeDISPOSABLE_CUPS(NEED_CUPS);
            CoffeeMachine.addMONEY(COST);
            return COMPLETE_MESSAGE;
        } else {
            return NOT_ENOUGH_MESSAGE;
        }
    }

    private boolean chekResources() {
        boolean enoughWater = chekWatter();
        boolean enoughMilk = chekMilk();
        boolean enoughCoffeeBeans = chekCoffeeBeans();
        boolean enoughCups = chekCups();

        return enoughWater && enoughMilk && enoughCoffeeBeans && enoughCups;
    }

    private void createMessageNotEnoughResource(String resource) {
        StringBuilder not_enough = new StringBuilder(NOT_ENOUGH_MESSAGE);
        not_enough.append(resource);
        NOT_ENOUGH_MESSAGE = not_enough.toString();
    }

    private boolean chekWatter() {
        if (CoffeeMachine.getWATER() >= NEED_WATER) {
            return true;
        } else {
            createMessageNotEnoughResource(" water!");
            return false;
        }
    }

    private boolean chekCoffeeBeans() {
        if (CoffeeMachine.getCOFFEE() >= NEED_COFFEE_BEANS) {
            return true;
        } else {
            createMessageNotEnoughResource(" coffee beans!");
            return false;
        }
    }

    private boolean chekCups() {
        if (CoffeeMachine.getDisposableCups() >= NEED_CUPS) {
            return true;
        } else {
            createMessageNotEnoughResource(" disposable cups!");
            return false;
        }
    }

    private boolean chekMilk() {
        if (CoffeeMachine.getMILK() >= NEED_MILK) {
            return true;
        } else {
            createMessageNotEnoughResource(" milk!");
            return false;
        }
    }
}
