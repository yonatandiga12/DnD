package Tile;

import Position.Position;
import Units.Unit;

public abstract class Tile implements Comparable<Tile> {

    protected Position position;
    protected char sign;
    protected char backupSign;


    public Tile(char sign){
        this.sign = sign;
        this.backupSign = sign;
    }

    protected void initialize(Position position){
        this.position = position;
    }

    public Position getPosition(){
        return position;
    }

    public void setPosition(Position position){
        this.position = position;
    }

    public char toChar() {
        return sign;
    }

    public abstract void accept(Unit unit);

    @Override
    public int compareTo(Tile tile) {
        return getPosition().compareTo(tile.getPosition());
    }
}
