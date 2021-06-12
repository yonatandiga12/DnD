package Enemies;

import Interfaces.InputProvider;
import Interfaces.MessageCallback;
import Interfaces.PlayerDeathCallback;
import Players.Player;
import Position.Position;

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

    public Enemy initialize(Position position, MessageCallback messageCallback, PlayerDeathCallback deathCallback, InputProvider inputProvider) {
        return super.initialize(position, messageCallback, deathCallback, inputProvider);
    }

    @Override
    public void gameTick() {
        visible = ticksCount < visibilityTime;
        if (ticksCount == (visibilityTime + invisibilityTime))
            ticksCount = 0;
        else {
            ticksCount += 1;
            // Player player = SearchForPlayer(2);
            //if ( player != null )
            //    battle(player);
        }
    }


}
