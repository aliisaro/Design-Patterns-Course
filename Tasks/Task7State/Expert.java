package Task7State;

// Concrete state class: Expert
public class Expert implements Level {
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
        character.increaseExperience(30);
        character.decreaseHealth(20);
    }
}
