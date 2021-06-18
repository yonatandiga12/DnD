import java.io.File;
import java.net.URL;
import java.util.Arrays;
import java.util.Scanner;

public class CLI {



    public static void main(String[] args){

        Scanner scan = new Scanner(System.in);
        String levelsPath = "";
        for (String s : args){
            levelsPath = levelsPath + s;
        }

        GameManager gameManager = new GameManager();
        int l = scan.nextInt();
        gameManager.choosePlayer(levelsPath, l);
        while(gameManager.isGameActive()) {
            String letter = scan.nextLine();
            gameManager.doAction(letter);
        }
    }
}
