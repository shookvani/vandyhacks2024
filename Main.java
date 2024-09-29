import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        boolean playing = true;

        String[] leaders = {"Iven - 310", "Schmidty bang bang - 295", "Good Luck Charlie -" +
                " 285", "Matthew - 280", "Charles Edwards - 280", "Sean - 270" , "Vicky Calvin - " +
                "265", "Nathan - 230"};

        GameSetup.println("Welcome to Battleship!\n");
        GameSetup.leaderboard(leaders);
        GameSetup.how();
        //User selects difficulty, then play method decides what difficulty is being used.
        String difficulty = GameSetup.selectDifficulty(scan);
        GameSetup.setAndPlace(difficulty);
        GameSetup.play(playing, scan, difficulty);

        GameSetup.results(difficulty);
    }
}
