import java.io.File;
import java.net.URL;
import java.util.Scanner;

public class CLI {



    public static void main(String[] args){

        //C:\בן גוריון\סמסטר ב\מונחה עצמים\Project3\levels_dirC:\Users\dyota\Desktop\מונחה עצמים\git\dnd\levels_dir
        //GameManager gameManager = new GameManager( "C:\\Users\\dyota\\Desktop\\מונחה עצמים\\git\\dnd\\levels_dir", 3 ); // insert the location
        GameManager gameManager = new GameManager( "C:\\בן גוריון\\סמסטר ב\\מונחה עצמים\\Project3\\levels_dir", 3 ); // insert the location


        Scanner scan = new Scanner(System.in);
        String letter  = scan.nextLine();
        gameManager.doAction(letter.charAt(0));


    }

}
