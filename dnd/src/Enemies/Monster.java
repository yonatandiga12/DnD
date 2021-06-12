package Enemies;

import Interfaces.InputProvider;
import Interfaces.MessageCallback;
import Interfaces.PlayerDeathCallback;
import Players.Player;
import Position.Position;

import java.util.Random;

public class Monster extends Enemy {

    Random rand;
    public char tile;
    public int experienceValue;
    public int visionRange;
    protected Player player;

    public Monster(String name, char tile, int health, int attack, int defense, int experienceValue, int visionRange, Player player) {
        super(name, tile, health, attack, defense, experienceValue);
        this.visionRange = visionRange;
        this.player = player;
        initialize(position);

    }

    public Enemy initialize(Position position, MessageCallback messageCallback, PlayerDeathCallback deathCallback, InputProvider inputProvider) {
        return super.initialize(position, messageCallback, deathCallback, inputProvider);
    }


    @Override
    public void gameTick() {
        //if(range(this, player)<visionRange){
            int dx = this.getPosition().getX() - player.getPosition().getX();
            int dy = this.getPosition().getY() - player.getPosition().getY();
            if(Math.abs(dx) > Math.abs(dy)){
                if(dx > 0){
                    //MoveLeft();
                } else{
                    //MoveRight();
                } }
            else{
                if(dy > 0){
                    //MoveUp();
                } else{
                    //MoveDown();
                } }
        //}
        //else{
            chooseRandomMovement();
        //}

        //continue here:
        // If the monster founds the player than battle him
        // interact(Tile I am going to)
    }

    private void chooseRandomMovement() {
        switch(rand.nextInt(4)){
            case 0:
                //MoveLeft();
                break;
            case 1:
                //MoveRight();
                break;
            case 2:
                //MoveUp();
                break;
            case 3:
                //MoveDown();
                break;
            case 4:
                //Don'tMove
                break;
        }
    }


    public String describe() {
        return super.describe() + "     " + "Vision Range: " + visionRange;
    }

}
