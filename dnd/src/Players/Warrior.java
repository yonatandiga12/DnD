package Players;

import Enemies.Enemy;
import Interfaces.InputProvider;
import Interfaces.MessageCallback;
import Interfaces.PlayerDeathCallback;
import Position.Position;

import java.util.List;
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
        if(remainingCooldown > 0)
            remainingCooldown -= 1;
    }


    @Override
    public void levelUp() {
        int prevAttack = getAttack();
        int prevHealth = getHealthPool();
        int prevDefense = getDefense();
        super.levelUp();
        remainingCooldown = 0;      // remaining cooldown ← 0.
        setHealthPool(5);
        setCurrentHealth();
        setAttack(2 * getLevel());       // attack ← attack + (2 × level)
        setDefense(1 * getLevel());      // defense ← defense + (1 × level)
        messageCallback.send(String.format("%s reached level %d: +%d Health, +%d Attack, +%d Defense",getName(), getLevel(), getHealthPool() - prevHealth, getAttack() - prevAttack, getDefense() - prevDefense ));

    }

    @Override
    public void castAbility() {
        Random rand = new Random();
        if(remainingCooldown == 0) {
            remainingCooldown = coolDown;
            //List<Enemy> enemiesInRange = searchForEnemies(3);
             //if(enemiesInRange.length > 0  ) {
                //Enemy enemy = enemiesInRange.get(rand.nextInt(enemiesInRange.size()));
                //enemy.setHealthAmount( -healthPool * 0.1 );
            //}
            setHealthAmount(10 * defense);
        }
    }


    @Override
    public String describe() {
        return super.describe() + "     " + "Cooldown: " + (remainingCooldown) + "/" + coolDown;
    }


}
