package Enemies;

import Players.Player;
import Position.Position;
import Tile.Tile;

import java.util.Dictionary;

public class Trap extends Enemy{

    public int visibilityTime;
    public int invisibilityTime;
    public int ticksCount = 0;
    public boolean visible = true;
    protected Player player;

    public Trap(String name, char tile, int health, int attack, int defense, int experienceValue,  int visibilityTime, int invisibilityTime, Player player) {
        super(name, tile, health, attack, defense, experienceValue);
        this.visibilityTime = visibilityTime;
        this.invisibilityTime = invisibilityTime;
        this.player = player;
        initialize(position);
    }

    public void initialize(Position position) {
        super.initialize(position);
    }

    @Override
    public void gameTick() {
        visible = ticksCount < visibilityTime;
        if (ticksCount == (visibilityTime + invisibilityTime))
            ticksCount = 0;
        else {
            ticksCount += 1;
            if(getPosition().getRange(player.getPosition(), getPosition()) < 2)
                visit(player);
        }
    }

    @Override
    public char toChar(){
        if(visible)
            return sign;
        else
            return '.';
    }


    @Override
    public Tile ChooseAction(Dictionary<String, Tile> surroundingTiles) {
        gameTick();
        return null;
    }


}
