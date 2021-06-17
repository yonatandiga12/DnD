package Position;

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
        Position p = switch (goTo) {
            case 'w' -> getUpPosition();
            case 's' -> getDownPosition();
            case 'a' -> getLeftPosition();
            case 'd' -> getRightPosition();
            default -> this;
        };
        return p;
    }


    /*
    public Position getInteractionPosition(char goTo){
        Position p = this;
         switch(goTo){
            case 'w':
                p = getUpPosition();
                break;
            case 's':
                p = getDownPosition();
                break;
             case 'a':
                 p = getLeftPosition();
                 break;
             case 'd':
                 p = getRightPosition();
                 break;
         }
        return p;
    }
     */

    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }
    public Position getUpPosition(){
        return new Position(x , y - 1);
    }
    public Position getDownPosition(){
        return new Position(x, y + 1);
    }
    public Position getLeftPosition(){
        return new Position(x - 1, y );
    }
    public Position getRightPosition(){
        return new Position(x + 1, y);
    }


    public String toString(){
        return "(" + x + "," + y + ")";
    }


    public int getIndex(int width) {
         return x + y * width;
    }


    public int compareTo(Position p) {
         if(getY() > p.getY())
             return 1;
         else if(getY() < p.getY())
             return -1;
         else{
             if(getX() > p.getX())
                 return 1;
             else if(getX() < p.getX())
                 return -1;
         }
         return 0;
    }
}
