import Enemies.Enemy;
import Players.Mage;
import Players.Player;
import Players.Rogue;
import Players.Warrior;
import jdk.jshell.execution.LocalExecutionControl;

import java.io.*;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class GameManager {

        private LevelInitializer levelInitializer;
        private String path;
        private String playerName;
        public Board board;
        public Player player;
        private int currLevel = 1;

    protected List<Enemy> enemiesList = new ArrayList<>();

        public GameManager(String path, int playerNum){
            this.path = path;
            playerName = getPlayer(playerNum);
            levelInitializer = new LevelInitializer(path, playerName);
            //board = createBoard(path);

        }

    public void createFirstBoard() {

        board = levelInitializer.loadLevel(currLevel);
        // do loop on levels

    }

    public String getPlayer(int p) {
        switch (p) {
            // to be continued...
            case 1:
                playerName = "Jon Snow";
            case 2:
                playerName = "Jon Snow";
            case 3:
                playerName = "Jon Snow";
            case 4:
                playerName = "Jon Snow";

        }
        return playerName;
    }





}
