package machine;

import java.util.ArrayList;
import java.util.Scanner;

public class Machine {
    private int water;
    private int milk;
    private int coffee;
    private int money;
    private int cups;
    private ArrayList<Receipt> receipts;

    public Machine(int water, int milk, int coffee, int money, int cups) {
        this.water = water;
        this.milk = milk;
        this.coffee = coffee;
        this.money = money;
        this.cups = cups;
        initReceipt();
    }

    public int getWater() {
        return water;
    }

    public void setWater(int water) {
        this.water = water;
    }

    public int getMilk() {
        return milk;
    }

    public void setMilk(int milk) {
        this.milk = milk;
    }

    public int getCoffee() {
        return coffee;
    }

    public void setCoffee(int coffee) {
        this.coffee = coffee;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public int getCups() {
        return cups;
    }

    public void setCups(int cups) {
        this.cups = cups;
    }

    protected void initReceipt(){
        receipts = new ArrayList<Receipt>();
        receipts.add(new Receipt(1, "espresso", 250, 0, 16, 4));
        receipts.add(new Receipt(2, "latte", 350, 75, 20, 7));
        receipts.add(new Receipt(3, "cappuccino", 200, 100, 12, 6));
    }

    public void status(){
        System.out.println("\nThe coffee machine has:");
        System.out.println(String.format("%d ml of water", water));
        System.out.println(String.format("%d ml of milk", milk));
        System.out.println(String.format("%d g of coffee beans", coffee));
        System.out.println(String.format("%d of disposable cups", cups));
        System.out.println(String.format("$%d of money", money));
    }

    public void processAction() {
        System.out.println("Write action (buy, fill, take): ");
        Scanner scanner = new Scanner(System.in);
        String action = scanner.nextLine();
//        if (action.equalsIgnoreCase("buy")) {
//            processBuy();
//        } else if (action.equalsIgnoreCase("fill")) {
//            processFill();
//        } else if (action.equalsIgnoreCase("take")) {
//            processTake();
//        } else {
//            System.out.println("Unknown command");
//        }
        switch(action){
            case "buy":
                processBuy();
                processAction();
                break;
            case "fill":
                processFill();
                processAction();
                break;
            case "take":
                processTake();
                processAction();
                break;
            case "remaining":
                status();
                processAction();
                break;
            case "exit":
                break;
        }
    }

    void processBuy() {
        System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:");
        Scanner scanner = new Scanner(System.in);
        String choiceBuy = scanner.next();
        int receiptId = 0;
        boolean back = false;
        switch(choiceBuy){
            case "1":
                receiptId = 1;
                break;
            case "2":
                receiptId = 2;
                break;
            case "3":
                receiptId = 3;
                break;
            case "back":
                back = true;
                break;
        }


        if(back){
            return;
        } else {
            makeCoffee(receiptId);
        }
    }

    void processTake() {
        System.out.println(String.format("I gave you $%d", money));
        money = 0;
    }

    void processFill() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Write how many ml of water do you want to add:");
        water += scanner.nextInt();
        System.out.println("Write how many ml of milk do you want to add:");
        milk += scanner.nextInt();
        System.out.println("Write how many grams of coffee beans do you want to add:");
        coffee += scanner.nextInt();
        System.out.println("Write how many disposable cups of coffee do you want to add:");
        cups += scanner.nextInt();
    }

    private void makeCoffee(int receiptId) {
        Receipt receipt =
                receipts
                        .stream()
                        .filter(n -> n.getId() == receiptId)
                        .findFirst().orElseThrow(IllegalArgumentException::new);
        if (water >= receipt.getWater() &&
                milk >= receipt.getMilk() &&
                coffee >= receipt.getCoffee() &&
                cups >= 1) {
            water -= receipt.getWater();
            milk -= receipt.getMilk();
            coffee -= receipt.getCoffee();
            money += receipt.getCost();
            cups -= 1;
            System.out.println("I have enough resources, making you a coffee!");
        } else if(water < receipt.getWater()) {
            System.out.println("Sorry, not enough water!");
        } else if (milk < receipt.getMilk()){
            System.out.println("Sorry, not enough milk!");
        } else if (coffee < receipt.getCoffee()){
            System.out.println("Sorry, not enough coffee!");
        }
    }

}
