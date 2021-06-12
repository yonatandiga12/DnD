import Enemies.Enemy;
import Players.Player;
import Players.Warrior;
import Tile.*;


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
            Tile t = board.getTileInPosition(player.getPosition().getInteractionPosition(letter));
            player.interact(t);
            player.gameTick();
        }
        else if( letter == 'e'){
            player.castAbility();
        }
        else if( letter == 'q'){
            //do nothing;
        }
        else{
            return;
        }

        for(Enemy e : enemies){
            //e.interact();
        }

        player.messageCallback.send("Player position : " + player.getPosition());

        player.messageCallback.send(player.describe());
        player.messageCallback.send(board.toString());

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

    public void removeEnemy(Enemy e) {
        enemies.remove(e);
        board.removeEnemy(e);
    }

    public void removePlayer() {
        board.removePlayer();
    }
}
