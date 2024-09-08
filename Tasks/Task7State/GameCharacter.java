package Task7State;

// This class maintains the current state (level).
public class GameCharacter {
    private String name;
    private Level level; // Use level interface
    private int exp;
    private int health;

    public GameCharacter(String name, Level Initiallevel, int exp, int health) {
        this.name = name;
        this.level = Initiallevel;
        this.exp = exp;
        this.health = health;
    }

    public void displayStatus() {
        System.out.println("\nName: " + name);
        System.out.println("Level: " + level.getClass().getSimpleName());
        System.out.println("Experience: " + exp);
        System.out.println("Health: " + health + "\n");
    }

    public void setLevel(Level level) {
        this.level = level;
    }

    public Level getLevel() {
        return this.level;
    }

    public void train() {
        level.train(this);
    }

    public void meditate() {
        level.meditate(this);
    }

    public void fight() {
        level.fight(this);
    }

    public void increaseHealth(int amount) {
        this.health += amount;
    }

    public void decreaseHealth(int amount) {
        this.health -= amount;
    }

    public void increaseExperience(int amount) {
        this.exp += amount;
        levelUp();
    }

    public void levelUp() {
        // novice to intermediate (50 exp)
        // intermediate to expert (100)
        // expert to master (150)

        if (this.exp >= 50 && this.level instanceof Novice) { //if exp is 50+ AND level is Novice, set a new level
            setLevel(new Intermediate());
        } else if (this.exp >= 150 && this.level instanceof Intermediate) {
            setLevel(new Expert());
        } else if (this.exp >= 500 && this.level instanceof Expert) {
            setLevel(new Master());
        }
    }
}