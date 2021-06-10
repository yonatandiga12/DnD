import Enemies.Enemy;
import Players.Player;
import Players.Warrior;

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

    public void runTick(char letter){
        if(letter == 'w' | letter == 'a' | letter == 's' | letter == 'd'){
            player.interact(board.getTileInPosition(player.getPosition().getInteractionPosition(letter)));
            //player.move(letter);
        }
        else if( letter == 'e'){
            // special abillity
        }
        else if( letter == 'q'){
            //do nothing;
        }
        else{
            return;
        }

        for(Enemy e : enemies){
            //e.interact()
            //e.doAction();
        }
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
