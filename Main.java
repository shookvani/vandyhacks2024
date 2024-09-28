import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Battleship.gameBoard();
        Battleship.placeShips();
        boolean playing = true;

        GameSetup.println("Welcome to Battleship!\n");
        GameSetup.leaderboard(Battleship.getLeaders());
        GameSetup.how();
        GameSetup.play(playing, scan);
        GameSetup.results();
    }

}
