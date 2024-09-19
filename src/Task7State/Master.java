package Task7State;

// Concrete state class: Master
public class Master implements Level {
    @Override
    public void train(GameCharacter character) {
        character.increaseExperience(20);
    }

    @Override
    public void meditate(GameCharacter character) {
        character.increaseHealth(20);
    }

    @Override
    public void fight(GameCharacter character) {
        character.increaseExperience(30);
        character.decreaseHealth(10);
    }
}
