package turnBasedProgram;

import java.util.Scanner;
import java.lang.*;
import java.util.*;
public class TurnManager {

    private Enemy enemy;
    private Player player;

    private static final Item[] itemRewards = new Item[] { // list of items that can be rewarded from fights
        new Item(), // creates default item
                new Item("Apple Pie", "Heal 15HP on use.", 15),
                new Item("Apple Tart", "Heal 7HP on use.", 7),
                new Item("Apple Cider", "Heal 7HP on use.", 7),
                new Item("Apple Seed", "Lose 3HP on use.", -3),
                new Item("Pineapple", "Heal 12HP on use.", 12),
                new Item("Candy Apple", "Heal 12HP on use", 12),
                new Item("Apple Skin", "Heal 4HP on use.", 4),
                new Item("Apple Chips", "Heal 4HP on use.", 4),
                new Item("Apple Crisp", "Heal 4HP on use.", 4),
                new Item("Apple Crumble", "Heal 4HP on use.", 4)
    };

    public TurnManager(Player player, Enemy enemy) {
        this.player = player;
        this.enemy = enemy;

        startFight();
    }

    private void startFight() {

        System.out.printf("%s approaches! The apple opens their mouth to speak. '%s'%n%n", enemy.getName(), enemy.getCombatIntro());
        do {

            displayHealth();
            playerTurn();
            enemyAttack();
        } while (player.getHealth() > 0 && enemy.getHealth() > 0);

        if (player.getHealth() > 0) {
            victory();
        } else {
            gameOver();
        }
    }

    private void playerTurn() {
        System.out.printf("It is %s's turn!%n", player.getName());
        Scanner input = new Scanner(System.in);
        int choice = 0;
        do {
            System.out.printf("Your options:%n1. Attack%n2. Use an item%n%n");
            System.out.print("What do you choose? ");

            try {
                choice = input.nextInt();
            } catch (Exception e) {
                System.out.printf("Invalid choice!%n%n");
                continue;
            }

            switch (choice) {
                case 1:
                    playerAttack();
                    break;
                case 2:
                    playerUseItem();
                    break;
                default:
                    System.out.printf("Invalid choice!%n%n");
                    input.next();
                    continue;
            }
        } while (false);

    }

    private void playerUseItem() {

        player.displayItems();

        int listSize = player.getItemList().size();

        if (listSize == 0) {
            System.out.printf("No items available!%n%n");
            playerTurn();
        }
        Scanner input = new Scanner(System.in);
        int choice = 0;

        do {
            System.out.print("What item do you choose? (0 to go back): ");

            try {
                choice = input.nextInt();
            } catch (Exception e) {
                System.out.printf("Invalid choice!%n%n");
                input.next();
                continue;
            }

            if (choice == 0) {
                playerTurn();
            } else if (choice >= 1 && choice <= listSize) {
                player.useItem(choice - 1);
            } else {
                System.out.printf("Invalid choice!%n%n");
                continue;
            }

        } while (false);
    }
    private void playerAttack() {
        enemy.calculateHealth(player.getDamage());
    }

    private void enemyAttack() {
        player.calculateHealth(enemy.getDamage());
    }

    private void gameOver() {
        System.out.printf("You lose!");
    }

    private void victory() {
        System.out.printf("You won the fight!%n");

        Random rand = new Random();
        Item chosenItem = itemRewards[rand.nextInt(itemRewards.length)];

        System.out.printf("Item recieved: %s!%n", chosenItem.getName());
        player.addItem(chosenItem);
    }

    private void displayHealth() {
        System.out.printf("%s's health: %d%n", player.getName(), player.getHealth());
        System.out.printf("%s's health: %d%n%n", enemy.getName(), enemy.getHealth());
    }
}