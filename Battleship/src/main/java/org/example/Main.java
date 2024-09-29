package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        boolean playing = true;
        int finalScore = 0;
        double finalHR = 0.0;

        String[] leaders = {"Iven - 310", "Schmidty bang bang - 295", "Good Luck Charlie -" +
                " 285", "Matthew - 280", "Charles Edwards - 280", "Sean - 270" , "Vicky Calvin - " +
                "265", "Nathan - 230"};

        GameSetup.println("Welcome to Battleship!\n");
        GameSetup.leaderboard(leaders);
        GameSetup.how();

        //Obtains username from user
        GameSetup.println("Enter your username: ");
        String user = scan.nextLine();

        //User selects difficulty, then play method decides what difficulty is being used.
        String difficulty = GameSetup.selectDifficulty(scan);
        GameSetup.setAndPlace(difficulty);
        GameSetup.play(playing, scan, difficulty);

        GameSetup.results(difficulty);

        switch (difficulty){
            case "Hard":
                finalScore = HardBattleship.getScore();
                finalHR = HardBattleship.hitrate();
                break;
            case "Medium":
                finalScore = MediumBattleship.getScore();
                finalHR = MediumBattleship.hitrate();
                break;
            case "Easy":
                finalScore = EasyBattleship.getScore();
                finalHR = EasyBattleship.hitrate();
                break;
        }
        Database.insert(user, finalScore, finalHR, difficulty);

    }
}