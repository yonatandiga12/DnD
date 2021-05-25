package Players;

public class Rogue extends Player{

    public int currEnergy;
    public int cost;


    public Rogue(String name, int health, int attack, int defense, int cost) {
        super(name, health, attack, defense);
        this.ability = "Fan of Knives";
        this.currEnergy = 100;
        this.cost = cost;
    }


    @Override
    public void uniquelevelUp() {
        currEnergy = 100;
        setAttack(3 * level);
    }

    @Override
    public void gameTick() {
        currEnergy = Math.min(currEnergy + 10, 100);
    }


    @Override
    public void castAbility() {
        currEnergy -= cost;
        //List enemiesInRange = searchForEnemies(2);
        //for( Enemy enemy : enemiesInRange ) {
        //  they can try to defend themselves
        //  enemy.setHealthPool( -attack );   // Enemy healthAmount is decreased by warrior healthAmount*0.1
        //}
        setHealthPool(10 * defense);
    }


}
