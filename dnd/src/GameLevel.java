import Enemies.Enemy;
import Players.Player;
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
        boolean castAbilityWorked = true;
        if(letter == 'w' | letter == 'a' | letter == 's' | letter == 'd'){
            Tile t = board.getTileInPosition(player.getPosition().getInteractionPosition(letter));
            player.interact(t);
            player.gameTick();
        }
        else if( letter == 'e'){
            castAbilityWorked = player.castAbility(enemies);
        }
        else if( letter == 'q'){
            player.gameTick();
        }
        else{
            return;
        }
        if(castAbilityWorked) {
            for (Enemy e : enemies) {
                board.updateMap();
                var x = board.getSurroundingTiles(e.getPosition());
                Tile t = e.ChooseAction(board.getSurroundingTiles(e.getPosition()));
                if (t != null)
                    e.interact(t);
            }
        }

        player.messageCallback.send(board.toString());
        player.messageCallback.send(player.describe());


    }

    //called when the player dies
    public void onPlayerDeath(){
        board.removePlayer();
        player.setHealthAmount(-player.getHealthAmount()); // death!

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

    public boolean isPlayerAlive() {
        return player.alive();
    }

    public boolean isEndOfLevel(){
        return enemies.size() == 0;
    }

}
