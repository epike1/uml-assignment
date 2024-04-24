package turnBasedProgram;

import java.util.*;

public class Player extends Entity {

    private ArrayList<Item> itemList= new ArrayList<Item>();
    private int maxHealth;
    public Player() {
        super("Honeycrisp", 30, 5);
        maxHealth = getHealth();
    }

    public void setMaxHealth(int maxHealth) {
        this.maxHealth = maxHealth;
    }

    public int getMaxHealth() {
        return maxHealth;
    }

    public void setItemList(ArrayList<Item> itemList) {
        this.itemList = itemList;
    }

    public ArrayList<Item> getItemList() {
        return itemList;
    }
    public void addItem(Item item) {
        itemList.add(item);
        System.out.printf("%s added to inventory.", item.getName());
    }

    public void removeItem(int index) {
        System.out.printf("%s removed from inventory.%n", itemList.get(index).getName());
        itemList.remove(index);
    }
    public void displayItems() {

        for (Item i : itemList) {
            System.out.printf("%s: %s%n", i.getName(), i.getDescription());
        }

    }
    public void useItem(int index) {
        setHealth(getHealth() + itemList.get(index).getHealthGiven());

        if (getHealth() > getMaxHealth()) {
            setHealth(getMaxHealth());
            System.out.printf("%s healed!%n", getName());
        } else if (itemList.get(index).getHealthGiven() < 0){
            System.out.printf("%s was hurt for %s damage!%n", getName(), itemList.get(index).getHealthGiven());
        } else {
            System.out.printf("%s was healed for %s!%n", getName(), itemList.get(index).getHealthGiven());
        }

        removeItem(index);
    }
}
