package Players;

import Interfaces.InputProvider;
import Interfaces.MessageCallback;
import Interfaces.PlayerDeathCallback;
import Position.Position;

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
    public void castAbility() {
        Random rand = new Random();
        currentMana = currentMana - manaCost;
        int hits = 0;
        // Where do I get the list of enemies from the board
        //List enemiesInRange = searchForEnemies(abilityRange);
        while (hits < hitsCount /* &  enemiesInRange.length > 0 */ ) {  // ∧ (∃ living enemy s.t. range(enemy, player) < ability range) do
            //Enemy enemy = enemiesInRange.get(rand.nextInt(enemiesInRange.size()));
            //int damageDone = Math.max(spellPower, u.Defend());
            // if (damageDone == spellPower)
                //enemy.setHealthPool( -spellPower );
            hits += 1;
        }

    }

    @Override
    public void levelUp() {
        super.levelUp();
        manaPool = manaPool + (25 * getLevel());
        currentMana = Math.min(currentMana + manaPool/4, manaPool);
        spellPower = spellPower + (10 * getLevel());

    }



    @Override
    public String describe() {
        return super.describe()  + "     " + "Mana: " + currentMana + "/" + manaPool + "     " + "Spell Power: " + spellPower;

    }


}
