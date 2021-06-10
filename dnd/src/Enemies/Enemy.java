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


    public Enemy(String name, char tileSign, int health, int attack, int defense, int experienceValue){
        super(tileSign,name , health , attack, defense, experienceValue);

    }

    public Enemy initialize(Position position, MessageCallback messageCallback, PlayerDeathCallback deathCallback, InputProvider inputProvider){
        super.initialize(position, messageCallback);
        this.deathCallback = deathCallback;
        this.inputProvider = inputProvider;
        return this;
    }

    public abstract void gameTick();

    @Override
    public void accept(Unit u){
        u.visit(this);
    }


    @Override
    public void visit(Enemy e){
        // do nothing
    }

    @Override
    public void visit(Player p){
        // when the enemy visits player
    }




    public String describe() {
        return name + "     " + "Health: " + healthAmount + "/" + healthPool + "     " + "Attack: " + attack + "     " + "Defense: " + defense + "     " + "Experience value: " + experience ;
    }
}
