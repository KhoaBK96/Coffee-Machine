package machine;

public class Receipt {
    private int id;
    private String name;
    private int water;
    private int milk;
    private int coffee;
    private int cost;

    public Receipt(int id, String name, int water, int milk, int coffee, int cost){
        this.id = id;
        this.name = name;
        this.water = water;
        this.milk = milk;
        this.coffee = coffee;
        this.cost = cost;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }
}
