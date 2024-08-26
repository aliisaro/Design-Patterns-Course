public interface Tile {
    char getCharacter();
    String getType();
}

class SwampTile implements Tile {
    @Override
    public char getCharacter() {
        return 'S';
    }
    @Override
    public String getType() {
        return "swamp";
    }
}

class WaterTile implements Tile {
    @Override
    public char getCharacter() {
        return 'W';
    }
    @Override
    public String getType() {
        return "water";
    }
}

class RoadTile implements Tile {
    @Override
    public char getCharacter() {
        return 'R';
    }
    @Override
    public String getType() {
        return "road";
    }
}


class ForestTile implements Tile {
    @Override
    public char getCharacter() {
        return 'F';
    }
    @Override
    public String getType() {
        return "forest";
    }
}

class BuildingTile implements Tile {
    @Override
    public char getCharacter() {
        return 'B';
    }
    @Override
    public String getType() {
        return "building";
    }
}
