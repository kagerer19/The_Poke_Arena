package org.pokemon;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class poke_data {
    public static final String POKEMON_CSV_FILE_PATH = "poke_stats.csv";
    public static final String ATTACK_CSV_FILE_PATH = "Attacks.csv";

    private final Map<Integer, Pokemon> pokemons;
    private final Map<Integer, Attacks> attacks;

    public poke_data() {
        pokemons = new HashMap<>();
        attacks = new HashMap<>();
    }

    public void IngestPokemon() {
        try (BufferedReader reader = new BufferedReader(new FileReader(POKEMON_CSV_FILE_PATH))) {
            reader.readLine(); // Consume first like
            String currentLine;

            while ((currentLine = reader.readLine()) != null) {
                String[] column = currentLine.split(";");
                if (column.length >= 11) {
                    int id = Integer.parseInt(column[0]);
                    String name = column[1];
                    String type1 = column[2];
                    String type2 = column[3];
                    int total = Integer.parseInt(column[4]);
                    int hp = Integer.parseInt(column[5]);
                    int attack = Integer.parseInt(column[6]);
                    int defense = Integer.parseInt(column[7]);
                    int spAtk = Integer.parseInt(column[8]);
                    int spDef = Integer.parseInt(column[9]);
                    int speed = Integer.parseInt(column[10]);

                    Pokemon pokemon = new Pokemon(id, name, type1, type2, total, hp, attack, defense, spAtk, spDef, speed);
                    pokemons.put(id, pokemon);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void IngestAttack() {
        try (BufferedReader reader = new BufferedReader(new FileReader(ATTACK_CSV_FILE_PATH))) {
            reader.readLine(); // Consume first like
            String currentLine;

            while ((currentLine = reader.readLine()) != null) {
                String[] parts = currentLine.split(";");
                if (parts.length >= 8) {
                    int id = Integer.parseInt(parts[0]);
                    String name = parts[1];
                    String effect = parts[2];
                    String type = parts[3];
                    String kind = parts[4];
                    int power = Integer.parseInt(parts[5]);
                    String accuracy = parts[6];
                    int pp = Integer.parseInt(parts[7]);

                    Attacks attack = new Attacks(id, name, effect, type, kind, power, accuracy, pp);
                    attacks.put(id, attack);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Pokemon getRandomPokemon() {
        IngestPokemon();
        if (pokemons.isEmpty())
            throw new IllegalStateException("Error retrieving Data");

        int randomIndex = new Random().nextInt(pokemons.size());
        return new ArrayList<>(pokemons.values()).get(randomIndex);
    }

    public Attacks getRandomAttack() {
        IngestAttack();
        if (attacks.isEmpty())
            throw new IllegalStateException("Error retrieving Data");

        int randomAttackIndex = new Random().nextInt(attacks.size());
        return new ArrayList<>(attacks.values()).get(randomAttackIndex);
    }

}
