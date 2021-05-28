package Players;

import Position.Position;

import java.util.Random;

public class Mage extends Player {
    //TTTTest GGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGgggit
    public int manaPool;
    public int currentMana;
    public int manaCost;
    public int spellPower;
    public int hitsCount ;
    public int abilityRange;


    public Mage(String name, int health, int attack, int defense, Position position,  int manaPool, int manaCost, int spellPower, int hitsCount , int abilityRange){
        super(name, health, attack, defense, position);
        this.manaPool = manaPool;
        this.currentMana = manaPool / 4;
        this.manaCost = manaCost;
        this.spellPower = spellPower;
        this.hitsCount = hitsCount ;
        this.abilityRange = abilityRange;
        this.ability = "Blizzard";
    }




    public void gameTick(){
        currentMana = Math.min(manaPool, currentMana + 1 * level) ;
    }


    @Override
    public void castAbility() {
        Random rand = new Random();
        currentMana = currentMana - manaCost;
        int hits = 0;
        //List enemiesInRange = searchForEnemies(abilityRange);
        while (hits < hitsCount /* &  enemiesInRange.length > 0 */ ) {  // ∧ (∃ living enemy s.t. range(enemy, player) < ability range) do
            //Enemy enemy = enemiesInRange.get(rand.nextInt(enemiesInRange.size()));
            //(each enemy may try to defend itself).
            //enemy.setHealthPool( -spellPower );
            hits += 1;
        }

    }

    @Override
    public void uniquelevelUp() {
        manaPool = manaPool + (25 * level);
        currentMana = Math.min(currentMana + manaPool/4, manaPool);
        spellPower = spellPower + (10 * level);

    }

    @Override
    public String toString() {
        return name;
    }


}
