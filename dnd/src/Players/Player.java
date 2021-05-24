package Players;
import Units.Unit;
public abstract class Player extends Unit {

    public int experience = 0;
    public int level = 1;
    public int currentHealth = healthPool;
    public String ability = "";


    public void setExperience() {
        experience = experience - (50 * level);
    }

    public void setLevel() {
        level += 1;
    }

    public void setHealthPool() {
        healthPool = healthPool + (10 * level);
    }

    public void setCurrentHealth() {
        currentHealth = healthPool;
    }

    public void setAttack() {
        attack = attack + ( 4 * level);
    }

    public void setDefense() {
        defense = defense + (1 * level);
    }

    public abstract void castAbility();


}
