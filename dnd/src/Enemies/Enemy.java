package Enemies;

import Position.Position;
import Units.Unit;

public abstract class Enemy extends Unit {

    public char tileSign;
    public int experienceValue;

    public Enemy(String name, char tileSign, int health, int attack, int defense, int experienceValue, Position position){
        super(position , tileSign);
        this.name = name;
        this.healthAmount = health;
        this.attack = attack;
        this.defense = defense;
        this.tileSign = tileSign;
        this.experienceValue = experienceValue;

    }

    public void setAttack(int num) {
        attack += (num);
    }

    public void setDefense(int num) {
        defense += (num);
    }

    public abstract void gameTick();

    public abstract String toString();
}
