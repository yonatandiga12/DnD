package Tile;

import Position.Position;
import Units.Unit;

public class Empty extends Tile{


    public Empty(Position position) {
        super('.');
        this.position = position;
    }


    //only When player dies
    public Empty(Position position, char Sign) {
        super(Sign);
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
