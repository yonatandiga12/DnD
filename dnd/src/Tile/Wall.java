package Tile;

import Interfaces.MessageCallback;
import Position.Position;
import Units.Unit;

public class Wall extends Tile{

    private MessageCallback messageCallback;

    public Wall(Position position) {
        super( '#');
        this.position = position;
        //initialize(position);
    }

    @Override
    public void accept(Unit u){
        u.visit(this);
    }


    /*
    protected void initialize(Position position, MessageCallback messageCallback){
        super.initialize(position);
        this.messageCallback = messageCallback;
    }

     */
}
