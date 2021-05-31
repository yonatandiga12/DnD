public class CLI {



    public static void main(String[] args){
        GameManager gameManager = new GameManager( "temp", 1 ); // insert the location

        System.out.println(" ALl the players");
        System.out.println(" You selected");
        System.out.println( gameManager.getPlayer(2)  );
        gameManager.createFirstBoard();


    }

}
