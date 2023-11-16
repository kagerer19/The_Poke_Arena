package org.pokemon;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class GameBattle {
    private final Scanner scanner = new Scanner(System.in);
    private boolean statusGame = false;
    private Pokemon playerPokemon;
    private Pokemon AIPokemon;
    private final Random random = new Random();
    private int round = 1;

    public void TheArena() {
        poke_data pokemons = new poke_data();
        poke_data attacks = new poke_data();

        playerPokemon = pokemons.getRandomPokemon();
        playerPokemon.setAttackPrim(attacks.getRandomAttack());
        playerPokemon.setAttackSec(attacks.getRandomAttack());

        AIPokemon = pokemons.getRandomPokemon();
        AIPokemon.setAttackPrim(attacks.getRandomAttack());
        AIPokemon.setAttackSec(attacks.getRandomAttack());

        System.out.println("Your Pokemon: " + playerPokemon.getName());
        System.out.println("Primary Attack: " + playerPokemon.getAttackPrim().getName());
        System.out.println("Secondary Attack: " + playerPokemon.getAttackSec().getName());
        System.out.println("--".repeat(15));
        System.out.println("AI Pokemon: " + AIPokemon.getName());
        System.out.println("Primary Attack: " + AIPokemon.getAttackPrim().getName());
        System.out.println("Secondary Attack: " + AIPokemon.getAttackSec().getName());
        System.out.println("--".repeat(15));
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

    public void startBattle() {
        welcome();
        TheArena();

        while (!statusGame) {
            if (playerPokemon.getSpeed() >= AIPokemon.getSpeed()) {
                attackPlayer();
                if (AIPokemon.getHp() <= 0) {
                    statusGame = true;
                    System.out.println("GAME OVER, Player is the WINNER!  ");
                    break;
                }

                attackAI();
                if (playerPokemon.getHp() <= 0) {
                    statusGame = true;
                    System.out.println("GAME OVER, AI is the WINNER!  ");
                    break;
                }
            } else {
                attackAI();
                if (playerPokemon.getHp() <= 0) {
                    statusGame = true;
                    System.out.println("GAME OVER, AI is the WINNER!  ");
                    break;
                }

                attackPlayer();
                if (AIPokemon.getHp() <= 0) {
                    statusGame = true;
                    System.out.println("GAME OVER, Player is the WINNER!  ");
                    break;
                }
            }
        }

        scanner.close();
    }

    private void attackAI() {
        double damage;
        int attackOption = random.nextInt(2) + 1;
        if (attackOption == 1) {
            damage = (AIPokemon.getAttackPrim().getPower() * ((double) AIPokemon.getAttack() / playerPokemon.getDefense()) * (1.0 / 25.0));
            playerPokemon.setHp(playerPokemon.getHp() - damage);
            System.out.println("AI used " + AIPokemon.getAttackPrim().getName());
        } else if (attackOption == 2) {
            damage = (int) (AIPokemon.getAttackSec().getPower() * (AIPokemon.getAttack() / playerPokemon.getDefense()) * (1.0 / 25.0));
            playerPokemon.setHp(playerPokemon.getHp() - damage);
            System.out.println("AI used " + AIPokemon.getAttackSec().getName());
        } else
            System.out.println("Invalid option. Try again.");

        System.out.println("Your HP: " + (int) playerPokemon.getHp());
    }

    private void attackPlayer() {
        int attackOption;
        double damage;

        System.out.println("Your Pokemon: " + playerPokemon.getName());
        System.out.println("--".repeat(15));
        System.out.println("Player, Whats your attack gonna be!?  ");
        System.out.println("--".repeat(15));
        System.out.println("Primary Attack: " + playerPokemon.getAttackPrim().getName() + " : Option 1");
        System.out.println("Secondary Attack: " + playerPokemon.getAttackSec().getName() + " : Option 2");
        System.out.println("--".repeat(15));

        while (true) {
            if (scanner.hasNextInt()) {
                attackOption = scanner.nextInt();
                if (attackOption == 1 || attackOption == 2)
                    break;
                else
                    System.out.println("Invalid attack option. Try again.");
            } else {
                scanner.next(); // consume invalid input
                System.out.println("Invalid input. Please enter a number.");
            }
        }

        if (attackOption == 1) {
            damage = (playerPokemon.getAttackPrim().getPower() * ((double) playerPokemon.getAttack() / AIPokemon.getDefense()) * (1.0 / 25.0));
            AIPokemon.setHp(AIPokemon.getHp() - damage);
            System.out.println("You used " + playerPokemon.getAttackPrim().getName());
        } else if (attackOption == 2) {
            damage = (playerPokemon.getAttackSec().getPower() * ((double) playerPokemon.getAttack() / AIPokemon.getDefense()) * (1.0 / 25.0));
            AIPokemon.setHp(AIPokemon.getHp() - damage);
            System.out.println("You used " + playerPokemon.getAttackSec().getName());
        }
        System.out.println("AI HP " + (int) AIPokemon.getHp());
    }
}
