package Enemies;

import Interfaces.*;
import Players.Player;
import Position.Position;
import Units.Unit;

public abstract class Enemy extends Unit {

    private EnemyDeathCallback EnemydeathCallback;
    //private PlayerDeathCallback PlayerdeathCallback;

    private InputProvider inputProvider;


    public Enemy(String name, char tileSign, int health, int attack, int defense, int experienceValue){
        super(tileSign,name , health , attack, defense, experienceValue);

    }

    public Enemy initialize(Position position, MessageCallback messageCallback, PlayerDeathCallback deathCallback, InputProvider inputProvider){
        super.initialize(position, messageCallback);
        //this.PlayerdeathCallback = deathCallback;
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
        // when the enemy visits player need to fill this
    }


    public void onDeath() {
        EnemydeathCallback.call();
    }

    public void setDeathCallback(EnemyDeathCallback edc){
        this.EnemydeathCallback = edc;
    }

    public void setMessageCallBack(MessageCallback m){
        this.messageCallback = m;
    }

    public String describe() {
        return super.describe() + "     " + "Experience value: " + experience ;
    }
}
