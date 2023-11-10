package org.pokemon;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;

public class GameBattle {
    private Pokemon playerPokemon;
    private Pokemon AIPokemon;
    static final HashMap<Integer, Attacks> PrimaryAttacksMap = new HashMap<>();
    static final HashMap<Integer, Attacks> SecondaryAttacksMap = new HashMap<>();
    private final int round = 1;
    poke_data d = new poke_data();
    Random rand = new Random();
    Scanner ssc = new Scanner(System.in);
    boolean gameOver = false;

    public GameBattle() {
    }

    static void welcome() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("src/main/poke_art/pokeArt.csv"));
            String currentLine;
            while ((currentLine = reader.readLine()) != null) {
                System.out.println(currentLine);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void gameInformation() {
        d.getPokemon();
        d.getAttacks();
        GameBattle.welcome();


        System.out.println("Choose a pokemon by ID or By name....if you even know all 150 pokemon participating in this arena battle.");
        String userChoice = ssc.next();

        System.out.println(d.getPokemonByNameOrID(userChoice));

        System.out.println(d.getRandomAttack().showAbilities());
        System.out.println(d.getRandomAttack().showAbilities());
        System.out.println("Choose a Primary attack.");
        userChoice = ssc.next();

        System.out.println("Choose a Secondary attack.");
        userChoice = ssc.next();

        d.grabPrimaryAttack(userChoice);
        d.grabSecondaryAttack(userChoice);
    }


    public void startBattle() {
        gameInformation();

        while (!gameOver) {
            if (playerPokemon.getSpeedAttack() >= AIPokemon.getSpeedAttack()) {
                attackPlayer();
                if (AIPokemon.getHp() <= 0) {
                    gameOver = true;
                    System.out.println("\nThe Battle is over, Player is the WINNER!\n");
                    System.out.println("GG'S in the chat");
                    break;
                }

                attackAI();
                if (playerPokemon.getHp() <= 0) {
                    gameOver = true;
                    System.out.println("\nThe Battle is over, AI is the WINNER!\n");
                    System.out.println("BG'S in the chat");
                    break;
                }
            } else {
                attackAI();
                if (playerPokemon.getHp() <= 0) {
                    gameOver = true;
                    System.out.println("\nThe Battle is over, AI is the WINNER!\n");
                    System.out.println("BG'S in the chat");
                    break;
                }

                attackPlayer();
                if (AIPokemon.getHp() <= 0) {
                    gameOver = true;
                    System.out.println("\nThe Battle is over, Player is the WINNER!\n");
                    System.out.println("GG'S in the chat");
                    break;
                }
            }
        }
    }

    private void attackAI() {
        double damage;
        int attackOption = rand.nextInt(2) + 1;

        if (attackOption == 1) {
            if (AIPokemon.getPrimaryAttack() != null) {
                damage = Double.parseDouble(AIPokemon.getPrimaryAttack() + AIPokemon.getTotal() * (AIPokemon.getAttack() / playerPokemon.getDefense()) * (1.0 / 25.0));
                playerPokemon.setHp(playerPokemon.getHp() - damage);
                System.out.println("\nOpponent used " + AIPokemon.getPrimaryAttack() + AIPokemon.getPokemonName() + " and dealt " + (int) damage + " damage.");
            } else {
                System.out.println("AI Pokemon's primary attack is null. Cannot perform the attack.");
            }
        } else if (attackOption == 2) {
            if (AIPokemon.getSecondaryAttack() != null) {
                damage = Double.parseDouble(AIPokemon.getSecondaryAttack() + AIPokemon.getTotal() * (AIPokemon.getAttack() / playerPokemon.getDefense()) * (1.0 / 25.0));
                playerPokemon.setHp(playerPokemon.getHp() - damage);
                System.out.println("\nOpponent used " + AIPokemon.getSecondaryAttack() + AIPokemon.getPokemonName() + " and dealt " + (int) damage + " damage.");
            } else {
                System.out.println("AI Pokemon's secondary attack is null. Cannot perform the attack.");
            }
        } else {
            System.out.println("Invalid attack option. Try again.");
        }

        System.out.println("Player's HP: " + (int) playerPokemon.getHp());
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    private void attackPlayer() {
        int attackOption;
        double damage;
        System.out.println("\n         +--+--+--+--+--+--+--+--+");
        System.out.println("Player's Pokemon: " + playerPokemon.getPokemonName());
        System.out.println("                    -----");
        System.out.println("\nPlayer, choose your attack!\n");
        System.out.println("To use Primary Attack: " + playerPokemon.getAttackPrim() + playerPokemon.getPokemonName() + "  press 1");
        System.out.println("To use Secondary Attack: " + playerPokemon.getSecondaryAttack() + playerPokemon.getPokemonName() + "  press 2");
        System.out.println("\n         +--+--+--+--+--+--+--+--+\n");

        while (true) {
            if (ssc.hasNextInt()) {
                attackOption = ssc.nextInt();
                if (attackOption == 1 || attackOption == 2)
                    break;
            } else {
                System.out.println("Invalid attack option. Try again.");
            }
        }

        if (attackOption == 1) {
            damage = (playerPokemon.getAttackPrim() + playerPokemon.getTotal() * (playerPokemon.getAttack() / AIPokemon.getDefense()) * (1.0 / 25.0));
            AIPokemon.setHp(AIPokemon.getHp() - damage);
            System.out.println("\nPlayer used " + playerPokemon.getAttackPrim() + playerPokemon.getPokemonName());
        } else if (attackOption == 2) {
            damage = Double.parseDouble((playerPokemon.getSecondaryAttack() + playerPokemon.getTotal() * (playerPokemon.getAttack() / AIPokemon.getDefense()) * (1.0 / 25.0)));
            AIPokemon.setHp(AIPokemon.getHp() - damage);
            System.out.println("\nPlayer used " + playerPokemon.getSecondaryAttack() + playerPokemon.getPokemonName());
        }

        System.out.println("Opponent's HP: " + (int) AIPokemon.getHp());
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
