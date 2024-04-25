package turnBasedProgram;

import java.util.*;

public class Player extends Entity implements FormatMethods {

    private ArrayList<Item> itemList= new ArrayList<Item>();
    private int maxHealth;
    private double critChance;
    public Player() {
        super("Honeycrisp", 30, 5);
        maxHealth = getHealth();
    }

    public double getCritChance() {
        return critChance;
    }

    public void setCritChance(double critChance) {
        this.critChance = critChance;
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
        System.out.printf("%s added to inventory.%n", item.getName());
        FormatMethods.pauseLine();
    }

    public void removeItem(int index) {
        System.out.printf("%s removed from inventory.%n", itemList.get(index).getName());
        FormatMethods.pauseLine();
        itemList.remove(index);
    }
    public void displayItems() {

        for (Item i : itemList) {
            System.out.printf("%s: %s%n", i.getName(), i.getDescription());
            FormatMethods.pauseLine();
        }

    }
    public void useItem(int index) {
        setHealth(getHealth() + itemList.get(index).getHealthGiven());

        if (getHealth() > getMaxHealth()) {
            setHealth(getMaxHealth());
            System.out.printf("%s healed!%n", getName());
            FormatMethods.pauseLine();
        } else if (itemList.get(index).getHealthGiven() < 0){
            System.out.printf("%s was hurt for %s damage!%n", getName(), Math.abs(itemList.get(index).getHealthGiven()));
            FormatMethods.pauseLine();
        } else {
            System.out.printf("%s was healed to %s!%n", getName(), getHealth());
            FormatMethods.pauseLine();
        }

        removeItem(index);
    }

    public boolean upgradeStat() {

        Scanner input = new Scanner(System.in);
        int choice = 0;
        boolean choiceChosen = false;

        System.out.printf("%nWould you like to increase your health by 16, damage by 4, double your chance to get a critical hit, or duplicate the item you received?");

        do {
            FormatMethods.pauseLine();
            System.out.printf("%n1. Health%n2. Damage%n3. Crit Chance%n4. Duplicate Item%n");
            FormatMethods.pauseLine();
            System.out.printf("%nYour choice: ");

            try {
                choice = input.nextInt();
            } catch (Exception e) {
                System.out.printf("Invalid choice!%n");
                input.next();
                continue;
            }

            switch (choice) {
                case 1:
                    setMaxHealth(getMaxHealth() + 16);
                    setHealth(getMaxHealth());
                    System.out.printf("Health increased to %d!%n", getMaxHealth());
                    choiceChosen = true;
                    break;
                case 2:
                    setDamage(getDamage() + 4);
                    System.out.printf("Damage increased to %d!%n", getDamage());
                    choiceChosen = true;
                    break;
                    case 3:
                    setCritChance(getCritChance() * 10);
                    System.out.printf("Crit Chance increased to %d%%!%n", (int)(getCritChance() * 100));
                    choiceChosen = true;
                    break;
                case 4:
                    return true;
                default:
                    System.out.printf("Invalid choice!%n");
                    break;
            }

        } while(!choiceChosen);

        return false;
    }
}
