package Enemies;

import Interfaces.InputProvider;
import Interfaces.MessageCallback;
import Interfaces.PlayerDeathCallback;
import Players.Player;
import Position.Position;

public class Monster extends Enemy {

    public char tile;
    public int experienceValue;
    public int visionRange;

    public Monster(String name, char tile, int health, int attack, int defense, int experienceValue, int visionRange) {
        super(name, tile, health, attack, defense, experienceValue);
        this.visionRange = visionRange;
        initialize(position);

    }

    public Enemy initialize(Position position, MessageCallback messageCallback, PlayerDeathCallback deathCallback, InputProvider inputProvider) {
        return super.initialize(position, messageCallback, deathCallback, inputProvider);
    }

    @Override
    public void gameTick() {

    }


    public String describe() {
        return super.describe() + "     " + "Vision Range: " + visionRange;
    }

}
