package Units;

import Interfaces.MessageCallback;
import Position.Position;
import Tile.Tile;

public abstract class Unit extends Tile {
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

    // Getter
    public String getName(){
        return name;
    }
    // Setter
    public void setName(String name) {
        this.name = name;
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

    public String toString() {
        return name;
    }



}
