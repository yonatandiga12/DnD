package Enemies;

import Interfaces.*;
import Players.Player;
import Position.Position;
import Tile.Tile;
import Units.Unit;

import java.util.Dictionary;

public abstract class Enemy extends Unit {

    private EnemyDeathCallback EnemydeathCallback;


    public Enemy(String name, char tileSign, int health, int attack, int defense, int experienceValue){
        super(tileSign,name , health , attack, defense, experienceValue);

    }

    public void initialize(Position position){
        super.initialize(position);
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
        super.battle(p);
        if(!p.alive()){
            p.onDeath();
        }
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

    public abstract Tile ChooseAction(Dictionary<String,Tile> surroundingTiles);
}
