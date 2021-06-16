package Players;

import Enemies.Enemy;
import Interfaces.InputProvider;
import Interfaces.MessageCallback;
import Interfaces.PlayerDeathCallback;
import Position.Position;

import java.util.List;
import java.util.Random;

public class Mage extends Player {
    public int manaPool;
    public int currentMana;
    public int manaCost;
    public int spellPower;
    public int hitsCount ;
    public int abilityRange;


    public Mage(String name, int health, int attack, int defense,  int manaPool, int manaCost, int spellPower, int hitsCount , int abilityRange){
        super(name, health, attack, defense);
        this.manaPool = manaPool;
        this.currentMana = manaPool / 4;
        this.manaCost = manaCost;
        this.spellPower = spellPower;
        this.hitsCount = hitsCount ;
        this.abilityRange = abilityRange;
        this.ability = "Blizzard";
    }


    public Player initialize(Position position, MessageCallback messageCallback, PlayerDeathCallback deathCallback, InputProvider inputProvider) {
        return super.initialize(position, messageCallback, deathCallback, inputProvider);
    }

    public void gameTick(){
        currentMana = Math.min(manaPool, currentMana + 1 * getLevel()) ;
    }


    @Override
    public boolean castAbility(List<Enemy> enemies) {
        Random rand = new Random();
        if(currentMana < manaCost) {
            //Melisandre tried to cast Blizzard, but there was not enough mana: 9/30.
            messageCallback.send(String.format("%s tried to cast %s, but there was not enough mana: %d/%d.",getName(), ability, manaCost, manaPool));
            return false;
        }
        messageCallback.send(String.format("%s cast %s.",getName(), ability));
        currentMana = currentMana - manaCost;
        int hits = 0;
        List<Enemy> enemiesInRange = searchForEnemies(abilityRange, enemies);
        while (hits < hitsCount  &  enemiesInRange.size() > 0  ) {  // ∧ (∃ living enemy s.t. range(enemy, player) < ability range) do
            Enemy enemy = enemiesInRange.get(rand.nextInt(enemiesInRange.size()));
            int damageDone = Math.max(spellPower, enemy.Defend());
             if (damageDone == spellPower) {
                 enemy.setHealthAmount(-spellPower);
                 messageCallback.send(String.format("%s hit %s for %d ability damage.",getName(), enemy.getName(), spellPower));
             }
             if(!enemy.alive()){
                 onKill(enemy);
            }
            hits += 1;
        }
        return true;

    }

    @Override
    public void levelUp() {
        int prevAttack = getAttack();
        int prevHealth = getHealthPool();
        int prevDefense = getDefense();
        int prevManaPool = manaPool;
        int prevSpell = spellPower;
        super.levelUp();
        manaPool = manaPool + (25 * getLevel());
        currentMana = Math.min(currentMana + manaPool/4, manaPool);
        spellPower = spellPower + (10 * getLevel());
        messageCallback.send(String.format("%s reached level %d: +%d Health, +%d Attack, +%d Defense",getName(), getLevel(), getHealthPool() - prevHealth, getAttack() - prevAttack, getDefense() - prevDefense ));
        //                +50 maximum mana, +20 spell power
        messageCallback.send(String.format("                            +%d maximum mana, +%d spell power", manaPool - prevManaPool, spellPower - prevSpell ));

    }



    @Override
    public String describe() {
        return super.describe()  + "     " + "Mana: " + currentMana + "/" + manaPool + "     " + "Spell Power: " + spellPower;

    }


}
