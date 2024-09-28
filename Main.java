import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Battleship.gameBoard();
        Battleship.placeShips();
        boolean playing = true;

        String[] leaders = {"Iven - 310", "Schmidty bang bang - 295", "Good Luck Charlie -" +
                " 285", "Matthew - 280", "Charles Edwards - 280", "Sean - 270" , "Vicky Calvin - " +
                "265", "Nathan - 230"};

        println("Welcome to Battleship!\n");
        leaderboard(leaders);
        how();
        play(playing, scan);
        results();
    }

    public static void how() {
        println("HOW TO PLAY:");
        println("There are seven ships: ");
        println("Dinghy(1), Destroyer(2), Frigate(2), Cruiser(3), Submarine(3), Battleship(4), " +
                "Carrier" +
                "(5)");
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

    public static void leaderboard(String[] leaders) {
        println("Leaderboard:");

        for (int i = 0; i < leaders.length; i++) {
            println((i+1)+". "+leaders[i]);

        }
        println("");
    }

    public static void play(boolean playing, Scanner scan) {
        while (playing) {
            println("");
            Battleship.printBoard();
            println("");
            System.out.print("ENTER A COORDINATE: ");

            //Deals with user input
            String row = "";
            int col = 0;
            String userInput = scan.nextLine();
            userInput = userInput.toUpperCase();
            if (userInput.equals("EXIT")){
                playing = false;
                break;
            }
            if (userInput.length() > 2){
                println("Enter a valid coordinate.");
                Battleship.checkSunks();
                Battleship.printActive();
                Battleship.printSunk();
                println("Score: " + Battleship.getScore());
                println("Streak: " + Battleship.getStreak());
                println("Hit Rate: " + Battleship.hitrate() + "%");
            } else {
                //Try and catch statements to prevent code breaking if something invalid is entered.
                try {
                    row = userInput.substring(0, 1);
                } catch (StringIndexOutOfBoundsException e) {
                    println("ENTER A VALID COORDINATE. ");
                    Battleship.checkSunks();
                    Battleship.printActive();
                    Battleship.printSunk();
                    println("Score: " + Battleship.getScore());
                    println("Streak: " + Battleship.getStreak());
                    println("Hit Rate: " + Battleship.hitrate() + "%");
                }
                try {
                    col = Integer.parseInt(userInput.substring(1, 2));
                    println(Battleship.playerGuess(row, col));
                    Battleship.checkSunks();
                    Battleship.printActive();
                    Battleship.printSunk();
                    println("Score: " + Battleship.getScore());
                    println("Streak: " + Battleship.getStreak());
                    println("Hit Rate: " + Battleship.hitrate() + "%");
                } catch (NumberFormatException e) {
                    println("ENTER A VALID COORDINATE. ");
                    Battleship.checkSunks();
                    Battleship.printActive();
                    Battleship.printSunk();
                    println("Score: " + Battleship.getScore());
                    println("Streak: " + Battleship.getStreak());
                    println("Hit Rate: " + Battleship.hitrate() + "%");
                } catch (StringIndexOutOfBoundsException e) {
                    println("ENTER A VALID COORDINATE. ");
                    Battleship.checkSunks();
                    Battleship.printActive();
                    Battleship.printSunk();
                    println("Score: " + Battleship.getScore());
                    println("Streak: " + Battleship.getStreak());
                    println("Hit Rate: " + Battleship.hitrate() + "%");
                }
            }

            //Victory
            if (Battleship.checkSunks() == 7){
                playing = false;
                println("");
                Battleship.printBoard();
                println("\nYOU SUNK ALL SHIPS! (+50 Score!)");
                Battleship.scoreBonus(50);
                break;
            }
        }

    }

    public static void results() {
        //Print results
        println("\nYour stats:");
        println("You landed " + Battleship.getHit() + " shots.");
        println("You missed " + Battleship.getMiss() + " shots.");
        println("Your hitrate was " + Battleship.hitrate() + "% (+" + Battleship.hitrateBonus() +
                " " +
                "Score).");
        Battleship.scoreBonus(Battleship.hitrateBonus());
        println("Your highest streak is " + Battleship.getBestStreak() + ".");
        println("Your score is " + Battleship.getScore() + ".\n");
        println("Thank you for playing!");
    }

    public static void println(String text){
        System.out.println(text);
    }
}