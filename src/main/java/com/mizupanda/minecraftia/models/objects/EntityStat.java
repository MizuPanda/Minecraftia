package com.mizupanda.minecraftia.models.objects;


import com.mizupanda.minecraftia.Constants;
import com.mizupanda.minecraftia.models.StatEnum;
import net.minecraft.nbt.CompoundTag;

public class EntityStat {
    private double strength;
    private double speed;
    private double agility;
    private double health;
    private double defense;
    private double luck;

    public EntityStat() {
        this.strength = 0;
        this.speed = 0;
        this.health = 0;  // Default health value
        this.defense = 0;
        this.agility = 0;
        this.luck = 0;
    }

    public double battlePower() {
        return (health + speed*agility + strength + defense)*luck;
    }

    // Getters and setters
    public double getStrength() { return strength; }
    public void setStrength(double strength) { this.strength = strength; }

    public double getSpeed() { return speed; }
    public void setSpeed(double speed) { this.speed = speed; }

    public double getHealth() { return health; }
    public void setHealth(double health) { this.health = health; }

    public double getDefense() { return defense; }
    public void setDefense(double defense) { this.defense = defense; }

    public double getAgility() { return agility; }
    public void setAgility(double agility) { this.agility = agility; }

    public double getLuck() { return luck;}
    public void setLuck(double luck) { this.luck = luck;}

    public void increaseStat(StatEnum stat, double amount) {
        switch (stat) {
            case STRENGTH -> strength += amount;
            case SPEED -> speed += amount;
            case AGILITY -> agility += amount;
            case HEALTH -> health += amount;
            case DEFENSE -> defense += amount;
            case LUCK -> luck += amount;
        }
    }

    public void fromNBT(CompoundTag tag) {
        strength = tag.getDouble(Constants.STRENGTH_STAT);
        speed = tag.getDouble(Constants.SPEED_STAT);
        health = tag.getDouble(Constants.HEALTH_STAT);
        defense = tag.getDouble(Constants.DEFENSE_STAT);
        agility = tag.getDouble(Constants.AGILITY_STAT);
        luck = tag.getDouble(Constants.LUCK_STAT);
    }

    @Override
    public String toString() {
        return "EntityStat{" +
                "strength=" + strength +
                ", speed=" + speed +
                ", health=" + health +
                ", defense=" + defense +
                ", agility=" + agility +
                ", luck=" + luck +
                '}';
    }
}



