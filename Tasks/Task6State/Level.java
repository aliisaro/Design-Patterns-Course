package Task6State;

// State interface
public interface Level {
    void train(GameCharacter character);
    void meditate(GameCharacter character);
    void fight(GameCharacter character);
}
