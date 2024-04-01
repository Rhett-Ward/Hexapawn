import java.util.Scanner;
public class Main {

    public static int test = 0; // don't worry about
    public static int test2 = 0;
    // this is a variable that will be used to make sure one player doesn't move twice in a row Rhett Ward 02/26/2024
    public static int last = 2; // moved to be global for convenience's sake 03/28/24
    // this is just the variable I(Rhett) use to hold loops, personal preference over boolean, made global for convenience’s sake
    public static int sc = 1;
    static boolean z = true; //arbitrary variable used for a loop, Commented 02/29/2024 Rhett Ward

    public static int[][] Setup(){
        // moved from main to its own method for cleanliness of code on 02/29/2024 Rhett Ward
        // 2D integer array that makes up the game board of Hexapawn
        // sc = 1; //Rhett Ward 03/28/24 accommodate for change in checking process
        int[][] board = new int[3][3];
        // sets up the board when called
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
        return board;
    } //comments inside 02/29/2024 Rhett Ward

    //Condensed all the checks for if the game has ended into a method to be called after every move is made. 02/29/2024 Rhett Ward
    public static int Win_check(int[][] board,int last){
        // the two checks to determine if a win has occurred 02/27/2024 Rhett Ward
        if(board[0][0] == 2 || board[0][1] == 2 || board[0][2] == 2 ){
            System.out.println("Player 2 wins");
            test2++;
            return 6;
        }
        if(board[2][0] == 1 || board[2][1] == 1 || board[2][2] == 1){
            System.out.println("Player 1 wins");
            test++;
            return 6;
        }

        int c1 = 0; // counter for checking the condition of having no pieces left 02/27/2024 Rhett Ward
        int c2 = 0; // same as above, checking for player 2 instead 02/27/2024 Rhett Ward
        int c3 = 0; // counter for checking for stalemate 02/29/2024 Rhett Ward
        int c4 = 0; // same as above but for player 2 instead 02/29/2024 Rhett Ward
        for (int i = 0; i < 3; i++){ // loop going through the board and counting remaining pieces after every move 02/27/2024 Rhett Ward
            for(int b = 0; b < 3; b++){
                if(board[i][b] == 1){
                    c1++;
                    if(i < 2) {
                        if (board[i + 1][b] == 2) {
                            c3++;
                        }
                    }
                }
                if(board[i][b] == 2){
                    c2++;
                    if(i > 0) {
                        if (board[i - 1][b] == 1) {
                            c4++;
                        }
                    }
                }
            }
        }

        if(last==1 && c3 == c1){ // if player 2 can't move, player 1 wins
            System.out.println("Player 1 wins");
            test++;
            return 6;
        }
        if(last==2 && c4 == c2){ // if player 1 can't move, player 2 wins
            System.out.println("Player 2 wins");
            test2++;
            return 6;
        }
        if(c1 == 0){ // if player 1 has no pieces left 02/27/2024 Rhett Ward
            System.out.println("Player 2 wins");
            test2++;
            return 6;
        }
        if(c2 == 0){ // if player 2 has no pieces left 02/27/2024 Rhett Ward
            System.out.println("Player 1 wins");
            test++;
            return 6;
        }
        return 1;
    }

    // method that translates inputs for moving the top pawns, Simplified 02/29/2024
    public static void move1(int[][] game,int x,int y){
        game[y][x] = 1;
                for (int i = 0; i < 3; i++){ // loop going through the board and counting remaining pieces after every move 02/27/2024 Rhett Ward
                    for(int b = 0; b < 3; b++) {
                        System.out.print(game[i][b]);
                    }
                    System.out.println();
            }
    }

    // method that translates inputs for moving the bottom pawns
    public static void move2(int[][] game,int x,int y){
        game[y][x] = 2;
        for (int i = 0; i < 3; i++){ // loop going through the board and counting remaining pieces after every move 02/27/2024 Rhett Ward
            for(int b = 0; b < 3; b++) {
                System.out.print(game[i][b]);
            }
            System.out.println();
        }
    }

    // method that replaces where the pawn moved from with an empty space
    public static void replace(int[][] game,int x, int y){
        game[y][x] = 0;
    }

    public static boolean move_check(int[][] board, int X1, int Y1, int X2, int Y2){
        //Rhett Ward 03/28/24 move all checks, into one method for ease of access

        //first 2 checks
        move_check(board,X1,Y1);

        //second 2 checks

        //checks to make sure you aren't moving more than 1 space at a time
        if(Y2 == (Y1 + 2)){
            System.out.println("Cant move more then 1 space at a time, Try again");
            return false;
        }

        //sideways check

        //stops the invalid move of going sideways Rhett Ward 02/26/2024
        if(Y1 == Y2){
            System.out.println("Invalid move, You cant Move sideways");
            return false;
        }

        //checks to make sure you aren't moving diagonally unless you are taking.
        if(board[Y2][X2] == 0){
            if( X2 != X1 ){
                System.out.println("Invalid Move, Cant move diagonally unless taking an enemy piece, Try Again");
                return false;
            }
        }

        //rest of the checks

        //02/27/2024 Rhett Ward work was done to fix IOB errors //fixed and simplified on 02/29/2024 Rhett Ward
        if(board[Y2][X2] == 2 && board[Y1][X1] == 1) { //checks to make sure a piece 1 taking a piece 2 is valid Rhett Ward 02/26/2024
            if(((Y2 == (Y1 + 1))) && (X2 == (X1 + 1)) || ((Y2 == (Y1 + 1))) && (X2 == (X1 - 1))) { // checks for the SOP below 02/29/2024 Rhett Ward
                //do nothing 02/29/2024 Rhett Ward
            }
            else {
                System.out.println("Invalid Move, Cant move diagonally unless taking an enemy piece, Try Again");
                return false;
            }
            try { //catches IOB's without the program stopping 02/29/2024 Rhett Ward
                if (board[Y2][X2] == board[Y1 + 1][X1 - 1]) { // Checks the NW diagonal of selected piece 02/29/2024 Rhett Ward
                    move1(board, X2, Y2);
                    last = 1;
                    replace(board,X1,Y1);
                    sc = Win_check(board, last);
                    return false;
                }
                else if (board[Y2][X2] == board[Y1 + 1][X1 + 1]) {
                    // checks the NE diagonal of selected piece 02/29/2024 Rhett Ward
                    move1(board, X2, Y2);
                    last = 1;
                    replace(board,X1,Y1);
                    sc = Win_check(board, last);
                    return false;
                    //this gets repeated inside the catch to make sure that it still gets checked if the check before throws an IOB error 02/29/2024 Rhett Ward
                }
                else { // in the case that you are trying to take a 2 piece using a 1 piece (the inital condition to access these ifs) and neither of the above are true, your move is invalid as you cant take forward only diagonal 02/29/2024 Rhett Ward
                    System.out.println("Invalid Move, You cannot take an enemy piece this way, Try Again");
                    return false;
                }
            } catch (Exception e) { // catches if the is or else if throws an IOB error (the only error that can happen here, or at least that happened in testing) 02/29/2024 Rhett Ward
                try { //this is to run the second check in the case that the first check threw the IOB error 02/29/2024 Rhett Ward
                    if (board[Y2][X2] == board[Y1 + 1][X1 + 1]) {
                        move1(board, X2, Y2);
                        last = 1;
                        replace(board,X1,Y1);
                        sc = Win_check(board, last);
                        return false;
                    }
                    else { //repeated as a measure of guaranteeing you cant take forward 02/29/2024 Rhett Ward
                        System.out.println("Invalid Move, You cannot take an enemy piece this way, Try Again");
                        return false;
                    }
                }
                catch (Exception y){ // empty so that program continues even if IOB's got thrown on both checks 02/29/2024 Rhett Ward
                }
            }
        }

        //modified on 02/27/2024 by Rhett Ward, work was done to fix IOB errors //fixed and simplified on 02/29/2024 Rhett Ward
        if(board[Y2][X2] == 1 && board[Y1][X1] == 2){ // checks to make sure a piece 2 taking a piece 1 is valid Rhett Ward 02/26/2024
            if(((Y2 == (Y1 - 1))) && (X2 == (X1 + 1)) || ((Y2 == (Y1 - 1))) && (X2 == (X1 - 1))) {
                //do nothing 02/29/2024 Rhett Ward
            }
            else {
                System.out.println("Invalid Move, Cant move diagonally unless taking an enemy piece, Try Again");
                return false;
            }
            try { // catches IOB errors 02/29/2024 Rhett Ward
                if (board[Y2][X2] == board[Y1 - 1][X1 - 1]) { // Checks the SW diagonal of the selected piece 02/29/2024 Rhett Ward
                    move2(board, X2, Y2);
                    last = 2;
                    replace(board,X1,Y1);
                    sc = Win_check(board, last);
                    return false;
                }
                else if (board[Y2][X2] == board[Y1 - 1][X1 + 1]) { // checks the SE diagonal of the selected piece 02/29/2024 Rhett Ward
                    move2(board, X2, Y2);
                    last = 2;
                    replace(board,X1,Y1);
                    sc = Win_check(board, last);
                    return false;
                    // repeated in catch for same reason as in the check for 1 taking 2 02/29/2024 Rhett Ward
                }
                else { // makes sure you can't take forward 02/29/2024 Rhett Ward
                    System.out.println("Invalid Move, You cannot take an enemy piece this way, Try Again");
                    return false;
                }
            }
            catch(Exception e){
                try{ // makes sure the second check happens in the case the first check throws the IOB error 02/29/2024 Rhett Ward
                    if (board[Y2][X2] == board[Y1 - 1][X1 + 1]) { // checks SE diagonal of selected piece 02/29/2024 Rhett Ward
                        move2(board, X2, Y2);
                        last = 2;
                        replace(board,X1,Y1);
                        sc = Win_check(board, last);
                        return false;
                    }
                    else { // repeated to guarantee that you can't take forward 02/29/2024 Rhett Ward
                        System.out.println("Invalid Move, You cannot take an enemy piece this way, Try Again");
                        return false;
                    }
                }
                catch(Exception y){ // empty so that program continues even if IOB's got thrown on both checks 02/29/2024 Rhett Ward
                }
            }
        }


        //checks deciding which piece gets moved
        if(board[Y1][X1] == 2) {
            move2(board, X2, Y2);
            last = 2;
            replace(board,X1,Y1);
            sc = Win_check(board, 2);
            /*if(sc == 6) {
                return false;
            }*/
        }
        else{
            move1(board, X2, Y2);
            last = 1;
            replace(board,X1,Y1);
            sc = Win_check(board, 1);
            /*if(sc == 6) {
                return false;
            }*/
        }
        return true;
    }

    public static boolean move_check(int[][] board, int X1, int Y1){
        //Rhett Ward 03/28/24 move all checks, into one method for ease of access, this is specifically for the first 2 checks

        //first 2 checks

        //checks to make sure you aren't moving from a position without a piece Rhett Ward 02/26/2024
        if(board[Y1][X1] == 0){
            System.out.println("Invalid location, Try Again");
            return false;
        }
        //checks to make sure a player doesn't move twice in a row Rhett Ward 02/26/2024
        if(board[Y1][X1] == last){
            System.out.println("The same player cant move twice in a row, Try Again");
            return false;
        }

        return true;
    }

    public static void main(String[] args) {
        //scanner for making moves
        Scanner scan = new Scanner(System.in);

        //sets up board
        int[][] board = Setup();
        // loop for running the game
        while(sc != 6){

            //prints out the current board at the beginning, and everytime it changes Rhett Ward 02/29/2024
            System.out.println("This is the current board:");
            for(int r = 0; r < 3; r++){
                for(int c = 0; c < 3; c++) {
                    System.out.print(board[r][c] + " ");
                }
                System.out.println();
            }

            //"UI", outlines your options for interacting with the program Rhett Ward 02/29/2024
            System.out.println("1- make a move");
            System.out.println("2- quit");
            System.out.println("3- run a test skill check"); // added 02/23/2024 Rhett Ward

            // switch statement that takes in your inputs
            switch (Integer.parseInt(scan.nextLine())) {

                case 1: //The large bulk of everything is in this, this is where all the different things are computed bc this takes inputs and makes moves Rhett Ward 02/29/2024

                    System.out.println("Where will you move?");

                    //Asks and takes in inputs for WHICH piece to move
                        System.out.println("From: (0,1,2)");
                        // x coordinate : 0, 1, 2
                        System.out.print("x: ");
                        int X1 = Integer.parseInt(scan.nextLine());
                        // y coordinate : 0, 1, 2 (top to bottom)
                        System.out.print("y: ");
                        int Y1 = Integer.parseInt(scan.nextLine());

                        // first 2 checks
                    if(!move_check(board,X1,Y1)) {
                        break;
                    }

                    //Asks and takes in inputs for where to move the chosen piece
                        System.out.println("To: (0,1,2)");
                        System.out.print("x: ");
                        int X2 = Integer.parseInt(scan.nextLine());
                        System.out.print("y: ");
                        int Y2 = Integer.parseInt(scan.nextLine());

                        // second 2 checks
                    if(!move_check(board,X1,Y1,X2,Y2)) {
                        break;
                    }

                    break;
                case 2:
                    sc = 6;
                    break;
                case 3: //added 02/23/2024 Rhett Ward
                    Win_or_Lose A = new Win_or_Lose();
                    System.out.println(A.Skill_Check());
                    break;
                case 4: //added 03/28/24
                    System.out.println("How many simulations do you want to run?"); //number of games to be played
                    int n = Integer.parseInt(scan.nextLine());
                    while(n != 0){
                        sc =  1;
                        int[][] nboard = board;
                        int X3 = ((int) (Math.random() * 3));
                        int X4 = ((int) (Math.random() * 3));
                        int Y3 = ((int) (Math.random() * 3));
                        int Y4 = ((int) (Math.random() * 3));
                        while(sc!=6){
                            if (nboard[Y4][X4] == last){
                                X4 = 0;
                                X3 = 0;
                                Y3 = 0;
                                Y4 = 0;
                            }
                        while(!move_check(nboard, X3, Y3, X4, Y4)){
                            X3 = ((int) (Math.random() * 3));
                            X4 = ((int) (Math.random() * 3));
                            Y3 = ((int) (Math.random() * 3));
                            Y4 = ((int) (Math.random() * 3));
                        }}
                        n--;
                    }
                    System.out.println("Player 1 wins: " + test);
                    System.out.println("Player 2 wins: " + test2);
                    sc=1;
                    break;
            }
        }
    }
}