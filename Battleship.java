import java.util.*;
import java.io.*;

public class Battleship{
    //Instance variables and arrays
    private static String[][] board = new String[10][10];
    private static boolean[][] ships = new boolean[10][10];


    //All the ships
    private static int[] five = new int[3]; //Carrier
    private static int[] four = new int[3]; //Battleship
    private static int[] three = new int[3]; //Cruiser
    private static int[] three2 = new int[3]; //Submarine
    private static int[] two = new int[3]; //Destroyer
    private static int[] two2 = new int[3]; //Frigate
    private static int[] one = new int[2]; //Dinghy

    //Game stats
    public static String playerName ="";
    private static String[] leaderNames = {"Iven", "Schmidty bang bang", "Good Luck Charlie",
            "Matthew", "Charles Edwards", "Sean", "Vicky Calvin", "Nathan"};
    private static int[] leaderScores = {310,295, 285, 280, 275, 270, 265, 230};
    private static int score = 0;
    private static int hit = 0;
    private static int miss = 0;
    private static int streak = 0;
    private static int bestStreak = 0;
    private static boolean[] sunks = new boolean[7];
    private static int newSunks = 0;
    private static int allSunks = 0;

    //Set up boards
    public static void gameBoard(){
        for (int row = 0; row < board.length; row++){
            for (int col = 0; col < board[row].length; col++ ){
                board[row][col] = " ";
            }
        }
    }

    // Print guessing board
    public static void printBoard(){
        System.out.println("   0 1 2 3 4 5 6 7 8 9");
        for (int row = 0; row < board.length; row++){
            switch (row){
                case 0:
                    System.out.print("A |");
                    break;
                case 1:
                    System.out.print("B |");
                    break;
                case 2:
                    System.out.print("C |");
                    break;
                case 3:
                    System.out.print("D |");
                    break;
                case 4:
                    System.out.print("E |");
                    break;
                case 5:
                    System.out.print("F |");
                    break;
                case 6:
                    System.out.print("G |");
                    break;
                case 7:
                    System.out.print("H |");
                    break;
                case 8:
                    System.out.print("I |");
                    break;
                case 9:
                    System.out.print("J |");
                    break;
            }
            for (int col = 0; col < board[row].length; col++ ){
                System.out.print(board[row][col] + "|");
            }
            System.out.println();
        }
    }

    //Place ships
    public static void placeShips(){
        int rotate = (int)(Math.random()*2);
        int row;
        int col;

        //First Ship (two)
        //0 is vertical
        if (rotate == 0){
            row = (int)(Math.random()*9);
            col = (int)(Math.random()*10);
            ships[row][col] = true;
            ships[row+1][col] = true;
        }
        //1 is horizontal
        else {
            row = (int)(Math.random()*10);
            col = (int)(Math.random()*9);
            ships[row][col] = true;
            ships[row][col+1] = true;
        }

        two[0] = row;
        two[1] = col;
        two[2] = rotate;

        //Second Ship (four)
        rotate = (int)(Math.random()*2);

        //0 is vertical
        if (rotate == 0){
            while (ships[row][col] || ships[row+1][col] || ships[row+2][col] || ships[row+3][col]){
                row = (int)(Math.random()*7);
                col = (int)(Math.random()*10);
            }

            ships[row][col] = true;
            ships[row+1][col] = true;
            ships[row+2][col] = true;
            ships[row+3][col] = true;
        }
        //1 is horizontal
        else {
            while (ships[row][col] || ships[row][col+1] || ships[row][col+2] || ships[row][col+3]){
                row = (int)(Math.random()*10);
                col = (int)(Math.random()*7);
            }

            ships[row][col] = true;
            ships[row][col+1] = true;
            ships[row][col+2] = true;
            ships[row][col+3] = true;
        }

        four[0] = row;
        four[1] = col;
        four[2] = rotate;

        //Third Ship (three)
        rotate = (int)(Math.random()*2);

        //0 is vertical
        if (rotate == 0){
            while (ships[row][col] || ships[row+1][col] || ships[row+2][col]){
                row = (int)(Math.random()*8);
                col = (int)(Math.random()*10);
            }

            ships[row][col] = true;
            ships[row+1][col] = true;
            ships[row+2][col] = true;
        }
        //1 is horizontal
        else {
            while (ships[row][col] || ships[row][col+1] || ships[row][col+2]){
                row = (int)(Math.random()*10);
                col = (int)(Math.random()*8);
            }

            ships[row][col] = true;
            ships[row][col+1] = true;
            ships[row][col+2] = true;
        }

        three[0] = row;
        three[1] = col;
        three[2] = rotate;

        //Forth Ship (three2)
        rotate = (int)(Math.random()*2);

        //0 is vertical
        if (rotate == 0){
            while (ships[row][col] || ships[row+1][col] || ships[row+2][col]){
                row = (int)(Math.random()*8);
                col = (int)(Math.random()*10);
            }

            ships[row][col] = true;
            ships[row+1][col] = true;
            ships[row+2][col] = true;
        }
        //1 is horizontal
        else {
            while (ships[row][col] || ships[row][col+1] || ships[row][col+2]){
                row = (int)(Math.random()*10);
                col = (int)(Math.random()*8);
            }

            ships[row][col] = true;
            ships[row][col+1] = true;
            ships[row][col+2] = true;
        }

        three2[0] = row;
        three2[1] = col;
        three2[2] = rotate;

        //Fifth Ship (five)
        rotate = (int)(Math.random()*2);

        //0 is vertical
        if (rotate == 0){
            while (ships[row][col] || ships[row+1][col] || ships[row+2][col] || ships[row+3][col] || ships[row+4][col]){
                row = (int)(Math.random()*6);
                col = (int)(Math.random()*10);
            }

            ships[row][col] = true;
            ships[row+1][col] = true;
            ships[row+2][col] = true;
            ships[row+3][col] = true;
            ships[row+4][col] = true;
        }
        //1 is horizontal
        else {
            while (ships[row][col] || ships[row][col+1] || ships[row][col+2] || ships[row][col+3] || ships[row][col+4]){
                row = (int)(Math.random()*10);
                col = (int)(Math.random()*6);
            }

            ships[row][col] = true;
            ships[row][col+1] = true;
            ships[row][col+2] = true;
            ships[row][col+3] = true;
            ships[row][col+4] = true;
        }

        five[0] = row;
        five[1] = col;
        five[2] = rotate;

        //Sixth Ship (two2)
        rotate = (int)(Math.random()*2);

        if (rotate == 0){
            while (ships[row][col] || ships[row+1][col]){
                row = (int)(Math.random()*9);
                col = (int)(Math.random()*10);
            }
            ships[row][col] = true;
            ships[row+1][col] = true;
        }
        //1 is horizontal
        else {
            while (ships[row][col] || ships[row][col+1]){
                row = (int)(Math.random()*10);
                col = (int)(Math.random()*9);
            }
            ships[row][col] = true;
            ships[row][col+1] = true;
        }

        two2[0] = row;
        two2[1] = col;
        two2[2] = rotate;

        //Seventh Ship (one)
        //Orientation doesn't matter for single tile ship.
        while (ships[row][col]){
            row = (int)(Math.random()*10);
            col = (int)(Math.random()*10);
        }
        ships[row][col] = true;

        one[0] = row;
        one[1] = col;
    }

    public static String playerGuess(String tempRow, int tempCol){
        //Converts the String input of coordinate into an index on the 2D array.
        int row;
        switch (tempRow){
            case "A":
                row = 0;
                break;
            case "B":
                row = 1;
                break;
            case "C":
                row = 2;
                break;
            case "D":
                row = 3;
                break;
            case "E":
                row = 4;
                break;
            case "F":
                row = 5;
                break;
            case "G":
                row = 6;
                break;
            case "H":
                row = 7;
                break;
            case "I":
                row = 8;
                break;
            case "J":
                row = 9;
                break;
            default:
                return "Enter a valid coordinate.";
        }

        if (tempCol > 9 || tempCol < 0){
            return "Enter a valid coordinate.";
        }

        if(!(board[row][tempCol].equals(" "))){
            return "You have already shot at this coordinate.";
        }

        //Check hits
        if (ships[row][tempCol]){
            board[row][tempCol] = "O";
            streak++;
            hit++;
            score += streak*5;
            if (bestStreak < streak){
                bestStreak = streak;
            }
            return "Hit (+" + streak*5 + " Score!)";
        }

        //Default when miss
        board[row][tempCol] = "X";
        miss++;
        streak = 0;
        return "Miss (+0 Score)";
    }

    //Boolean methods to check which ships are sunk
    public static boolean sunkOne(){
        if (board[one[0]][one[1]].equals("O")){
            return true;
        }
        return false;
    }
    public static boolean sunkTwo(){
        if (two[2] == 0){
            if (board[two[0]][two[1]].equals("O") && board[two[0] + 1][two[1]].equals("O")){
                return true;
            }
        } else if (two[2] == 1){
            if (board[two[0]][two[1]].equals("O") && board[two[0]][two[1] + 1].equals("O")){
                return true;
            }
        }
        return false;
    }
    public static boolean sunkTwo2(){
        if (two2[2] == 0){
            if (board[two2[0]][two2[1]].equals("O") && board[two2[0] + 1][two2[1]].equals("O")){
                return true;
            }
        } else if (two2[2] == 1){
            if (board[two2[0]][two2[1]].equals("O") && board[two2[0]][two2[1] + 1].equals("O")){
                return true;
            }
        }
        return false;
    }
    public static boolean sunkThree(){
        if (three[2] == 0){
            if (board[three[0]][three[1]].equals("O") && board[three[0] + 1][three[1]].equals("O") && board[three[0] + 2][three[1]].equals("O")){
                return true;
            }
        } else if (three[2] == 1){
            if (board[three[0]][three[1]].equals("O") && board[three[0]][three[1] + 1].equals("O") && board[three[0]][three[1] + 2].equals("O")){
                return true;
            }
        }
        return false;
    }
    public static boolean sunkThree2(){
        if (three2[2] == 0){
            if (board[three2[0]][three2[1]].equals("O") && board[three2[0] + 1][three2[1]].equals("O") && board[three2[0] + 2][three2[1]].equals("O")){
                return true;
            }
        } else if (three2[2] == 1){
            if (board[three2[0]][three2[1]].equals("O") && board[three2[0]][three2[1] + 1].equals("O") && board[three2[0]][three2[1] + 2].equals("O")){
                return true;
            }
        }
        return false;
    }
    public static boolean sunkFour(){
        if (four[2] == 0){
            if (board[four[0]][four[1]].equals("O") && board[four[0] + 1][four[1]].equals("O") && board[four[0] + 2][four[1]].equals("O") && board[four[0] + 3][four[1]].equals("O")){
                return true;
            }
        } else if (four[2] == 1){
            if (board[four[0]][four[1]].equals("O") && board[four[0]][four[1] + 1].equals("O") && board[four[0]][four[1] + 2].equals("O") && board[four[0]][four[1] + 3].equals("O")){
                return true;
            }
        }
        return false;
    }
    public static boolean sunkFive(){
        if (five[2] == 0){
            if (board[five[0]][five[1]].equals("O") && board[five[0] + 1][five[1]].equals("O") && board[five[0] + 2][five[1]].equals("O") && board[five[0] + 3][five[1]].equals("O") && board[five[0]+4][five[1]].equals("O")){
                return true;
            }
        } else if (five[2] == 1){
            if (board[five[0]][five[1]].equals("O") && board[five[0]][five[1] + 1].equals("O") && board[five[0]][five[1] + 2].equals("O") && board[five[0]][five[1] + 3].equals("O") && board[five[0]][five[1]+4].equals("O")){
                return true;
            }
        }
        return false;
    }

    //Method to print sunk ships
    public static void printSunk(){
        System.out.print("Sunk Ships: ");
        if (sunkOne()){
            System.out.print("Dinghy(1) | ");
        }
        if (sunkTwo()){
            System.out.print("Destroyer(2) | ");
        }
        if (sunkTwo2()){
            System.out.print("Frigate(2) | ");
        }
        if (sunkThree()){
            System.out.print("Cruiser(3) | ");
        }
        if(sunkThree2()){
            System.out.print("Submarine(3) | ");
        }
        if (sunkFour()){
            System.out.print("Battleship(4) | ");
        }
        if (sunkFive()){
            System.out.print("Carrier(5) | ");
        }
        System.out.println();
    }

    public static void printActive(){
        System.out.print("Active Ships: ");
        if (!sunkOne()){
            System.out.print("Dinghy(1) | ");
        }
        if (!sunkTwo()){
            System.out.print("Destroyer(2) | ");
        }
        if (!sunkTwo2()){
            System.out.print("Frigate(2) | ");
        }
        if (!sunkThree()){
            System.out.print("Cruiser(3) | ");
        }
        if(!sunkThree2()){
            System.out.print("Submarine(3) | ");
        }
        if (!sunkFour()){
            System.out.print("Battleship(4) | ");
        }
        if (!sunkFive()){
            System.out.print("Carrier(5) | ");
        }
        System.out.println();
    }

    //Method to check how many ships was sunk.
    public static int checkSunks(){
        sunks[0] = sunkOne();
        sunks[1] = sunkTwo();
        sunks[2] = sunkTwo2();
        sunks[3] = sunkThree();
        sunks[4] = sunkThree2();
        sunks[5] = sunkFour();
        sunks[6] = sunkFive();

        newSunks = 0;
        for(int i = 0; i < sunks.length; i++){
            if (sunks[i]){
                newSunks++;
            }
        }
        if (allSunks < newSunks){
            allSunks = newSunks;
            System.out.println("YOU HAVE SUNK A SHIP! (+5 Score!)");
            score += 5;
        }
        return allSunks;
    }

    //Getters
    public static int getScore(){
        return score;
    }
    public static int getHit(){
        return hit;
    }
    public static int getMiss(){
        return miss;
    }
    public static int getStreak(){
        return streak;
    }
    public static int getBestStreak(){
        return bestStreak;
    }
    public static String[] getLeaderNames() {return leaderNames;}
    public static int[] getLeaderScores(){return leaderScores;}
    public static String[] getLeaders() {return leaders(leaderNames, leaderScores);}
    public static void getLeadersUpdate() {updateLeaders(leaderNames,leaderScores,score);}

    //Give a score bonus based on developer conditions.
    public static void scoreBonus(int bonus){
        if (!(allSunks == 7)){
            System.out.println("You did not sink all ships.");
        }
        score = score + bonus;
    }

    //Find hitrate and give bonus based on hitrate
    public static double hitrate(){
        if (hit == 0 && miss == 0){
            return 0;
        }
        //This massive mess will cut off at two decimal places.
        return ((int)(((double)hit/(hit+miss))*10000))/100.0;
    }
    public static int hitrateBonus(){
        if (!(allSunks==7)){
            return 0;
        }
        if (hitrate() > 50){
            return 30;
        }
        if (hitrate() > 45){
            return 25;
        }
        if (hitrate() > 40){
            return 20;
        }
        if (hitrate() > 35){
            return 15;
        }
        if (hitrate() > 30){
            return 10;
        }
        if (hitrate() > 25){
            return 5;
        }
        return 0;
    }

    //gets the entire leaderboard organized with scores & names
    private static String[] leaders(String[] names, int[] scores) {
        String[] leaders = new String[names.length];

        for (int i = 0; i < names.length; i++){
            leaders[i] = names[i] + " - "+scores[i];
        }

        return leaders;
    }

    //updates the leaderboards accordingly
    private static void updateLeaders(String[] names, int[] scores, int finalScore){
       int[] x = new int[scores.length+1];
       String[] y = new String[names.length+1];

       int[] newScores = new int[scores.length];
       String[] newNames = new String[names.length];

       if (finalScore > scores[scores.length-1]) {
           for (int i=0; i<scores.length; i++) {
               x[i] = scores[i];
               y[i] = names[i];
           }
           x[scores.length] = finalScore;
           y[names.length] = playerName;

           Dictionary<Integer, String> dict= new Hashtable<>();
           for (int i=0; i< x.length; i++) {
               dict.put(x[i], y[i]);
           }

           Set<Integer> keys = ((Hashtable<Integer, String>) dict).keySet();
           Iterator<Integer> itr = keys.iterator();

           int count =0;
           while (itr.hasNext()) {
               Integer i = itr.next();
               if (count < scores.length) {
                   newScores[count] = i;
                   newNames[count] = dict.get(i);
               }
               ++count;
           }

           leaderNames = newNames;
           leaderScores = newScores;


       }

    }

}
