package Players;

public class Warrior extends Player{

    public int coolDown;
    public int remainingCooldown;


    public Warrior (String name, int health, int attack, int defense, int cooldown){
        super(name, health, attack, defense);
        this.coolDown = cooldown;
        this.remainingCooldown = cooldown;
        this.ability = "Avenger’s Shield";
    }

    public void gameTick(){
        remainingCooldown -= 1;
    }

    @Override
    public void uniquelevelUp() {
        remainingCooldown = 0;      // remaining cooldown ← 0.
        setHealthPool(5 * level);   // health pool ← health pool + (5 × level)
        setAttack(2 * level);       // attack ← attack + (2 × level)
        setDefense(1 * level);      // defense ← defense + (1 × level)
    }

    @Override
    public void castAbility() {
        //????????????The warrior’s ability has a cooldown, meaning it can only be used once every ability cooldown game ticks.
        if(remainingCooldown == 0) {
            remainingCooldown = coolDown;
            //Enemy randomEnemy = searchforenemis();
            //if(randomEnemt != null) {
                //randomEnemy.setHealthPool(healthAmount * -0.1);   // Enemy healthAmount is decreased by warrior healthAmount*0.1
            //}
            setHealthPool(10 * defense);
        }
    }
}
