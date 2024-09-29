package com.test.testOne;

public class EasyBattleship{
    //Instance variables and arrays
    private static String[][] board = new String[5][5];
    private static boolean[][] ships = new boolean[5][5];
    
    //All the ships
    private static int[] four = new int[3]; //Battleship
    private static int[] three = new int[3]; //Cruiser
    private static int[] two = new int[3]; //Destroyer
    private static int[] two2 = new int[3]; //Frigate
    
    //Game stats
    private static int score = 0;
    private static int hit = 0;
    private static int miss = 0;
    private static int streak = 0;
    private static int bestStreak = 0;
    private static boolean[] sunks = new boolean[4];
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
        System.out.println("   0 1 2 3 4");
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

        //First Ship (four)
        rotate = (int)(Math.random()*2);
        
        //0 is vertical
        if (rotate == 0){
            row = (int)(Math.random()*2);
            col = (int)(Math.random()*5);
            ships[row][col] = true;
            ships[row+1][col] = true;
            ships[row+2][col] = true;
            ships[row+3][col] = true;
        }
        //1 is horizontal
        else {
            row = (int)(Math.random()*5);
            col = (int)(Math.random()*2);
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
                row = (int)(Math.random()*3);
                col = (int)(Math.random()*5);
            }
            
            ships[row][col] = true;
            ships[row+1][col] = true;
            ships[row+2][col] = true;
        }
        //1 is horizontal
        else {
            while (ships[row][col] || ships[row][col+1] || ships[row][col+2]){
                row = (int)(Math.random()*5);
                col = (int)(Math.random()*3);
            }
            
            ships[row][col] = true;
            ships[row][col+1] = true;
            ships[row][col+2] = true;
        }
        
        three[0] = row;
        three[1] = col;
        three[2] = rotate;

        //Fourth Ship (two)
        //0 is vertical
        if (rotate == 0){
            while(ships[row][col] || ships[row+1][col]){
                row = (int)(Math.random()*4);
                col = (int)(Math.random()*5);
            }
            ships[row][col] = true;
            ships[row+1][col] = true;
        }
        //1 is horizontal
        else {
            while (ships[row][col] || ships[row][col+1]){
                row = (int)(Math.random()*5);
                col = (int)(Math.random()*4);
            }
            ships[row][col] = true;
            ships[row][col+1] = true;
        }

        two[0] = row;
        two[1] = col;
        two[2] = rotate;

        //Fifth Ship (two2)
        //0 is vertical
        if (rotate == 0){
            while(ships[row][col] || ships[row+1][col]){
                row = (int)(Math.random()*4);
                col = (int)(Math.random()*5);
            }
            ships[row][col] = true;
            ships[row+1][col] = true;
        }
        //1 is horizontal
        else {
            while (ships[row][col] || ships[row][col+1]){
                row = (int)(Math.random()*5);
                col = (int)(Math.random()*4);
            }
            ships[row][col] = true;
            ships[row][col+1] = true;
        }

        two2[0] = row;
        two2[1] = col;
        two2[2] = rotate;
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
            default:
                return "Enter a valid coordinate.";
        }
        
        if (tempCol > 4 || tempCol < 0){
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
    
    //Method to print sunk ships
    public static void printSunk(){
        System.out.print("Sunk Ships: ");
        if (sunkTwo()){
            System.out.print("Destroyer(2) | ");
        }
        if (sunkTwo2()){
            System.out.print("Frigate(2) | ");
        }
        if (sunkThree()){
            System.out.print("Cruiser(3) | ");
        }
        if (sunkFour()){
            System.out.print("Battleship(4) | ");
        }
        System.out.println();
    }
    
    public static void printActive(){
        System.out.print("Active Ships: ");
        if (!sunkTwo()){
            System.out.print("Destroyer(2) | ");
        }
        if (!sunkTwo2()){
            System.out.print("Frigate(2) | ");
        }
        if (!sunkThree()){
            System.out.print("Cruiser(3) | ");
        }
        if (!sunkFour()){
            System.out.print("Battleship(4) | ");
        }
        System.out.println();
    }
    
    //Method to check how many ships was sunk.
    public static int checkSunks(){
        sunks[0] = sunkTwo();
        sunks[1] = sunkTwo2();
        sunks[2] = sunkThree();
        sunks[3] = sunkFour();
        
        newSunks = 0;
        for(int i = 0; i < sunks.length; i++){
            if (sunks[i] == true){
                newSunks++;
            }
        }
        if (allSunks < newSunks){
            allSunks = newSunks;
            System.out.println("\nYOU\nHAVE\nSUNK\nA\nSHIP!!!!!!\n(+5 Score!)\n");
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
    
    //Give a score bonus based on developer conditions.
    public static void scoreBonus(int bonus){
        if (!(allSunks == 4)){
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
        if (!(allSunks==4)){
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
}
