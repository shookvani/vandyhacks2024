import java.util.Scanner;

public class GameSetup {

    public static void setAndPlace(String difficulty){
        switch (difficulty){
            case "Hard":
                HardBattleship.gameBoard();
                HardBattleship.placeShips();
            case "Medium":
                MediumBattleship.gameBoard();
                MediumBattleship.placeShips();
            case "Easy":
                EasyBattleship.gameBoard();
                EasyBattleship.placeShips();
        }
    }

    public static void how() {
        println("HOW TO PLAY:");
        println("There are seven possible ships: ");
        println("Dinghy(1), Destroyer(2), Frigate(2), Cruiser(3), Submarine(3), Battleship(4), " +
                "Carrier(5)");
        println("The game ends when you sunk all ships or quit.");
        println("Note: Ships can be placed right next to each other.");
        println("Your score will be determined by your hits (+5 Score), hit streaks (+[5*Streak])" +
                "," +
                " " +
                "and" +
                " " +
                "final hit rate (+0-30 Score; only if all ships are sunk).");
        println("O = hit");
        println("X = miss");
        println("Enter a coordinate (Ex. A0) to shoot at or enter 'EXIT' to quit.");
    }

    public static String selectDifficulty(Scanner scan){
        println("Pick your difficulty: Easy, Medium, Hard");
        String difficulty = scan.nextLine().toLowerCase();

        switch (difficulty){
            case "easy":
                return "Easy";
            case "medium":
                return "Medium";
            case "hard":
                return "Hard";
            default:
                println("ENTER A VALID DIFFICULTY.");
                return selectDifficulty(scan);
        }
    }

    public static void leaderboard(String[] leaders) {
        println("Leaderboard:");

        for (int i = 0; i < leaders.length; i++) {
            println((i+1)+". "+leaders[i]);

        }
        println("");
    }

    public static void play(boolean playing, Scanner scan, String difficulty) {
        String row;
        int col;
        String userInput;
        while (playing) {
            switch (difficulty){
                case "Hard":
                    println("");
                    HardBattleship.printBoard();
                    println("");
                    System.out.print("ENTER A COORDINATE: ");

                    //Deals with user input
                    row = "";
                    col = 0;
                    userInput = scan.nextLine();
                    userInput = userInput.toUpperCase();
                    if (userInput.equals("EXIT")){
                        playing = false;
                        break;
                    }
                    if (userInput.length() > 2){
                        println("ENTER A VALID COORDINATE.");
                        HardBattleship.checkSunks();
                        HardBattleship.printActive();
                        HardBattleship.printSunk();
                        println("Score: " + HardBattleship.getScore());
                        println("Streak: " + HardBattleship.getStreak());
                        println("Hit Rate: " + HardBattleship.hitrate() + "%");
                    } else {
                        //Try and catch statements to prevent code breaking if something invalid is entered.
                        try {
                            row = userInput.substring(0, 1);
                        } catch (StringIndexOutOfBoundsException e) {
                            println("ENTER A VALID COORDINATE. ");
                            HardBattleship.checkSunks();
                            HardBattleship.printActive();
                            HardBattleship.printSunk();
                            println("Score: " + HardBattleship.getScore());
                            println("Streak: " + HardBattleship.getStreak());
                            println("Hit Rate: " + HardBattleship.hitrate() + "%");
                        }
                        try {
                            col = Integer.parseInt(userInput.substring(1, 2));
                            println(HardBattleship.playerGuess(row, col));
                            HardBattleship.checkSunks();
                            HardBattleship.printActive();
                            HardBattleship.printSunk();
                            println("Score: " + HardBattleship.getScore());
                            println("Streak: " + HardBattleship.getStreak());
                            println("Hit Rate: " + HardBattleship.hitrate() + "%");
                        } catch (NumberFormatException e) {
                            println("ENTER A VALID COORDINATE. ");
                            HardBattleship.checkSunks();
                            HardBattleship.printActive();
                            HardBattleship.printSunk();
                            println("Score: " + HardBattleship.getScore());
                            println("Streak: " + HardBattleship.getStreak());
                            println("Hit Rate: " + HardBattleship.hitrate() + "%");
                        } catch (StringIndexOutOfBoundsException e) {
                            println("ENTER A VALID COORDINATE. ");
                            HardBattleship.checkSunks();
                            HardBattleship.printActive();
                            HardBattleship.printSunk();
                            println("Score: " + HardBattleship.getScore());
                            println("Streak: " + HardBattleship.getStreak());
                            println("Hit Rate: " + HardBattleship.hitrate() + "%");
                        }
                    }

                    //Victory
                    if (HardBattleship.checkSunks() == 7){
                        playing = false;
                        println("");
                        HardBattleship.printBoard();
                        println("\nYOU SUNK ALL SHIPS! (+50 Score!)");
                        HardBattleship.scoreBonus(50);
                        break;
                    }
                case "Medium":
                    //I can only assume for some reason the switch statements isn't switching right,
                    //which requires an extra conditional to prevent repeat results.
                    if (!difficulty.equals("Medium")){
                        continue;
                    }
                    println("");
                    MediumBattleship.printBoard();
                    println("");
                    System.out.print("ENTER A COORDINATE: ");

                    //Deals with user input
                    row = "";
                    col = 0;
                    userInput = scan.nextLine();
                    userInput = userInput.toUpperCase();
                    if (userInput.equals("EXIT")){
                        playing = false;
                        break;
                    }
                    if (userInput.length() > 2){
                        println("ENTER A VALID COORDINATE.");
                        MediumBattleship.checkSunks();
                        MediumBattleship.printActive();
                        MediumBattleship.printSunk();
                        println("Score: " + MediumBattleship.getScore());
                        println("Streak: " + MediumBattleship.getStreak());
                        println("Hit Rate: " + MediumBattleship.hitrate() + "%");
                    } else {
                        //Try and catch statements to prevent code breaking if something invalid is entered.
                        try {
                            row = userInput.substring(0, 1);
                        } catch (StringIndexOutOfBoundsException e) {
                            println("ENTER A VALID COORDINATE. ");
                            MediumBattleship.checkSunks();
                            MediumBattleship.printActive();
                            MediumBattleship.printSunk();
                            println("Score: " + MediumBattleship.getScore());
                            println("Streak: " + MediumBattleship.getStreak());
                            println("Hit Rate: " + MediumBattleship.hitrate() + "%");
                        }
                        try {
                            col = Integer.parseInt(userInput.substring(1, 2));
                            println(MediumBattleship.playerGuess(row, col));
                            MediumBattleship.checkSunks();
                            MediumBattleship.printActive();
                            MediumBattleship.printSunk();
                            println("Score: " + MediumBattleship.getScore());
                            println("Streak: " + MediumBattleship.getStreak());
                            println("Hit Rate: " + MediumBattleship.hitrate() + "%");
                        } catch (NumberFormatException e) {
                            println("ENTER A VALID COORDINATE. ");
                            MediumBattleship.checkSunks();
                            MediumBattleship.printActive();
                            MediumBattleship.printSunk();
                            println("Score: " + MediumBattleship.getScore());
                            println("Streak: " + MediumBattleship.getStreak());
                            println("Hit Rate: " + MediumBattleship.hitrate() + "%");
                        } catch (StringIndexOutOfBoundsException e) {
                            println("ENTER A VALID COORDINATE. ");
                            MediumBattleship.checkSunks();
                            MediumBattleship.printActive();
                            MediumBattleship.printSunk();
                            println("Score: " + MediumBattleship.getScore());
                            println("Streak: " + MediumBattleship.getStreak());
                            println("Hit Rate: " + MediumBattleship.hitrate() + "%");
                        }
                    }
                    //Victory
                    if (MediumBattleship.checkSunks() == 5){
                        playing = false;
                        println("");
                        MediumBattleship.printBoard();
                        println("\nYOU SUNK ALL SHIPS! (+50 Score!)");
                        MediumBattleship.scoreBonus(50);
                        break;
                    }
                case "Easy":
                    //I can only assume for some reason the switch statements isn't switching right,
                    //which requires an extra conditional to prevent repeat results.
                    if (!difficulty.equals("Easy")){
                        continue;
                    }
                    println("");
                    EasyBattleship.printBoard();
                    println("");
                    System.out.print("ENTER A COORDINATE: ");

                    //Deals with user input
                    row = "";
                    col = 0;
                    userInput = scan.nextLine();
                    userInput = userInput.toUpperCase();
                    if (userInput.equals("EXIT")){
                        playing = false;
                        break;
                    }
                    if (userInput.length() > 2){
                        println("ENTER A VALID COORDINATE.");
                        EasyBattleship.checkSunks();
                        EasyBattleship.printActive();
                        EasyBattleship.printSunk();
                        println("Score: " + EasyBattleship.getScore());
                        println("Streak: " + EasyBattleship.getStreak());
                        println("Hit Rate: " + EasyBattleship.hitrate() + "%");
                    } else {
                        //Try and catch statements to prevent code breaking if something invalid is entered.
                        try {
                            row = userInput.substring(0, 1);
                        } catch (StringIndexOutOfBoundsException e) {
                            println("ENTER A VALID COORDINATE. ");
                            EasyBattleship.checkSunks();
                            EasyBattleship.printActive();
                            EasyBattleship.printSunk();
                            println("Score: " + EasyBattleship.getScore());
                            println("Streak: " + EasyBattleship.getStreak());
                            println("Hit Rate: " + EasyBattleship.hitrate() + "%");
                        }
                        try {
                            col = Integer.parseInt(userInput.substring(1, 2));
                            println(EasyBattleship.playerGuess(row, col));
                            EasyBattleship.checkSunks();
                            EasyBattleship.printActive();
                            EasyBattleship.printSunk();
                            println("Score: " + EasyBattleship.getScore());
                            println("Streak: " + EasyBattleship.getStreak());
                            println("Hit Rate: " + EasyBattleship.hitrate() + "%");
                        } catch (NumberFormatException e) {
                            println("ENTER A VALID COORDINATE. ");
                            EasyBattleship.checkSunks();
                            EasyBattleship.printActive();
                            EasyBattleship.printSunk();
                            println("Score: " + EasyBattleship.getScore());
                            println("Streak: " + EasyBattleship.getStreak());
                            println("Hit Rate: " + EasyBattleship.hitrate() + "%");
                        } catch (StringIndexOutOfBoundsException e) {
                            println("ENTER A VALID COORDINATE. ");
                            EasyBattleship.checkSunks();
                            EasyBattleship.printActive();
                            EasyBattleship.printSunk();
                            println("Score: " + EasyBattleship.getScore());
                            println("Streak: " + EasyBattleship.getStreak());
                            println("Hit Rate: " + EasyBattleship.hitrate() + "%");
                        }
                    }

                    //Victory
                    if (EasyBattleship.checkSunks() == 4){
                        playing = false;
                        println("");
                        EasyBattleship.printBoard();
                        println("\nYOU SUNK ALL SHIPS! (+50 Score!)");
                        EasyBattleship.scoreBonus(50);
                        break;
                    }
            }
        }

    }

    public static void results(String difficulty) {
        //Print results
        switch (difficulty){
            case "Hard":
                println("\nYour stats:");
                println("You landed " + HardBattleship.getHit() + " shots.");
                println("You missed " + HardBattleship.getMiss() + " shots.");
                println("Your hitrate was " + HardBattleship.hitrate() + "% (+" + HardBattleship.hitrateBonus() +
                        " " +
                        "Score).");
                HardBattleship.scoreBonus(HardBattleship.hitrateBonus());
                println("Your highest streak is " + HardBattleship.getBestStreak() + ".");
                println("Your score is " + HardBattleship.getScore() + ".\n");
                println("Thank you for playing!");
            case "Medium":
                //I can only assume for some reason the switch statements isn't switching right,
                //which requires an extra conditional to prevent repeat results.
                if (!difficulty.equals("Medium")){
                    return;
                }
                println("\nYour stats:");
                println("You landed " + MediumBattleship.getHit() + " shots.");
                println("You missed " + MediumBattleship.getMiss() + " shots.");
                println("Your hitrate was " + MediumBattleship.hitrate() + "% (+" + MediumBattleship.hitrateBonus() +
                        " " +
                        "Score).");
                MediumBattleship.scoreBonus(MediumBattleship.hitrateBonus());
                println("Your highest streak is " + MediumBattleship.getBestStreak() + ".");
                println("Your score is " + MediumBattleship.getScore() + ".\n");
                println("Thank you for playing!");
            case "Easy":
                //I can only assume for some reason the switch statements isn't switching right,
                //which requires an extra conditional to prevent repeat results.
                if (!difficulty.equals("Easy")){
                    return;
                }
                println("\nYour stats:");
                println("You landed " + EasyBattleship.getHit() + " shots.");
                println("You missed " + EasyBattleship.getMiss() + " shots.");
                println("Your hitrate was " + EasyBattleship.hitrate() + "% (+" + EasyBattleship.hitrateBonus() +
                        " " +
                        "Score).");
                EasyBattleship.scoreBonus(EasyBattleship.hitrateBonus());
                println("Your highest streak is " + EasyBattleship.getBestStreak() + ".");
                println("Your score is " + EasyBattleship.getScore() + ".\n");
                println("Thank you for playing!");
        }


    }

    public static void println(String text){
        System.out.println(text);
    }
}