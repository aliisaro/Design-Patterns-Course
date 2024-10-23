package Task11Memento;

public interface IMemento {
    // memento metadata methods

    String getSavedTime(); // new code: Method to retrieve the time when the memento was created
    String getDescription(); // new code: Method to retrieve a description of the memento
}