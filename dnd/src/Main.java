import Enemies.Enemy;
import Tile.Tile;
import Units.Unit;

import java.io.File;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        // write your code here

        LevelInitializer e = new LevelInitializer("C:\\בן גוריון\\סמסטר ב\\מונחה עצמים\\Project3\\levels_dir", "Arya Stark");
        System.out.println(e.board.getTileInPosition(5, 1));
        //System.out.println(e.board.getTileInPosition(1, 9).position);
        Tile tile =  e.board.getTileInPosition(32, 8);
        List<Enemy> t = e.board.searchForEnemies(5 , tile);
        //System.out.println(tile.position.getRange(tile.position, e.board.getTileInPosition(5, 1).position));
        System.out.println(t.size());
        for( Tile b : t){
            System.out.println(b.getPosition());
        }
    }
}

