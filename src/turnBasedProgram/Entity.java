package turnBasedProgram;

import java.lang.Math.*;
public class Entity {

    private String name;
    private int health;
    private int damage;

    public Entity() {
        this.name = "Gala";
        this.health = 15;
        this.damage = 3;
    }

    public Entity(String name, int health, int damage) {
        this.name = name;
        this.health = health;
        this.damage = damage;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
    public void setHealth(int health) {
        this.health = health;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getHealth() {
        return health;
    }

    public int getDamage() {
        return damage;
    }

    public boolean getCritical() { // small chance to deal double damage.

        int rand = (int)(Math.random() * 10) + 1;

        return rand == 1;
    }

    public void calculateHealth(int damageTaken) {

        if (getCritical()) {
            damageTaken *= 2;
            System.out.printf("Critical hit!%n");
            FormatMethods.pauseLine();
        }

        health -= damageTaken;

        System.out.println(name + " was hit for " + damageTaken + " damage!");
        FormatMethods.pauseLine();
    }
}
