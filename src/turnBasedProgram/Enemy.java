package turnBasedProgram;

public class Enemy extends Entity{

    private String combatIntro;

    public Enemy() {
        super();
        this.combatIntro = "I'll turn you into cider!";
    }

    public Enemy(String name, int health, int damage, String combatIntro) {
        super(name, health, damage);

        this.combatIntro = combatIntro;
    }

    public String getCombatIntro() {
        return combatIntro;
    }
}
