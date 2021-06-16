import Enemies.Enemy;
import Interfaces.InputProvider;
import Interfaces.MessageCallback;
import Players.Mage;
import Players.Player;
import Players.Rogue;
import Players.Warrior;

import java.io.*;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class GameManager {

    private LevelInitializer levelInitializer;
    private int currLevel = 1;
    private GameLevel gameLevel;
    private Player player;
    private List<Player> allPlayers;
    private MessageCallback messageCallback;
    boolean gameWon = false;

    public GameManager() {

        startGameAndPrintPlayers();
        setMessageCallBack((msg) -> System.out.println(msg));
        messageCallback.send(String.format("Select Player: \n%s", printAllPlayers()));
        messageCallback.send("Insert number of Player: ");
    }

    public void choosePlayer(String path, int i) {
        player = ChoosePlayerAccordingtoInput(i);
        levelInitializer = new LevelInitializer(path, player);
        levelInitializer.setMessageCallBack((msg) -> System.out.println(msg));
        messageCallback.send(String.format("You have selected: \n%s", player));
        gameLevel = levelInitializer.initGameLevel(currLevel);
    }




    public void doAction(String l) {
        if(l.length() == 1){
            gameLevel.runTick(l.charAt(0));
            if(gameLevel.isEndOfLevel()){
                if(currLevel < levelInitializer.getNumOfLevels()){
                    currLevel += 1;
                    gameLevel = levelInitializer.initGameLevel(currLevel);
                }
                else{
                    messageCallback.send("You Won!");
                    gameWon = true;
                }
            }
        }

    }


    public boolean isGameActive() {
        return gameLevel.isPlayerAlive() & !gameWon ;
    }



    private void startGameAndPrintPlayers() {
        //print all playeres in screen that the user can choose from:
        allPlayers = createAllPlayers();
        printAllPlayers();

    }

    private List<Player> createAllPlayers() {
        List<Player> allPlayers = new ArrayList<Player>(6);
        allPlayers.add(0, new Warrior("Jon Snow", 300, 30, 4, 3));
        allPlayers.add(1, new Warrior("The Hound", 400, 20, 6, 5));
        allPlayers.add(2, new Mage("Melisandre", 100, 5, 1, 300, 30, 15, 3, 6));
        allPlayers.add(3, new Mage("Thoros of Myr", 250, 25, 4, 150, 20, 15, 3, 4));
        allPlayers.add(4, new Rogue("Arya Stark", 150, 40, 2, 20));
        allPlayers.add(5, new Rogue("Bronn", 250, 35, 2, 50));
        return allPlayers;
    }
    private Player ChoosePlayerAccordingtoInput(int playerNum) {
        Player player;
        switch (playerNum){
            case 1:
                player = allPlayers.get(0);
                //player = new Warrior( "Jon Snow", 300, 30, 4, 3);
                break;
            case 2:
                player = allPlayers.get(1);
                //player = new Warrior( "The Hound",400 , 20 , 6 , 5);
                break;
            case 3:
                player = allPlayers.get(2);
                //player = new Mage("Melisandre", 100, 5, 1, 300, 30, 15, 3, 6);
                break;
            case 4:
                player = allPlayers.get(3);
                //player = new Mage("Thoros of Myr", 250, 25, 4,150, 20, 15, 3, 4 );
                break;
            case 5:
                player = allPlayers.get(4);
                //player = new Rogue("Arya Stark", 150, 40, 2, 20);
                break;
            case 6:
                player = allPlayers.get(5);
                //player = new Rogue("Bronn",250, 35, 2, 50);
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + playerNum);
        }
        return player;
    }



    public String printAllPlayers() {
        String output = "";
        int counter = 1;
        for (Player player : allPlayers) {
            output = output + counter + ". " + player.describe() + "\n";
            counter += 1;
        }
        return output;
    }

    public void setMessageCallBack(MessageCallback m){
        this.messageCallback = m;
    }


}
