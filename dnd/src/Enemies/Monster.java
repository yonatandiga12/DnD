package Enemies;

public class Monster extends Enemy {

    public char tile;
    public int experienceValue;
    public int visionRange;

    public Monster(String name, char tile, int health, int attack, int defense, int experienceValue, int visionRange) {
        super(name, tile, health, attack, defense, experienceValue);
        this.visionRange = visionRange;

    }

    @Override
    public void gameTick() {

    }
}
