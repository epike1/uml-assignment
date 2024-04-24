package turnBasedProgram;

public class Item {

    private String name;
    private String description;
    private int healthGiven;
    public Item() {
        this.name = "Apple Juice";
        this.description = "Heal 7HP on use.";
        this.healthGiven = 7;
    }

    public Item(String name, String description, int healthGiven) {
        this.name = name;
        this.description = description;
        this.healthGiven = healthGiven;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getHealthGiven() {
        return healthGiven;
    }
}
