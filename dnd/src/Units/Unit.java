package Units;

public abstract class Unit {
    public String name = "";
    public int healthPool = 0;
    public int healthAmount = 0;
    public int attack = 0;
    public int defense = 0;

    // Getter
    public String getName(){
        return name;
    }
    // Setter
    public void setName(String name) {
        this.name = name;
    }


    // Getter
    public int getHealthPool(){
        return healthPool;
    }



    // Getter
    public int getHealthAmount(){
        return healthAmount;
    }
    // Setter
    public void setHealthAmount(int health) {
        healthAmount = health;
    }


    // Getter
    public int getAttack(){
        return attack;
    }


    // Getter
    public int getDefense(){
        return defense;
    }


}
