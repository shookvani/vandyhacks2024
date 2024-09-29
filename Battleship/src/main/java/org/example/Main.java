package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        boolean playing = true;

        GameSetup.printLeaderboard();

        //Instructions
        GameSetup.how();

        //Obtains username from user
        GameSetup.println("Enter your username: ");
        String user = scan.nextLine();

        //User selects difficulty, then play method decides what difficulty is being used.
        String difficulty = GameSetup.selectDifficulty(scan);
        GameSetup.setAndPlace(difficulty);
        GameSetup.play(playing, scan, difficulty);

        //Final results + insert to database!
        GameSetup.results(difficulty);
        GameSetup.insertLeaderboard(user,difficulty);
        GameSetup.println("Your results were recorded.");
    }
}