package org.pokemon;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

class poke_data {
    final HashMap<Integer, Pokemon> pokemonMap = new HashMap<>();
    final HashMap<Integer, Attacks> attacksMap = new HashMap<>();

    final void getPokemon() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("poke_stats.csv"));
            String currentLine;
            while ((currentLine = reader.readLine()) != null) {
                String[] values = currentLine.split(";");


                if (values.length >= 4) {
                    int id = Integer.parseInt(values[0]);
                    String name = values[1];
                    String type = values[2];
                    String kind = values[3];
                    double total = Double.parseDouble(values[4]);
                    double hp = Double.parseDouble(values[6]);
                    double attack = Double.parseDouble(values[6]);
                    double defense = Double.parseDouble(values[7]);
                    double speedAttack = Double.parseDouble(values[8]);
                    double speedDefense = Double.parseDouble(values[9]);
                    double speed = Double.parseDouble(values[10]);

                    Pokemon pokemon = new Pokemon(id, name, type, kind, total, hp, attack, defense, speedAttack, speedDefense, speed);
                    pokemonMap.put(id, pokemon);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    final void getAttacks() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("Attacks.csv"));
            String currentLine;
            reader.readLine();
            while ((currentLine = reader.readLine()) != null) {
                String[] values = currentLine.split(";");

                if (values.length >= 8) {
                    int id = Integer.parseInt(values[0]);
                    String name = values[1];
                    String effect = values[2];
                    String type = values[3];
                    String kind = values[4];
                    int power = extractNumericValue(values[5]);
                    int accuracy = extractNumericValue(values[6]);
                    int powerPoints = extractNumericValue(values[7]);

                    Attacks attacks = new Attacks(id, name, effect, type, kind, power, accuracy, powerPoints);
                    attacksMap.put(id, attacks);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Pokemon getPokemonByNameOrID(String user_pokemon) throws NullPointerException {
        for (HashMap.Entry<Integer, Pokemon> userChoice : pokemonMap.entrySet()) {
            Pokemon pokemon = userChoice.getValue();
            if (user_pokemon.equals(pokemon.getPokemonName()) || user_pokemon.equals(String.valueOf(userChoice.getKey()))) {
                return pokemon;
            }
        }
        throw new NullPointerException("Pokemon not found");
    }

    public Attacks grabPrimaryAttack(String user_att_choice) throws NullPointerException {
        for (HashMap.Entry<Integer, Attacks> userChoice : attacksMap.entrySet()) {
            Attacks attack = userChoice.getValue();
            if (user_att_choice.equals(attack.getAttackName()) || user_att_choice.equals(String.valueOf(userChoice.getKey()))) {
                GameBattle.PrimaryAttacksMap.put(attack.getAttackID(), attack);
                return attack;
            }
        }
        throw new NullPointerException("Attack not found");
    }

    public Attacks grabSecondaryAttack(String user_att_secondary_choice) throws NullPointerException {
        for (HashMap.Entry<Integer, Attacks> userChoice2 : attacksMap.entrySet()) {
            Attacks attack = userChoice2.getValue();
            if (user_att_secondary_choice.equals(attack.getAttackName()) || user_att_secondary_choice.equals(String.valueOf(userChoice2.getKey()))) {
                GameBattle.SecondaryAttacksMap.put(attack.getAttackID(), attack);
                return attack;
            }
        }
        throw new NullPointerException("Attack not found");
    }
    public Attacks getRandomAttack() {
        if (attacksMap.isEmpty()) {
            throw new NullPointerException("There are no attacks right now!");
        }

        Random rand = new Random();
        int randomAttackIndex = rand.nextInt(attacksMap.size());
        return attacksMap.get(randomAttackIndex);
    }

    private int extractNumericValue(String valueWithNonNumericChars) {
        // Remove non-numeric characters and parse as an integer
        String numericValue = valueWithNonNumericChars.replaceAll("[^0-9]", "");
        return Integer.parseInt(numericValue);
    }


    //for testing
    public void printPokemonData() {
        for (HashMap.Entry<Integer, Pokemon> entry : pokemonMap.entrySet()) {
            Pokemon pokemon = entry.getValue();
            System.out.println(pokemon.toString());
        }
    }

    public void printAttackData() {
        for (HashMap.Entry<Integer, Attacks> entry : attacksMap.entrySet()) {
            Attacks attack = entry.getValue();
            System.out.println(attack.showAbilities());
        }
    }
}
