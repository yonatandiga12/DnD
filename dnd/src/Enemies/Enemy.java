package Enemies;

import Interfaces.InputProvider;
import Interfaces.MessageCallback;
import Interfaces.PlayerDeathCallback;
import Players.Player;
import Position.Position;
import Units.Unit;

public abstract class Enemy extends Unit {

    private PlayerDeathCallback deathCallback;
    private InputProvider inputProvider;

    public char tileSign;
    public int experienceValue;

    public Enemy(String name, char tileSign, int health, int attack, int defense, int experienceValue){
        super(tileSign);
        this.name = name;
        this.healthAmount = health;
        this.attack = attack;
        this.defense = defense;
        this.tileSign = tileSign;
        this.experienceValue = experienceValue;

    }

    public Enemy initialize(Position position, MessageCallback messageCallback, PlayerDeathCallback deathCallback, InputProvider inputProvider){
        super.initialize(position, messageCallback);
        this.deathCallback = deathCallback;
        this.inputProvider = inputProvider;
        return this;
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
