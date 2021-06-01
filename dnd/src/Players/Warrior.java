package Players;

import Interfaces.InputProvider;
import Interfaces.MessageCallback;
import Interfaces.PlayerDeathCallback;
import Position.Position;

import java.util.Random;

public class Warrior extends Player{

    public int coolDown;
    public int remainingCooldown;


    public Warrior (String name, int health, int attack, int defense,  int cooldown){
        super(name, health, attack, defense);
        this.coolDown = cooldown;
        this.remainingCooldown = cooldown;
        this.ability = "Avenger’s Shield";
    }

    public Player initialize(Position position, MessageCallback messageCallback, PlayerDeathCallback deathCallback, InputProvider inputProvider) {
        return super.initialize(position, messageCallback, deathCallback, inputProvider);
    }

    public void gameTick(){
        remainingCooldown -= 1;
    }


    @Override
    public void uniquelevelUp() {
        remainingCooldown = 0;      // remaining cooldown ← 0.
        setHealthAmount(5 * level);   // health pool ← health pool + (5 × level)
        setAttack(2 * level);       // attack ← attack + (2 × level)
        setDefense(1 * level);      // defense ← defense + (1 × level)
       //inner();
    }

    @Override
    public void castAbility() {
        //????????????The warrior’s ability has a cooldown, meaning it can only be used once every ability cooldown game ticks.
        Random rand = new Random();
        if(remainingCooldown == 0) {
            remainingCooldown = coolDown;
            //List enemiesInRange = searchForEnemies(abilityRange);
            /* if(enemiesInRange.length > 0  ) {  */
                //Enemy enemy = enemiesInRange.get(rand.nextInt(enemiesInRange.size()));
                //enemy may try to defend itself).
                //enemy.setHealthAmount( -healthPool * 0.1 );
            //}
            setHealthAmount(10 * defense);
        }
    }


    @Override
    public String describe() {
        return super.describe() + "     " + "Cooldown: " + (coolDown - remainingCooldown) + "/" + coolDown;
    }


}
