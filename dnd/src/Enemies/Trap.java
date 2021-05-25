package Enemies;

public class Trap extends Enemy{

    public int visibilityTime;
    public int invisibilityTime;
    public int ticksCount = 0;
    public boolean visible = true;

    public Trap(String name, char tile, int health, int attack, int defense, int experienceValue, int visibilityTime, int invisibilityTime) {
        super(name, tile, health, attack, defense, experienceValue);
        this.visibilityTime = visibilityTime;
        this.invisibilityTime = invisibilityTime;

    }


    @Override
    public void gameTick() {
        visible = ticksCount < visibilityTime;
        if (ticksCount == (visibilityTime + invisibilityTime))
            ticksCount = 0;
        else {
            ticksCount += 1;
            // Player player = SearchForPlayer(2);
            //if ( player != null )
            //    attack(player);
        }
    }
}