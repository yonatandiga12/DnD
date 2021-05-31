package Units;

import Interfaces.MessageCallback;
import Position.Position;
import Tile.Tile;

public abstract class Unit extends Tile {
    public String name;
    public int healthAmount;
    public int healthPool = healthAmount;
    public int attack;
    public int defense;
    private MessageCallback messageCallback;


    public Unit( char sign) {
        super(sign);
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


}
