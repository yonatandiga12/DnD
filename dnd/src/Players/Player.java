package Players;
import Enemies.Enemy;
import Interfaces.EnemyDeathCallback;
import Interfaces.InputProvider;
import Interfaces.MessageCallback;
import Interfaces.PlayerDeathCallback;
import Position.Position;
import Tile.Tile;
import Units.Unit;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public abstract class Player extends Unit {

    private PlayerDeathCallback deathCallback;
    private InputProvider inputProvider;
    public int experience = 0;
    public int level = 1;
    protected int experienceCapacity = level * 50;
    //public int healthAmount;
    public String ability;


    public Player(String name, int health, int attack, int defense){
        super('@',name , health , attack, defense, 0);

    }

    public Player initialize(Position position, MessageCallback messageCallback, PlayerDeathCallback deathCallback, InputProvider inputProvider){
        super.initialize(position, messageCallback);
        //this.deathCallback = deathCallback;
        //this.inputProvider = inputProvider;
        return this;
    }


    public void setExperience(int num) {
        super.setExperience(num);
        if(getExperience() >= experienceCapacity){
            this.levelUp();
        }
    }
    private void setExperienceAfterKill(int experienceGained) {
        //int currExperience;
        while(experienceGained >= experienceCapacity - getExperience()){
            int experienceDiff = Math.min(experienceCapacity - getExperience(), experienceGained);
            setExperience(experienceDiff);
            experienceGained -= experienceDiff;
        }
        setExperience(experienceGained);
    }
    public int getLevel() {
        return level;
    }
    public void setLevel() {
        level += 1;
    }

    public void setExperienceCapacity(){
        experienceCapacity = level* 50;
    }



    public abstract boolean castAbility(List<Enemy> enemies);

    public void levelUp() {
        setExperience(-getExperience());   // experience ← experience − (50 × level)
        setLevel();
        setExperienceCapacity();
        setHealthPool(10 * getLevel());
        setCurrentHealth();               // current health ← health pool
        setAttack(4 * getLevel());              // attack ← attack + (4 × level)
        setDefense(1 * getLevel());             // defense ← defense + (1 × level)
    }

    public abstract void gameTick();

    @Override
    public void accept(Unit u){
        u.visit(this);
    }

    public String describe() {
        return super.describe() + "     " + "Level: " + level  + "     " + "Experience: " + getExperience() + "/" + experienceCapacity;
    }

    @Override
    public void visit(Enemy e){
        super.battle(e);
        if(!e.alive()){
            swapPostions(e);
            onKill(e);
        }
    }

    protected void onKill(Enemy e) {
        int experienceGained = e.getExperience();
        messageCallback.send(String.format("%s died. %s gained %d experience.", e.getName(), getName(), experienceGained));
        setExperienceAfterKill(experienceGained);
        e.onDeath();
    }



    @Override
    public void onDeath() {
        messageCallback.send("You Lost.");
        deathCallback.call();
    }

    public void setDeathCallback(PlayerDeathCallback pdc){
        this.deathCallback= pdc;
    }

    public void setMessageCallBack(MessageCallback m){
        this.messageCallback = m;
    }


    @Override
    public void visit(Player p){
        // do nothing cant be 2 players in the game
    }

    /**
     This method returns a list of all the units close by.
     **/
    public List<Enemy> searchForEnemies(int range, List<Enemy> enemiesList){

        Stream<Enemy> output = enemiesList.stream().filter((u) -> getPosition().getRange(u.getPosition(), getPosition()) <= range );
        //List<Enemy> enemies = output.collect(Collectors.toList());

        return output.collect(Collectors.toList());
    }

}