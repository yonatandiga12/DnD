package Players;

import Enemies.Enemy;
import Interfaces.InputProvider;
import Interfaces.MessageCallback;
import Interfaces.PlayerDeathCallback;
import Position.Position;

import java.util.List;

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
    public void levelUp() {
        int prevAttack = getAttack();
        int prevHealth = getHealthPool();
        int prevDefense = getDefense();
        super.levelUp();
        currEnergy = 100;
        setAttack(3 * getLevel());
        messageCallback.send(String.format("%s reached level %d: +%d Health, +%d Attack, +%d Defense",getName(), getLevel(), getHealthPool() - prevHealth, getAttack() - prevAttack, getDefense() - prevDefense ));

    }

    @Override
    public void gameTick() {
        currEnergy = Math.min(currEnergy + 10, 100);
    }


    @Override
    public void castAbility(List<Enemy> enemies) {
        if(currEnergy < cost)
            return;
        messageCallback.send(String.format("%s cast %s.",getName(), ability));
        //Arya Stark hit Queen's Trap for 174 ability damage.
        currEnergy -= cost;
        List<Enemy> enemiesInRange = searchForEnemies(2, enemies);
        for( Enemy enemy : enemiesInRange ) {
            int damageDone = Math.max(getAttack(), enemy.Defend());
            if (damageDone == getAttack()) {
                enemy.setHealthAmount(-getAttack());
                messageCallback.send(String.format("%s hit %s for %d ability damage.",getName(), enemy.getName(), getAttack()));
                if(!enemy.alive()){
                    onKill(enemy);
                }

            }
        }
    }

    @Override
    public String describe() {
        return super.describe()  + "     " + "Energy: " + currEnergy + "/100";
    }

}
