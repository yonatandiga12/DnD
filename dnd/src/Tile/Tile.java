package Tile;

import Position.Position;

public abstract class Tile {

    protected Position position;
    protected char sign;

    public Tile(char sign){
        this.sign = sign;
    }

    protected void initialize(Position position){
        this.position = position;
    }

    public Position getPosition(){
        return position;
    }

    public char toChar() {
        return sign;
    }
}
