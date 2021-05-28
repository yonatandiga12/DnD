import Enemies.Enemy;
import Enemies.Monster;
import Enemies.Trap;
import Players.*;
import Position.Position;
import Tile.*;


import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class LevelInitializer {

    protected String stringPath;
    protected String playerName;
    protected Board board;
    private int currLevel = 1;
    private String[] levelsPaths;


    public LevelInitializer(String path, String namePlayer){
        this.stringPath = path;
        this.playerName = namePlayer;   // This shouldn't be here, supposed to read it through the cmd

        ArrangePaths();
        loadLevel();

    }

    // Arrange all the paths for the levels for easy access
    protected void ArrangePaths(){
        File f = new File(stringPath);
        String[] PathsEnds = f.list();
        levelsPaths = new String[f.list().length];
        int i = 0;
        for (String pathname : PathsEnds) {
            levelsPaths[i] = f.getAbsolutePath() + "\\" + pathname;
            i += 1;
        }
        for(String m : levelsPaths){
            //System.out.println(m);
        }
    }

    // Loads from the file all the tiles.
    protected void loadLevel(){
        List<String> listofFile = readFromFileToString(levelsPaths[currLevel - 1]);
        //List<String> listofFile = readFromFileToString(levelsPaths[2]);

        //GameManager m = new GameManager();
        int width = listofFile.get(0).length();
        int height = listofFile.size();
        board = new Board(height, width);
        for(int row = 0; row < height ; row ++ ){
            for(int col = 0; col < width ; col ++ ) {
                Position p = new Position(col, row);
                char currLetter = listofFile.get(row).charAt(col);
                if (currLetter == '#')
                    board.add(new Wall(p));
                else if (currLetter == '.')
                    board.add(new Empty(p));
                else if (currLetter == '@')
                    //String name, int health, int attack, int defense, Position position,  int cooldown
                    insertPlayerToBoard(playerName, p);
                else {
                    Enemy e = findEnemyType(currLetter, p);
                    // e.setDeathCallBack( () -> m.removeEnemy(e));
                    // e.setMessageCallBack( (msg) -> System.out.prinlt(msg));
                    board.add(e);
                }
            }
        }
        currLevel += 1;
    }


    private void insertPlayerToBoard(String playerName, Position p) {
        Player player;
        switch (playerName){
            case "Jon Snow":
                player = new Warrior( "Jon Snow", 300, 30, 4, p, 3);
                break;
            case "The Hound":
                player = new Warrior( "The Hound",400 , 20 , 6 ,p , 5);
                break;
            case "Melisandre":
                player = new Mage("Melisandre", 100, 5, 1, p, 300, 30, 15, 3, 6);
                break;
            case "Thoros of Myr":
                player = new Mage("Thoros of Myr", 250, 25, 4,p, 150, 20, 15, 3, 4 );
                break;
            case "Arya Stark":
                player = new Rogue("Arya Stark", 150, 40, 2, p, 20);
                break;
            case "Bronn":
                player = new Rogue("Bronn",250, 35, 2, p, 50);
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + playerName);
        }
        board.add(player);
    }


    private Enemy findEnemyType(char currLetter, Position p) {
        Enemy enemy;
        switch(currLetter){
            case 's':
                enemy = new Monster("Lannister Solider", 's', 80, 8, 3, 25,  p, 3);
                break;
            case 'k':
                enemy = new Monster("Lannister Knight", 'k', 200, 14, 8, 50,  p, 4);
                break;
            case 'q':
                enemy = new Monster("Queen’s Guard", 'q', 400, 20, 15, 100,  p, 5);
                break;
            case 'z':
                enemy = new Monster("Wright", 'z', 600, 30, 15, 100,  p, 3);
                break;
            case 'b':
                enemy = new Monster("Bear-Wright", 'b', 1000, 75, 30, 250,  p, 4);
                break;
            case 'g':
                enemy = new Monster("Giant-Wright", 'g', 1500, 100, 40, 500,  p, 5);
                break;
            case 'w':
                enemy = new Monster("White Walker", 'w', 2000, 150, 50, 1000,  p, 6);
                break;
            case 'M':
                enemy = new Monster("The Mountain", 'M', 1000, 60, 25, 500,  p, 6);
                break;
            case 'C':
                enemy = new Monster("Queen Cersei", 'C', 100, 10, 10, 1000,  p, 1);
                break;
            case 'K':
                enemy = new Monster("Night’s King", 'K', 5000, 300, 150, 5000,  p, 8);
                break;
            case 'B':
                enemy = new Trap("Bonus Trap", 'B', 1, 1, 1, 250, p, 1, 5);
                break;
            case 'Q':
                enemy = new Trap("Queen’s Trap", 'Q', 250, 50, 10, 100,p, 3, 7);
                break;
            case 'D':
                enemy = new Trap("Death Trap", 'D',500,100,20,250,p,1,10);
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + currLetter);
        }
        //board.add(enemy);
        return enemy;
    }


    public static List<String> readFromFileToString(String path) {
        List<String> lines = new ArrayList<>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(path));
            String next;
            while ((next = reader.readLine()) != null) {
                lines.add(next);
            }
        } catch (FileNotFoundException e) {
            System.out.println ("File not found " + path);
        } catch (IOException e) {
            System.out.println(e.getMessage() + "\n" + e.getStackTrace());
        }
        return lines;
    }


}
