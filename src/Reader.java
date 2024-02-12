import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;
public class Reader {
    public static void In (File i){
        int sc = 1;
        try {
            Scanner r = new Scanner(i);
            ArrayList<String> moves = new ArrayList<String>();
            while( sc != 6 ){
                if(r.hasNextLine()){
                    moves.add(r.nextLine());
                }
                else{
                    sc = 6;
                }
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

    }
}
