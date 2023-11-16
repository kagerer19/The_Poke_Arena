package org.pokemon;

public class Pokemon {
    private final int id;
    private final String name;
    private final String type1;
    private final String type2;
    private final int total;
    private double hp;
    private final int attack;
    private final int defense;
    private final int spAtk;
    private final int spDef;
    private final int speed;
    private Attacks attackPrimary;
    private Attacks attackSecondary;

    public Pokemon(int id, String name, String type1, String type2, int total, double hp, int attack, int defense, int spAtk, int spDef, int speed) {
        this.id = id;
        this.name = name;
        this.type1 = type1;
        this.type2 = type2;
        this.total = total;
        this.hp = hp;
        this.attack = attack;
        this.defense = defense;
        this.spAtk = spAtk;
        this.spDef = spDef;
        this.speed = speed;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getType1() {
        return type1;
    }

    public String getType2() {
        return type2;
    }

    public int getTotal() {
        return total;
    }

    public double getHp() {
        return hp;
    }

    public void setHp(double hp) {
        this.hp = hp;
    }

    public int getAttack() {
        return attack;
    }

    public int getDefense() {
        return defense;
    }

    public int getSpAtk() {
        return spAtk;
    }

    public int getSpDef() {
        return spDef;
    }

    public int getSpeed() {
        return speed;
    }

    public Attacks getAttackPrim() {
        return attackPrimary;
    }

    public void setAttackPrim(Attacks attackPrimary) {
        this.attackPrimary = attackPrimary;
    }

    public Attacks getAttackSec() {
        return attackSecondary;
    }

    public void setAttackSec(Attacks attackSecondary) {
        this.attackSecondary = attackSecondary;
    }
}
