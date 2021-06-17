package Players;

import Enemies.Enemy;
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

    public void initialize(Position position) {
        super.initialize(position);
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
        setHealthPool(5*level);
        setCurrentHealth();
        setAttack(2 * getLevel());       // attack ← attack + (2 × level)
        setDefense(2 * getLevel());      // defense ← defense + (1 × level)
        messageCallback.send(String.format("%s reached level %d: +%d Health, +%d Attack, +%d Defense",getName(), getLevel(), getHealthPool() - prevHealth, getAttack() - prevAttack, getDefense() - prevDefense ));

    }

    @Override
    public boolean castAbility(List<Enemy> enemies) {
        Random rand = new Random();
        if(remainingCooldown == 0) {
            remainingCooldown = coolDown;
            int currHealth = getHealthAmount();
            setHealthAmount(10 * defense);
            messageCallback.send(String.format("%s used %s, healing for %d.",getName(), ability, getHealthAmount() - currHealth));
            List<Enemy> enemiesInRange = searchForEnemies(3, enemies);
             if(enemiesInRange.size()> 0  ) {
                Enemy enemy = enemiesInRange.get(rand.nextInt(enemiesInRange.size()));
                 int damageDone = Math.max((int) (getHealthPool() * 0.1) - enemy.Defend(), 0);
                 enemy.setHealthAmount(-damageDone);
                 messageCallback.send(String.format("%s hit %s for %d ability damage.",getName(), enemy.getName(), damageDone));
                 if(!enemy.alive()){
                     onKill(enemy);
                 }
            }
             return true;
        }
        return false;
    }


    @Override
    public String describe() {
        return super.describe() + "     " + "Cooldown: " + (remainingCooldown) + "/" + coolDown;
    }


}
