package Enemies;

import Players.Player;
import Position.Position;
import Tile.Tile;

import java.util.Dictionary;
import java.util.Random;

public class Monster extends Enemy {

    Random rand = new Random();
    public char tile;
    public int visionRange;
    protected Player player;

    public Monster(String name, char tile, int health, int attack, int defense, int experienceValue, int visionRange, Player player) {
        super(name, tile, health, attack, defense, experienceValue);
        this.visionRange = visionRange;
        this.player = player;
        initialize(position);

    }

    public void initialize(Position position) {
        super.initialize(position);
    }


    @Override
    public void gameTick() {

    }

    private Tile chooseRandomMovement(Dictionary<String, Tile> surroundingTiles) {
        Tile t;
        switch (rand.nextInt(4)) {
            case 0:
                t = surroundingTiles.get("Left");
                break;
            case 1:
                t = surroundingTiles.get("Right");
                break;
            case 2:
                t = surroundingTiles.get("Up");
                break;
            case 3:
                t = surroundingTiles.get("Down");
                break;
            case 4:
                t = this;
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + rand.nextInt(4));
        }
        return t;
    }


    public String describe() {
        return super.describe() + "     " + "Vision Range: " + visionRange;
    }

    @Override
    public Tile ChooseAction(Dictionary<String, Tile> surroundingTiles) {
        if (position.getRange(getPosition(), player.getPosition()) < visionRange) {
            int dx = this.getPosition().getX() - player.getPosition().getX();
            int dy = this.getPosition().getY() - player.getPosition().getY();
            if (Math.abs(dx) > Math.abs(dy)) {
                if (dx > 0) {
                    return surroundingTiles.get("Left");
                }
                else {
                    return surroundingTiles.get("Right");
                }
            }
            else {
                if (dy > 0) {
                    return surroundingTiles.get("Up");
                }
                else {
                    return surroundingTiles.get("Down");
                }
            }
        }
        else {
            return chooseRandomMovement(surroundingTiles);
        }
    }


}
