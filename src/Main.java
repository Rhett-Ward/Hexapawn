import java.util.Scanner;
public class Main {
    static boolean z = true;
    public static void move1(int[][] game,int x,int y){
        int[][] change = game;
        change[y][x] = 1;
        game = change;
        return;
    }
    public static void move2(int[][] game,int x,int y){
        int[][] change = game;
        change[y][x] = 2;
        game = change;
        return;
    }
    public static void replace(int[][] game,int x, int y){
        int[][] change = game;
        change[y][x] = 0;
        game = change;
        return;
    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int sc = 1;
        int[][] board = new int[3][3];
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
            switch (Integer.parseInt(scan.nextLine())) {
                case 1:
                    System.out.println("Where will you move?");
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
                        System.out.println("From: ");
                        System.out.print("x: ");
                        int X1 = Integer.parseInt(scan.nextLine());
                        System.out.print("y: ");
                        int Y1 = Integer.parseInt(scan.nextLine());
                        System.out.println("To: ");
                        System.out.print("x: ");
                        int X2 = Integer.parseInt(scan.nextLine());
                        System.out.print("y: ");
                        int Y2 = Integer.parseInt(scan.nextLine());
                        if(board[Y1][X1] == 2) {
                            move2(board, X2, Y2);
                        }
                        else{
                            move1(board,X2,Y2);
                        }
                        replace(board,X1,Y1);
                    } catch (Exception e) {
                        System.out.println("Invalid input, use the correct format");
                    }
                    break;
                case 2:
                    sc = 6;
                    break;
            }
        }
    }
}