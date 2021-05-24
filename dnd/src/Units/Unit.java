package Units;

public abstract class Unit {
    public String name;
    public int healthAmount;
    public int healthPool = healthAmount;
    public int attack;
    public int defense;

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

    // Getter
    public int getAttack(){
        return attack;
    }

    // Getter
    public int getDefense(){
        return defense;
    }


}
