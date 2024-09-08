package Task6State;

// Concrete state class: Novice
public class Novice implements Level {
    @Override
    public void train(GameCharacter character) {
        character.increaseExperience(10);
    }

    @Override
    public void meditate(GameCharacter character) {
        System.out.println("Mediating not possible at novice level");
    }

    @Override
    public void fight(GameCharacter character) {
        System.out.println("Fighting not possible at novice level");
    }
}