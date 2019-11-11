package com.bafzali;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        CoffeeMachine coffeeMachine = new CoffeeMachine(400, 540, 120, 9, 550, StateOfMachine.CHOOSING_ACTION);

        Scanner scanner = new Scanner(System.in);

        while (coffeeMachine.getStateOfMachine() != StateOfMachine.POWERING_OFF) {
            switch (coffeeMachine.getStateOfMachine()) {
                case CHOOSING_ACTION:
                    System.out.println("Write action (buy, fill, take, remaining, exit):");
                    coffeeMachine.readUserInput(scanner.next());
                    break;
                case CHOOSING_COFFEE_VARIANT:
                    System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu: ");
                    coffeeMachine.readUserInput(scanner.next());
                    break;
                case FILLING_WATER:
                    System.out.println("Write how many ml of water do you want to add: ");
                    coffeeMachine.readUserInput(scanner.next());
                    break;
                case FILLING_MILK:
                    System.out.println("Write how many ml of milk do you want to add: ");
                    coffeeMachine.readUserInput(scanner.next());
                    break;
                case FILLING_COFFEE:
                    System.out.println("Write how many grams of coffee beans do you want to add: ");
                    coffeeMachine.readUserInput(scanner.next());
                    break;
                case FILLING_CUPS:
                    System.out.println("Write how many disposable cups of coffee do you want to add: ");
                    coffeeMachine.readUserInput(scanner.next());
                    break;
                default:
                    System.out.println("Invalid Entry");
                    break;
            }
        }

        scanner.close();
    }
}


