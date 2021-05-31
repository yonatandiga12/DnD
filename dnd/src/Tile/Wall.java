package Tile;

import Interfaces.MessageCallback;
import Position.Position;

public class Wall extends Tile{

    private MessageCallback messageCallback;

    public Wall(Position position) {
        super( '#');
        initialize(position);
    }

    protected void initialize(Position position, MessageCallback messageCallback){
        super.initialize(position);
        this.messageCallback = messageCallback;
    }
}
