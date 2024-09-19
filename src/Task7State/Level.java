package Task7State;

// State interface
public interface Level {
    void train(GameCharacter character);
    void meditate(GameCharacter character);
    void fight(GameCharacter character);
}
