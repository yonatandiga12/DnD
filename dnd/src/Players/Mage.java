package Players;

public class Mage extends Player {

    public int manaPool;
    public int currentMana;
    public int manaCost;
    public int spellPower;
    public int maxHits;
    public int abilityrange;


    public Mage(String name, int health, int attack, int defense, int manaPool, int manaCost, int spellPower, int maxHits, int abilityRange){
        super(name, health, attack, defense);
        this.manaPool = manaPool;
        this.currentMana = manaPool / 4;
        this.manaCost = manaCost;
        this.spellPower = spellPower;
        this.maxHits = maxHits;
        this.abilityrange = abilityRange;
    }




    public void gameTick(){
        currentMana = Math.min(manaPool, currentMana + 1 * level) ;
    }


    @Override
    public void castAbility() {
        //current mana ← current mana − cost
        //hits ← 0
        //while (hits < hits count) ∧ (∃ living enemy s.t. range(enemy, player) < ability range) do
        //    - Select random enemy within ability range.
        //        - Deal damage (reduce health value) to the chosen enemy for an amount equal to spell power
        //(each enemy may try to defend itself).
        //- hits ← hits + 1

    }

    @Override
    public void uniquelevelUp() {
        manaPool = manaPool + (25 * level);
        currentMana = Math.min(currentMana + manaPool/4, manaPool);
        spellPower = spellPower + (10 * level);

    }
}
