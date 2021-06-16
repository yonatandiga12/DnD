import Enemies.Enemy;
import Enemies.Monster;
import Enemies.Trap;
import Interfaces.InputProvider;
import Interfaces.MessageCallback;
import Interfaces.PlayerDeathCallback;
import Players.*;
import Position.Position;
import Tile.*;


import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class LevelInitializer {

    private PlayerDeathCallback deathCallback;
    private InputProvider inputProvider;

    protected String stringPath;
    private Player player;
    protected Board board;
    private String[] levelsPaths;
    private GameLevel gameLevel;
    public MessageCallback messageCallback;



    public LevelInitializer(String path, Player player){
        this.stringPath = path;
        this.player = player;

        ArrangePaths();
    }

    //read the lvl.txt file and create a level, using the
    public GameLevel initGameLevel(int lvlNum){
        board = loadLevel(lvlNum);

        messageCallback.send(board.toString());

        gameLevel = new GameLevel(board);
        return gameLevel;
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
    }

    // Loads from the file all the tiles.
    protected Board loadLevel(int currLevel){
        List<String> listofFile = readFromFileToList(levelsPaths[currLevel - 1]);
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
                else if (currLetter == '@'){
                    board.add(player);
                    player.setDeathCallback( () -> gameLevel.onPlayerDeath());
                    player.setMessageCallBack((msg) -> System.out.println(msg));
                    player.initialize(p, null, null, null);
                }
                else {
                    Enemy e = findEnemyType(currLetter);
                    e.initialize(p,null,null,null);
                    e.setDeathCallback( () -> gameLevel.removeEnemy(e));
                    e.setMessageCallBack( (msg) -> System.out.println(msg));
                    board.add(e);
                }
            }
        }
        //currLevel += 1;
        return board;
    }





    private Enemy findEnemyType(char currLetter) {
        Enemy enemy;
        switch(currLetter){
            case 's':
                enemy = new Monster("Lannister Solider", 's', 80, 8, 3, 25, 3, player);
                break;
            case 'k':
                enemy = new Monster("Lannister Knight", 'k', 200, 14, 8, 50, 4, player);
                break;
            case 'q':
                enemy = new Monster("Queen’s Guard", 'q', 400, 20, 15, 100, 5, player);
                break;
            case 'z':
                enemy = new Monster("Wright", 'z', 600, 30, 15, 100, 3, player);
                break;
            case 'b':
                enemy = new Monster("Bear-Wright", 'b', 1000, 75, 30, 250, 4, player);
                break;
            case 'g':
                enemy = new Monster("Giant-Wright", 'g', 1500, 100, 40, 500, 5, player);
                break;
            case 'w':
                enemy = new Monster("White Walker", 'w', 2000, 150, 50, 1000, 6, player);
                break;
            case 'M':
                enemy = new Monster("The Mountain", 'M', 1000, 60, 25, 500, 6, player);
                break;
            case 'C':
                enemy = new Monster("Queen Cersei", 'C', 100, 10, 10, 1000, 1, player);
                break;
            case 'K':
                enemy = new Monster("Night’s King", 'K', 5000, 300, 150, 5000, 8, player);
                break;
            case 'B':
                enemy = new Trap("Bonus Trap", 'B', 1, 1, 1, 250, 1, 5, player);
                break;
            case 'Q':
                enemy = new Trap("Queen’s Trap", 'Q', 250, 50, 10, 100, 3, 7, player);
                break;
            case 'D':
                enemy = new Trap("Death Trap", 'D',500,100,20,250,1,10, player);
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + currLetter);
        }
        //board.add(enemy);
        return enemy;
    }


    public static List<String> readFromFileToList(String path) {
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


    public int getNumOfLevels() {
        return levelsPaths.length;
    }

    public void setMessageCallBack(MessageCallback m){
        this.messageCallback = m;
    }
}
