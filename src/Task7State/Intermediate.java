package Task7State;

// Concrete state class: Intermediate
public class Intermediate implements Level {
    @Override
    public void train(GameCharacter character) {
        character.increaseExperience(10);
    }

    @Override
    public void meditate(GameCharacter character) {
        character.increaseHealth(10);
    }

    @Override
    public void fight(GameCharacter character) {
        System.out.println("Fighting not possible at intermediate level");
    }
}
