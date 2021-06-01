package Tile;

import Interfaces.InputProvider;
import Interfaces.MessageCallback;
import Interfaces.PlayerDeathCallback;
import Players.Player;
import Position.Position;

public class Empty extends Tile{

    private MessageCallback messageCallback;

    public Empty(Position position) {
        super('.');
        this.position = position;
        //initialize(position);
    }

    /*
    protected void initialize(Position position, MessageCallback messageCallback){
        super.initialize(position);
        this.messageCallback = messageCallback;
    }
     */
}
