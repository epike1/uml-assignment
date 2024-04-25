package turnBasedProgram;

import java.util.Scanner;
import java.lang.*;
import java.util.*;
import java.util.concurrent.TimeUnit;
public class TurnManager implements FormatMethods{

    private Enemy enemy;
    private Player player;

    private static final Item[] itemRewards = new Item[] { // list of items that can be rewarded from fights
                new Item(), // creates default item
                new Item("Apple Pie", "Heal 32HP on use.", 32),
                new Item("Apple Tart", "Heal 24HP on use.", 24),
                new Item("Apple Cider", "Heal 24HP on use.", 24),
                new Item("Apple Seed", "Lose 3HP on use.", -3),
                new Item("Pineapple", "Heal 16HP on use.", 16),
                new Item("Candy Apple", "Heal 16HP on use", 16),
                new Item("Apple Skin", "Heal 8HP on use.", 8),
                new Item("Apple Chips", "Heal 8HP on use.", 8),
                new Item("Apple Crisp", "Heal 8HP on use.", 8),
                new Item("Apple Crumble", "Heal 8HP on use.", 8)
    };

    public TurnManager(Player player, Enemy enemy) {
        this.player = player;
        this.enemy = enemy;

        startFight();
    }


    private void startFight() {

        System.out.printf("%s approaches! The apple opens their mouth to speak. '%s'%n%n", enemy.getName(), enemy.getCombatIntro());
        FormatMethods.pauseLine();

        do {

            displayHealth();
            playerTurn();

            if (player.getHealth() <= 0 || enemy.getHealth() <= 0)
                break;

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
        boolean playerAttacked = false;
        do {
            FormatMethods.pauseLine();
            System.out.printf("Your options:%n1. Attack%n2. Use an item%n%n");
            FormatMethods.pauseLine();
            System.out.print("What do you choose? ");

            try {
                choice = input.nextInt();
            } catch (Exception e) {
                System.out.printf("Invalid choice!%n%n");
                input.next();
                continue;
            }

            switch (choice) {
                case 1:
                    playerAttack();
                    playerAttacked = true;
                    break;
                case 2:
                    playerUseItem();
                    break;
                default:
                    System.out.printf("Invalid choice!%n%n");
                    input.next();
                    break;
            }
        } while (!playerAttacked);

    }

    private void playerUseItem() {

        FormatMethods.pauseLine();
        player.displayItems();

        int listSize = player.getItemList().size();

        if (listSize == 0) {

            System.out.printf("No items available!%n%n");
            FormatMethods.pauseLine();

        } else {
            Scanner input = new Scanner(System.in);
            int choice = 0;

            do {
                FormatMethods.pauseLine();

                System.out.printf("%nWhat item do you choose? (0 to go back): ");

                try {
                    choice = input.nextInt();
                } catch (Exception e) {
                    System.out.printf("Invalid choice!%n%n");
                    input.next();
                    continue;
                }

                if (choice == 0) {
                    // blank choice
                } else if (choice >= 1 && choice <= listSize) {
                    player.useItem(choice - 1);
                } else {
                    System.out.printf("Invalid choice!%n%n");
                    continue;
                }

            } while (false);
        }
    }
    private void playerAttack() {
        enemy.calculateHealth(player.getDamage());
    }

    private void enemyAttack() {
        System.out.printf("%n%s attacks!%n", enemy.getName());
        player.calculateHealth(enemy.getDamage());
    }

    private void gameOver() {
        System.out.printf("%nYou lose!");
        System.exit(0);
    }

    private void victory() {
        System.out.printf("%nYou won the fight!%n");
        FormatMethods.pauseLine();
        player.setHealth(player.getMaxHealth());
        System.out.printf("Health fully recovered.%n");

        Random rand = new Random();
        Item chosenItem = itemRewards[rand.nextInt(itemRewards.length)];

        System.out.printf("Item recieved: %s!%n", chosenItem.getName());
        FormatMethods.pauseLine();
        player.addItem(chosenItem);
        player.upgradeStat();
    }

    private void displayHealth() {
        System.out.printf("%s's health: %d%n", player.getName(), player.getHealth());
        FormatMethods.pauseLine();
        System.out.printf("%s's health: %d%n%n", enemy.getName(), enemy.getHealth());
        FormatMethods.pauseLine();
    }
}
