package Tile;

import Position.Position;
import Units.Unit;

public class Wall extends Tile{

    public Wall(Position position) {
        super( '#');
        this.position = position;
    }

    @Override
    public void accept(Unit u){
        u.visit(this);
    }

    @Override
    public int compareTo(Tile o) {
        return this.position.compareTo(o.getPosition());
    }

}
