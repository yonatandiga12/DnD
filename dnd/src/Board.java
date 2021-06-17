import Enemies.Enemy;
import Players.Player;
import Position.Position;
import Tile.Tile;
import Tile.Empty;

import java.util.*;
import java.util.List;

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

    public void removeEnemy(Enemy e)
    {
        updateMap();
        tiles.set(getIndex(e), new Empty(e.getPosition()));
        enemiesList.remove(e);
    }

    public void updateMap(){
        Collections.sort(tiles);
    }

    public Tile getTileInPosition(Position p){

        return tiles.get(p.getX() + width * p.getY());
    }

    public Dictionary<String, Tile> getSurroundingTiles(Position p){
        Dictionary<String,Tile> output = new Hashtable<>();
        output.put("Up", getTileInPosition(p.getUpPosition()) );
        output.put("Down", getTileInPosition(p.getDownPosition()) );
        output.put("Left", getTileInPosition(p.getLeftPosition()) );
        output.put("Right", getTileInPosition(p.getRightPosition()) );
        return output;
    }


    private int getIndex(Tile t){
       Position p = t.getPosition();
       return p.getIndex(width);
    }

    public String toString(){
        updateMap();

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

    public void removePlayer() {
        tiles.set(getIndex(player), new Empty(player.getPosition(),'X'));
    }

}
