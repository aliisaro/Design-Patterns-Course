interface Tile {
    char getCharacter();   // Returns the character representing the tile
    String getType();      // Returns the type of the tile (e.g., "swamp", "road")
    public void action();  // Unused in this task, but part of the interface
}

class SwampTile implements Tile {
    public char getCharacter() {
        return 'S';
    }

    public String getType() {
        return "swamp";
    }

    public void action() {
        // No action needed for now
    }
}

class WaterTile implements Tile {
    public char getCharacter() {
        return 'W';
    }

    public String getType() {
        return "water";
    }

    public void action() {
        // No action needed for now
    }
}

class RoadTile implements Tile {
    public char getCharacter() {
        return 'R';
    }

    public String getType() {
        return "road";
    }

    public void action() {
        // No action needed for now
    }
}

class ForestTile implements Tile {
    public char getCharacter() {
        return 'F';
    }

    public String getType() {
        return "forest";
    }

    public void action() {
        // No action needed for now
    }
}

class BuildingTile implements Tile {
    public char getCharacter() {
        return 'B';
    }

    public String getType() {
        return "building";
    }

    public void action() {
        // No action needed for now
    }
}
