package Units;

import Enemies.Enemy;
import Interfaces.MessageCallback;
import Players.Player;
import Position.Position;
import Tile.*;

import java.util.Random;

public abstract class Unit extends Tile {
    Random r = new Random();
    public String name;
    public int healthPool;
    public int healthAmount;
    public int attack;
    public int defense;
    public int experience;
    private MessageCallback messageCallback;


    public Unit( char sign, String name, int health, int attack, int defense, int experience) {
        super(sign);
        this.name = name;
        this.healthPool = health;
        this.healthAmount = health;
        this.attack = attack;
        this.defense = defense;
        this.experience = experience;
    }

    protected void initialize(Position position, MessageCallback messageCallback){
        super.initialize(position);
        this.messageCallback = messageCallback;
    }

    public void interact(Tile tile){
        tile.accept(this);
        // need to do accept in wall enemy Unit
    }

    public void visit(Empty e){
        swapPostions(e);
    }



    public void visit(Wall w){
        //do nothing
    }
    public abstract void visit(Player p);
    public abstract void visit(Enemy e);


    protected void battle(Unit u){
        messageCallback.send(String.format("%s engaged in combat with %s.\n%s \n%s", getName(), u.getName(),describe, u.describe ));
        int damageDone = Math.max(Attack() - u.Defend(), 0);
        u.setHealthAmount(-damageDone);
        messageCallback.send(String.format("%s dealt %d damage to %s",getName(), damageDone, u.getName()));
    }

    private int Defend() {
        int result = r.nextInt(defense);
        messageCallback.send(String.format("%s rolled %d defense points.",getName(), result));
        return result;
    }

    private int Attack() {
        int result = r.nextInt(attack);
        messageCallback.send(String.format("%s rolled %d attack points.",getName(), result));
        return result;
    }


    // Getter
    public String getName(){
        return name;
    }

    // Getter
    public int getHealthPool(){
        return healthPool;
    }

    // Getter
    public int getHealthAmount(){
        return healthAmount;
    }

    // Getter
    public int getAttack(){
        return attack;
    }

    // Getter
    public int getDefense(){
        return defense;
    }



    public void setAttack(int num) {
        attack += (num);
    }

    public void setDefense(int num) {
        defense += (num);
    }


    public void setHealthAmount(int num) {
        if (healthAmount + (num) <= healthPool)
            healthAmount += (num);
        healthAmount = Math.max(healthAmount, 0);
    }





    public String toString() {
        return name;
    }


    private void swapPostions(Tile tile) {
        Position p = tile.getPosition();
        tile.setPosition(this.getPosition());
        this.setPosition(p);
    }


}
