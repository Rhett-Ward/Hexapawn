import java.util.Scanner;
public class Main {
    static boolean z = true;

    // method that translates inputs for moving the top pawns
    public static void move1(int[][] game,int x,int y){
        int[][] change = game;
        change[y][x] = 1;
        game = change;
        return;
    }

    // method that translates inputs for moving the bottom pawns
    public static void move2(int[][] game,int x,int y){
        int[][] change = game;
        change[y][x] = 2;
        game = change;
        return;
    }

    // method that replaces where the pawn moved from with an empty space
    public static void replace(int[][] game,int x, int y){
        int[][] change = game;
        change[y][x] = 0;
        game = change;
        return;
    }
    public static void main(String[] args) {
        //scanner for making moves
        Scanner scan = new Scanner(System.in);
        // this is just the variable i use to hold loops, personal preference over boolean
        int sc = 1;
        // this is a variable that will be used to make sure one player doesn't move twice in a row Rhett Ward 02/26/2024
        int last = 0;
        // 2D integer array that makes up the game board of hexapawn
        int[][] board = new int[3][3];
        // sets up the board on runtime
        if (z){
            for(int r = 0; r < 3; r++){
                for(int c = 0; c < 3; c++){
                    if (r == 0){
                        board[r][c] = 1;
                    } else if (r == 2) {
                        board[r][c] = 2;
                    } else{
                        board[r][c] = 0;
                    }
                }
            }
            System.out.println("welcome to hexapawn.");
            z = false;
        }
        // loop for running the game
        while(sc != 6){
            System.out.println("This is the current board:");
            for(int r = 0; r < 3; r++){
                for(int c = 0; c < 3; c++) {
                    System.out.print(board[r][c] + " ");
                }
                System.out.println("");
            }
            System.out.println("1- make a move");
            System.out.println("2- quit");
            System.out.println("3- run a test skill check"); // added 02/23/2024 Rhett Ward
            // switch statement that takes in your inputs
            switch (Integer.parseInt(scan.nextLine())) {
                case 1:
                    System.out.println("Where will you move?");
                    //theoretical implementation for reader.java (not fleshed out)
                    try {
                        /* a theoretical code block that would make a move based off of a random choice
                        of available moves from an arraylist made from a file

                        Reader r = new Reader;
                        r.In(text file);
                        int b = 0;
                        if my turn (to lazy to write implementation for this rn sorry) {
                            b =(int)(math.random() + 1 * r.moves.size;);
                            String move = r.moves.get(b);
                            move1/2 (whichever the bot is) (board, Integer.parseint(move.substring(0,1)), Integer.parseint(move.substring(1,2)));
                            break;
                        }

                        */
                        System.out.println("From: (0,1,2)");
                        // x coordinate : 0, 1, 2
                        System.out.print("x: ");
                        int X1 = Integer.parseInt(scan.nextLine());
                        // y coordinate : 0, 1, 2 (top to bottom)
                        System.out.print("y: ");
                        int Y1 = Integer.parseInt(scan.nextLine());
                        //checks to make sure you aren't moving from a position without a piece Rhett Ward 02/26/2024
                        if(board[Y1][X1] == 0){
                            System.out.println("Invalid location, Try Again");
                            break;
                        }
                        //checks to make sure a player doesnt move twice in a row Rhett Ward 02/26/2024
                        if(board[Y1][X1] == last){
                            System.out.println("The same player cant move twice in a row, Try Again");
                            break;
                        }
                        System.out.println("To: (0,1,2)");
                        System.out.print("x: ");
                        int X2 = Integer.parseInt(scan.nextLine());
                        System.out.print("y: ");
                        int Y2 = Integer.parseInt(scan.nextLine());
                        // checks to make sure a piece 1 taking a piece 2 is valid Rhett Ward 02/26/2024
                        //modified on 02/27/2024 by Rhett Ward to fix the Index out of bounds errors that were occuring during the checks
                        if(board[Y2][X2] == 2 && board[Y1][X1] == 1) {
                            try {
                                if (board[Y1][X1] == board[Y2 - 1][X2 - 1]) {
                                    move1(board, X2, Y2);
                                    last = 1;
                                }
                                else {
                                    System.out.println("Invalid Move, You cannot take an enemy piece this way, Try Again");
                                    break;
                                }
                            } catch (Exception e) {
                                continue;
                            }
                            try {
                                if (board[Y1][X1] == board[Y2 - 1][X2 + 1]) {
                                    move1(board, X2, Y2);
                                    last = 1;
                                } else {
                                    System.out.println("Invalid Move, You cannot take an enemy piece this way, Try Again");
                                    break;
                                }
                            } catch (Exception e){continue;}
                        }
                        // checks to make sure a piece 2 taking a piece 1 is valid Rhett Ward 02/26/2024
                        //modified on 02/27/2024 by Rhett Ward to fix the Index out of bounds errors that were occuring during the checks

                        if(board[Y2][X2] == 1 && board[Y1][X1] == 2){
                            try {
                                if (board[Y1][X1] == board[Y2 + 1][X2 - 1]) {
                                    move2(board, X2, Y2);
                                    last = 2;
                                } else {
                                    System.out.println("Invalid Move, You cannot take an enemy piece this way, Try Again");
                                    break;
                                }
                            } catch(Exception e){continue;}
                            try {
                                if (board[Y1][X1] == board[Y2 + 1][X2 + 1]) {
                                    move2(board, X2, Y2);
                                    last = 2;
                                } else {
                                    System.out.println("Invalid Move, You cannot take an enemy piece this way, Try Again");
                                    break;
                                }
                            }catch(Exception e){continue;}
                        }
                        //stops the invalid move of going sideways Rhett Ward 02/26/2024
                        if(Y1 == Y2){
                            System.out.println("Invalid move, You cant Move sideways");
                            break;
                        }
                        // this is the only control over moves in the code
                        if(board[Y1][X1] == 2) {
                            move2(board, X2, Y2);
                            last = 2;
                        }
                        else{
                            move1(board, X2, Y2);
                            last = 1;
                        }
                        replace(board,X1,Y1);
                        //this catch was for the theoretical reader code
                    } catch (Exception e) {
                        System.out.println("Invalid input, use the correct format");
                    }
                    // the two checks to determine if a win has occured ( need to write checks for alt win condition of taking all enemy pieces) 02/27/2024 Rhett Ward
                    if(board[0][0] == 2 || board[0][1] == 2 || board[0][2] == 2 ){
                        System.out.println("Player 2 wins");
                        sc = 6;
                    }
                    if(board[2][0] == 1 || board[2][1] == 1 || board[2][2] == 1){
                        System.out.println("Player 1 wins");
                        sc = 6;
                    }
                    int c1 = 0; // counter for checking the condition of having no pieces left 02/27/2024 Rhett Ward
                    int c2 = 0; // same as above, checking for player 2 instead 02/27/2024 Rhett Ward
                    for (int i = 0; i <= board.length-1; i++){ // loop going through the board and counting remaining pieces after every move 02/27/2024 Rhett Ward
                        for(int b = 0; b <= board.length -1; b++){
                            if(board[i][b] == 1){
                                c1++;
                            }
                            if(board[i][b] == 2){
                                c2++;
                            }
                        }
                    }
                    if(c1 == 0){ // if player 1 has no pieces left 02/27/2024 Rhett Ward
                        System.out.println("Player 2 wins");
                        sc = 6;
                    }
                    if(c2 == 0){ // if player 2 has no pieces left 02/27/2024 Rhett Ward
                        System.out.println("Player 1 wins");
                        sc = 6;
                    }
                    break;
                case 2:
                    sc = 6;
                    break;
                case 3: //added 02/23/2024 Rhett Ward
                    Win_or_Lose A = new Win_or_Lose();
                    System.out.println(A.Skill_Check());
            }
        }
    }
}