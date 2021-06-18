import java.io.File;
import java.net.URL;
import java.util.Arrays;
import java.util.Scanner;

public class CLI {



    public static void main(String[] args){

        //C:\בן גוריון\סמסטר ב\מונחה עצמים\Project3\levels_dirC:\Users\dyota\Desktop\מונחה עצמים\git\dnd\levels_dir
        //GameManager gameManager = new GameManager( "C:\Users\dyota\Desktop\OOP\git\dnd\levels_dir", 3 ); // insert the location
        Scanner scan = new Scanner(System.in);
        String levelsPath = "";
        for (String s : args){
            levelsPath = levelsPath + s;
        }

        GameManager gameManager = new GameManager();
        int l = scan.nextInt();
        //gameManager.choosePlayer("C:\\בן גוריון\\סמסטר ב\\מונחה עצמים\\Project3\\levels_dir", l);
        gameManager.choosePlayer(levelsPath, l);

        while(gameManager.isGameActive()) {
            String letter = scan.nextLine();
            gameManager.doAction(letter);
        }
    }
}
