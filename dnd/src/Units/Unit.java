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
    public MessageCallback messageCallback;



    public Unit( char sign, String name, int health, int attack, int defense, int experience) {
        super(sign);
        this.name = name;
        this.healthPool = health;
        this.healthAmount = health;
        this.attack = attack;
        this.defense = defense;
        this.experience = experience;
    }

    protected void initialize(Position position){
        super.initialize(position);
    }

    public void interact(Tile tile){
        tile.accept(this);
    }

    public void visit(Empty e){
        swapPostions(e);
    }



    public void visit(Wall w){
        //do nothing
    }
    public abstract void visit(Player p);
    public abstract void visit(Enemy e);
    public abstract void onDeath();


    protected void battle(Unit u){
        messageCallback.send(String.format("%s engaged in combat with %s.\n%s \n%s", getName(), u.getName(),describe(), u.describe() ));
        int damageDone = Math.max(Attack() - u.Defend(), 0);
        u.setHealthAmount(-damageDone);
        messageCallback.send(String.format("%s dealt %d damage to %s",getName(), damageDone, u.getName()));
    }

    public int Defend() {
        int result = r.nextInt(defense);
        messageCallback.send(String.format("%s rolled %d defense points.",getName(), result));
        return result;
    }

    public int Attack() {
        int result = r.nextInt(attack);
        messageCallback.send(String.format("%s rolled %d attack points.",getName(), result));
        return result;
    }

    public boolean alive(){
        return getHealthAmount() > 0;
    }

    public String getName(){
        return name;
    }

    public int getExperience(){
        return experience;
    }
    public void setExperience(int num) {
        experience += (num);
    }
    public int getHealthPool(){
        return healthPool;
    }
    public void setHealthPool(int num){
        healthPool += num;
    }

    public int getHealthAmount(){
        return healthAmount;
    }
    public void setHealthAmount(int num) {
        if (healthAmount + (num) <= healthPool)
            healthAmount += (num);
        healthAmount = Math.max(healthAmount, 0);
    }

    public int getAttack(){
        return attack;
    }
    public void setAttack(int num) {
        attack += (num);
    }
    public int getDefense(){
        return defense;
    }
    public void setDefense(int num) {
        defense += (num);
    }
    public void setCurrentHealth() {
        healthAmount = healthPool;
    }


    public String describe() {
        return getName() + createSpaces(getName().length(), 18) + "Health: " + getHealthAmount()+ "/" + getHealthPool() + createSpaces(String.valueOf(getHealthAmount()).length() , 7) +
                "Attack: " + getAttack()+ createSpaces(String.valueOf(getAttack()).length(), 7) + "Defense: " + getDefense();
    }

    public String createSpaces(int nameLength, int maxLength ){
        int additionalSpaces = maxLength - nameLength;
        String output = "";
        while(additionalSpaces > 0){
            output += " ";
            additionalSpaces -= 1;
        }
        return output;
    }

    public String toString() {
        return name;
    }


    public void swapPostions(Tile tile) {
         Position p = tile.getPosition();
         tile.setPosition(this.getPosition());
         this.setPosition(p);
    }


}
