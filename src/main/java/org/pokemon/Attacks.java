package org.pokemon;


class Attacks {
    private int attackID;
    private String attackName;
    private String attackEffect;
    private String attackType;
    private String attackKind;
    private int attackPower;
    private int attackAccuracy;
    private int attackPoints;


    Attacks(int ID, String name, String effect, String type, String kind, int power, int accuracy, int powerPoints) {
        setAttackID(ID);
        setAttackName(name);
        setAttackType(effect);
        setAttackEffect(type);
        setAttackKind(kind);
        setAttackPower(power);
        setAttackAccuracy(accuracy);
        setAttackPoints(powerPoints);
    }


    public String getAttackKind() {
        return attackKind;
    }

    public int getAttackPower() {
        return attackPower;
    }
    public int getAttackAccuracy() {
        return attackAccuracy;
    }

    public int getAttackPoints() {
        return attackPoints;
    }

    public int getAttackID() {
        return attackID;
    }

    public String getAttackName() {
        return attackName;
    }

    public String getAttackType() {
        return attackType;
    }

    public String getAttackEffect() {
        return attackEffect;
    }

    public void setAttackPower(int attackPower) {
        this.attackPower = attackPower;
    }

    public void setAttackAccuracy(int attackAccuracy) {
        this.attackAccuracy = attackAccuracy;
    }

    public void setAttackPoints(int attackPoints) {
        this.attackPoints = attackPoints;
    }


    public void setAttackID(int attackID) {
        this.attackID = attackID;
    }

    public void setAttackName(String pokemonName) {
        this.attackName = pokemonName;
    }

    public void setAttackEffect(String kind) {
        this.attackEffect = kind;
    }

    public void setAttackType(String type) {
        this.attackType = type;
    }

    public void setAttackKind(String type) {
        this.attackKind = type;
    }


    public String showAbilities() {

        return "Attack-ID: " + getAttackID() + "\n" +
                "Attack: " + getAttackName() +  "\n" +
                "Effect: " + getAttackEffect() + "\n" +
                "Type: " + getAttackType() + "\n" +
                "Kind: " + getAttackKind() + "\n" +
                "Power: " + getAttackPower() + "\n" +
                "Accuracy: " + getAttackAccuracy() + "%" + "\n" +
                "Attack Point: " + getAttackPoints() + "\n";
    }
}
