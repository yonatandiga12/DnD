package Position;

import Tile.Tile;
import Units.Unit;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Position {

    protected int x;
    protected int y;

    public Position(int x, int y){
        this.x = x;
        this.y = y;
    }

    public int getRange(Position p, Position q){
        return (int) Math.sqrt( Math.pow(p.x - q.x, 2) + Math.pow(p.y - q.y, 2));
    }

    /**
    This method returns what will be the position when we are moving by x and y
    but doesn't actually moves it.
    **/
     public Position translate(int x, int y){
        return new Position(this.x + x, this.y + y);
    }

    public Position getInteractionPosition(char goTo){
        Position p = this;
         switch(goTo){
            case 'w':
                p = new Position(x , y - 1);
            case 's':
                p = new Position(x, y + 1);
            case 'a':
                 p = new Position(x - 1, y );
            case 'd':
                 p = new Position(x + 1, y);
        }
        return p;
    }

    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }

    public String toString(){
        return "(" + x + "," + y + ")";
    }


    public int getIndex(int width) {
         return x + y * width;
    }
}
