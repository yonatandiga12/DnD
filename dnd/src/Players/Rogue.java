package Players;

import Interfaces.InputProvider;
import Interfaces.MessageCallback;
import Interfaces.PlayerDeathCallback;
import Position.Position;

public class Rogue extends Player{

    public int currEnergy;
    public int cost;


    public Rogue(String name, int health, int attack, int defense,  int cost) {
        super(name, health, attack, defense);
        this.ability = "Fan of Knives";
        this.currEnergy = 100;
        this.cost = cost;
    }

    public Player initialize(Position position, MessageCallback messageCallback, PlayerDeathCallback deathCallback, InputProvider inputProvider) {
        return super.initialize(position, messageCallback, deathCallback, inputProvider);
    }


    @Override
    public void uniquelevelUp() {
        currEnergy = 100;
        setAttack(3 * level);
    }

    @Override
    public void gameTick() {
        currEnergy = Math.min(currEnergy + 10, 100);
    }


    @Override
    public void castAbility() {
        currEnergy -= cost;
        //List enemiesInRange = searchForEnemies(2);
        //for( Enemy enemy : enemiesInRange ) {
        //  they can try to defend themselves
        //  enemy.setHealthPool( -attack );   // Enemy healthAmount is decreased by warrior healthAmount*0.1
        //}
        setHealthAmount(10 * defense);
    }

    @Override
    public String describe() {
        return super.describe()  + "     " + "Energy: " + currEnergy + "/100";
    }

}
