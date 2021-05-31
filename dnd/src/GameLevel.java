import Enemies.Enemy;
import Players.Player;

import java.util.List;

public class GameLevel {


    private Board board;
    private Player player;
    private List<Enemy> enemies;

    //constructor:
    public GameLevel(Board board){
        this.board = board;
        this.player = board.player;
        this.enemies = board.enemiesList;
    }

    //called when the player dies
    public void onPlayerDeath(){

    }

    //called when enemy dies
    public void onEnemyDeath(Enemy e){

    }

    //level string representation
    @Override
    public String toString() {
        return String.format("%s\n%s", board, player.describe());
    }
}
