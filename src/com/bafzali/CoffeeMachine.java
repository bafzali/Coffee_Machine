package com.bafzali;

public class CoffeeMachine {
    private int waterAvailable;
    private int milkAvailable;
    private int coffeeAvailable;
    private int cupsAvailable;
    private int moneyAvailable;
    private StateOfMachine stateOfMachine;

    public CoffeeMachine(int waterAvailable, int milkAvailable, int coffeeAvailable, int cupsAvailable, int moneyAvailable, StateOfMachine stateOfMachine) {
        this.waterAvailable = waterAvailable;
        this.milkAvailable = milkAvailable;
        this.coffeeAvailable = coffeeAvailable;
        this.cupsAvailable = cupsAvailable;
        this.moneyAvailable = moneyAvailable;
        this.stateOfMachine = stateOfMachine;
    }

    public StateOfMachine getStateOfMachine() {
        return stateOfMachine;
    }

    private void adjustResourcesAfterPurchase (int water, int milk, int coffee, int cups, int money) {
        this.waterAvailable -= water;
        this.milkAvailable -= milk;
        this.coffeeAvailable -= coffee;
        this.cupsAvailable -= cups;
        this.moneyAvailable += money;
    }

    public void readUserInput(String userInput) {

        switch (this.stateOfMachine) {
            case CHOOSING_ACTION:
                switch (userInput) {
                    case "fill":
                        this.stateOfMachine = StateOfMachine.FILLING_WATER;
                        break;
                    case "buy":
                        this.stateOfMachine = StateOfMachine.CHOOSING_COFFEE_VARIANT;
                        break;
                    case "take":
                        System.out.println("I gave you $" + this.moneyAvailable);
                        this.moneyAvailable = 0;
                        break;
                    case "remaining":
                        System.out.println("The coffee machine has: \n" + this.waterAvailable + " of water\n" + this.milkAvailable +
                                " of milk\n" + this.coffeeAvailable + " of coffee beans\n" + this.cupsAvailable + " of disposable cups\n" +
                                this.moneyAvailable + " of money");
                        break;
                    case "exit":
                        this.stateOfMachine = StateOfMachine.POWERING_OFF;
                        break;
                    default:
                        System.out.println("Invalid command");
                        this.stateOfMachine = StateOfMachine.CHOOSING_ACTION;
                        break;
                }
                break;

            case CHOOSING_COFFEE_VARIANT:
                if (userInput.equals("1") && waterAvailable >= 250 && coffeeAvailable >= 16 && cupsAvailable >= 1) {
                    adjustResourcesAfterPurchase(250,0, 16, 1, 4);
                    this.stateOfMachine = StateOfMachine.CHOOSING_ACTION;
                } else if (userInput.equals("2") && waterAvailable >= 350 && coffeeAvailable >= 20 && milkAvailable >= 75 && cupsAvailable >= 1) {
                    adjustResourcesAfterPurchase(350, 75, 20, 1, 7);
                    this.stateOfMachine = StateOfMachine.CHOOSING_ACTION;
                } else if (userInput.equals("3") && waterAvailable >= 200 && coffeeAvailable >= 12 && milkAvailable >= 100 && cupsAvailable >= 1) {
                    adjustResourcesAfterPurchase(200, 100, 12, 1, 6);
                    this.stateOfMachine = StateOfMachine.CHOOSING_ACTION;
                } else if (userInput.equals("back")) {
                    this.stateOfMachine = StateOfMachine.CHOOSING_ACTION;
                } else {
                    this.stateOfMachine = StateOfMachine.CHOOSING_ACTION;
                }
                break;

            case FILLING_WATER:
                waterAvailable += Integer.parseInt(userInput);
                this.stateOfMachine = StateOfMachine.FILLING_MILK;
                break;

            case FILLING_MILK:
                milkAvailable += Integer.parseInt(userInput);
                this.stateOfMachine = StateOfMachine.FILLING_COFFEE;
                break;

            case FILLING_COFFEE:
                coffeeAvailable += Integer.parseInt(userInput);
                this.stateOfMachine = StateOfMachine.FILLING_CUPS;
                break;

            case FILLING_CUPS:
                cupsAvailable += Integer.parseInt(userInput);
                this.stateOfMachine = StateOfMachine.CHOOSING_ACTION;
                break;

            default:
                this.stateOfMachine = StateOfMachine.CHOOSING_ACTION;
                break;
        }
    }
}
