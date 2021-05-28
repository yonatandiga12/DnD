package Tile;

import Position.Position;

public abstract class Tile {

    protected Position position;
    protected char sign;

    public Tile(Position position, char sign){
        this.position = position;
        this.sign = sign;
    }

    public Position getPosition(){
        return position;
    }
}
