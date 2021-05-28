package Enemies;

import Position.Position;

public class Monster extends Enemy {

    public char tile;
    public int experienceValue;
    public int visionRange;

    public Monster(String name, char tile, int health, int attack, int defense, int experienceValue, Position position, int visionRange) {
        super(name, tile, health, attack, defense, experienceValue, position);
        this.visionRange = visionRange;

    }

    @Override
    public void gameTick() {

    }

    @Override
    public String toString() {
        return name;
    }
}
