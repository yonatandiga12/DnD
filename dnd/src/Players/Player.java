package Players;
import Interfaces.InputProvider;
import Interfaces.MessageCallback;
import Interfaces.PlayerDeathCallback;
import Position.Position;
import Units.Unit;
public abstract class Player extends Unit {

    private PlayerDeathCallback deathCallback;
    private InputProvider inputProvider;
    public int experience = 0;
    public int level = 1;
    public int currentHealth = healthPool;
    public String ability = "";


    public Player(String name, int health, int attack, int defense){
        super('@');
        this.name = name;
        this.healthAmount = health;
        this.attack = attack;
        this.defense = defense;
    }

    public Player initialize(Position position, MessageCallback messageCallback, PlayerDeathCallback deathCallback, InputProvider inputProvider){
        super.initialize(position, messageCallback);
        this.deathCallback = deathCallback;
        this.inputProvider = inputProvider;
        return this;
    }


    public void setExperience(int num) {
        experience += (num);
    }

    public void setLevel() {
        level += 1;
    }

    public void setHealthPool(int num) {
        if (healthPool + (num) <= healthAmount)
            healthPool += (num);
    }

    public void setCurrentHealth() {
        currentHealth = healthPool;
    }

    public void setAttack(int num) {
        attack += (num);
    }

    public void setDefense(int num) {
        defense += (num);
    }

    public abstract void castAbility();

    public void levelUp() {
        setExperience(-50 * level);   // experience ← experience − (50 × level)
        setLevel();
        setHealthPool(10 * level);         // health pool ← health pool + (10 × level)
        setCurrentHealth();               // current health ← health pool
        setAttack(4 * level);              // attack ← attack + (4 × level)
        setDefense(1 * level);             // defense ← defense + (1 × level)
    }

    public abstract void uniquelevelUp();

    public abstract void gameTick();

    public abstract String toString();

    public abstract String describe();



}