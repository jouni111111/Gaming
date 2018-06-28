package newGame;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private String name;
    private int health = 100;
    private int hungerLevel = 1;
    private int coffeeLevel = 100;
    private int relaxationLevel;
    private List<Item> inventory = new ArrayList<>();
    private int maxInventorySize = 2;

    public Player (String name) {
        this.name = name;
    }

    public Player (String name, int health) {
        this.name = name;
        this.health = health;
    }

    public Player (String name, int health, ArrayList<Item> stuffWhenStarting) {
        this.name = name;
        this.health = health;
        this.inventory = stuffWhenStarting;
    }

    public Player (String name, int health, int coffeelevel) {
        this.name = name;
        this.health = health;
        this.coffeeLevel = coffeelevel;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getHungerLevel() {
        return hungerLevel;
    }

    public void setHungerLevel(int hungerLevel) {
        this.hungerLevel = hungerLevel;
    }

    public void increaseHungerLevel() {
        this.hungerLevel ++;
    }

    public int getCoffeeLevel() {
        return coffeeLevel;
    }

    public void setCoffeeLevel(int coffeeLevel) {
        this.coffeeLevel = coffeeLevel;
    }

    public int getRelaxationLevel() {
        return relaxationLevel;
    }

    public void setRelaxationLevel(int relaxationLevel) {
        this.relaxationLevel = relaxationLevel;
    }

    public List<Item> getInventory() {
        return inventory;
    }

    public void setInventory(List<Item> inventory) {
        this.inventory = inventory;
    }

    public void addItemToInventory(Item item){
        if (item.isMovable()) {
            inventory.add(item);
        }
    }



    @Override
    public String toString() {
        return name;
    }
}
