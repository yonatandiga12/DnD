package Enemies;

import Units.Unit;

public abstract class Enemy extends Unit {

    public char tile;
    public int experienceValue;

    public Enemy(String name, char tile, int health, int attack, int defense, int experienceValue){
        this.name = name;
        this.healthAmount = health;
        this.attack = attack;
        this.defense = defense;
        this.tile = tile;
        this.experienceValue = experienceValue;

    }

    public void setAttack(int num) {
        attack += (num);
    }

    public void setDefense(int num) {
        defense += (num);
    }
    public abstract void gameTick();
}
