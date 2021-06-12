package Tile;

import Interfaces.InputProvider;
import Interfaces.MessageCallback;
import Interfaces.PlayerDeathCallback;
import Players.Player;
import Position.Position;
import Units.Unit;

public class Empty extends Tile{

    private MessageCallback messageCallback;

    public Empty(Position position) {
        super('.');
        this.position = position;
        //initialize(position);
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

    /*
    protected void initialize(Position position, MessageCallback messageCallback){
        super.initialize(position);
        this.messageCallback = messageCallback;
    }
     */
}
