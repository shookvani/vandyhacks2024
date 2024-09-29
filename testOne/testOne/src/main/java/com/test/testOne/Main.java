package com.test.testOne;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Scanner;

@RestController
@RequestMapping("/start")
public class Main {

    @GetMapping("/game")
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