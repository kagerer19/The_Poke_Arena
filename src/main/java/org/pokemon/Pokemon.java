package org.pokemon;


class Pokemon {
    private int pokemonID;
    private String pokemonName;
    private String PokemonType;
    private String kind;
    private double total;
    private double hp;
    private double attack;
    private double defense;
    private double speedAttack;
    private double speedDefense;
    private double speed;
    private String primaryAttack;
    private String secondaryAttack;

    Pokemon(int ID, String name, String typeOf, String species, double PKTotal, double healthPoints, double att, double def, double spAtt, double spDef, double totalSpeed) {
        setPokemonID(ID);
        setPokemonName(name);
        setType(typeOf);
        setKind(species);
        setTotal(PKTotal);
        setHp(healthPoints);
        setAtt(att);
        setDef(def);
        setSpeedAtt(spAtt);
        setSpeedDef(spDef);
        setSpeed(totalSpeed);
    }

    Pokemon(int ID, String name, String typeOf, String species, double PKTotal, double healthPoints, double att, double def, double spAtt, double spDef, double totalSpeed, String prAttack, String scAttack) {
        setPokemonID(ID);
        setPokemonName(name);
        setType(typeOf);
        setKind(species);
        setTotal(PKTotal);
        setHp(healthPoints);
        setAtt(att);
        setDef(def);
        setSpeedAtt(spAtt);
        setSpeedDef(spDef);
        setSpeed(totalSpeed);
        setPrimaryAttack(prAttack);
        setSecondaryAttack(scAttack);
    }

    //Getters
    public int getPokemonID() {
        return pokemonID;
    }

    public String getPokemonName() {
        return pokemonName;
    }

    public String getPokemonType() {
        return PokemonType;
    }

    public String getKind() {
        return kind;
    }

    public double getTotal() {
        return total;
    }

    public double getHp() {
        return hp;
    }

    public double getAttack() {
        return attack;
    }

    public double getDefense() {
        return defense;
    }

    public double getSpeedAttack() {
        return speedAttack;
    }

    public double getSpeedDefense() {
        return speedDefense;
    }

    public double getSpeed() {
        return speed;
    }
    public String getPrimaryAttack() {
        return primaryAttack;
    }

    public String getSecondaryAttack() {
        return secondaryAttack;
    }

    //Setters
    public void setPokemonID(int pokemonID) {
        this.pokemonID = pokemonID;
    }

    public void setPokemonName(String pokemonName) {
        this.pokemonName = pokemonName;
    }

    public void setType(String type) {
        this.PokemonType = type;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    private void setTotal(double pkTotal) {
        this.total = pkTotal;
    }

    void setHp(double healthPoints) {
        this.hp = healthPoints;
    }

    private void setAtt(double att) {
        this.attack = att;
    }

    private void setDef(double def) {
        this.defense = def;
    }

    private void setSpeedAtt(double spAtt) {
        this.speedAttack = spAtt;
    }

    private void setSpeedDef(double spDef) {
        this.speedDefense = spDef;
    }

    private void setSpeed(double totalSpeed) {
        this.speed = totalSpeed;
    }
    public void setPrimaryAttack(String primaryAttack) {
        this.primaryAttack = String.valueOf(primaryAttack);
    }

    public void setSecondaryAttack(String secondaryAttack) {
        this.secondaryAttack = String.valueOf(secondaryAttack);
    }

    @Override
    public String toString() {

        return "ID:   " + getPokemonID() + "\n" +
                "Name: " + getPokemonName() + "\n" +
                "type: " + getPokemonType() + "\n" +
                "kind: " + getKind() + "\n" +
                "total: " + getTotal() + "\n" +
                "Health: " + getHp() + "\n" +
                "Attack: " + getAttack() + "\n" +
                "Defense: " + getDefense() + "\n" +
                "Speed Attack: " + getSpeedAttack() + "\n" +
                "Speed Attack: " + getSpeedDefense() + "\n" +
                "Speed: " + getSpeed() + "\n" +
                "---".repeat(20);
    }

    public double getAttackPrim() {
        return attack;
    }
}