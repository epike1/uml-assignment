import shapesProgram.*;
import turnBasedProgram.*;
import java.util.concurrent.TimeUnit;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {

    public static void main(String[] args) {

        Player player = new Player();
        Enemy gala = new Enemy();

        new TurnManager(player, gala);

        Enemy cortland = new Enemy("Cortland", 28, 8, "Getting in your way feels very a-peel-ing at the moment.");

        new TurnManager(player, cortland);

        Enemy grannySmith = new Enemy("Granny Smith", 48, 12, "I'll bake you into a delicious apple pie!");

        new TurnManager(player, grannySmith);

        Enemy redDelicious = new Enemy("Red Delicious", 92, 6, "This fight will keep you on your calyx, soon you'll be dead delicious!");

        new TurnManager(player, redDelicious);

        Enemy newtonPippin = new Enemy("Newton Pippin", 56, 18, "The apple doesn't fall far from the tree.");

        new TurnManager(player, newtonPippin);

        System.out.println("You won the game!");
    }
}
