import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Battleship.gameBoard();
        Battleship.placeShips();
        boolean playing = true;

        GameSetup.println("Welcome to Battleship!\n");
        System.out.print("Please enter your player name: ");
        Battleship.playerName = scan.nextLine();
        System.out.println("");
        GameSetup.leaderboard(Battleship.getLeaders());
        GameSetup.how();
        GameSetup.play(playing, scan);
        Battleship.getLeadersUpdate();
        GameSetup.leaderboard(Battleship.getLeaders());
        GameSetup.results();
    }

}
