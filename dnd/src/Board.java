import Enemies.Enemy;
import Players.Player;
import Position.Position;
import Tile.Tile;
import Tile.Empty;

import Units.Unit;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Board {

    protected List<Tile> tiles = new ArrayList<>();
    protected int height;
    protected int width;
    protected Player player;
    protected List<Enemy> enemiesList = new ArrayList<>();


    public Board(int height, int width) {
        this.height = height;
        this.width = width;
    }


    public void add(Tile t){
        tiles.add(t);
    }

    public void add(Player p)
    {
        tiles.add(p);
        player = p;
    }

    public void add(Enemy e)
    {
        tiles.add(e);
        enemiesList.add(e);
    }

    public void remove(Enemy e)
    {
        tiles.set(getIndex(e), new Empty(e.getPosition()));
        enemiesList.remove(e);
    }

    public Tile getTileInPosition(Position p){

        return tiles.get(p.getX() + width * p.getY());
    }

    /**
     This method returns a list of all the units close by.
     **/
    public List<Enemy> searchForEnemies(int range, Tile currUnit){

        // Need to see where to put the list of all the tiles
        //List<Unit> tiles= new ArrayList<>();

        Stream<Enemy> output = enemiesList.stream().filter((u) -> currUnit.getPosition().getRange(u.getPosition(), currUnit.getPosition()) <= range );
        // need to sort just the enemies out of all the tiles, and not by their chars!!!
        List<Enemy> enemies = output.collect(Collectors.toList());

        return enemies;
    }

    private int getIndex(Tile t){
       Position p = t.getPosition();
       return p.getIndex(width);
    }

    public String toString(){
        String output = "";
        int index = 0;
        for(int i = 0; i < height; i++){
            for(int j = 0; j < width; j++){
                output += tiles.get(index).toChar();
                index += 1;
            }
            output += "\n";
        }

        return output;
    }

}
