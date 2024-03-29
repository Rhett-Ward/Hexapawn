public class AI { // Rhett Ward 4:26pm March 28th, 2024

    public int id;


    /*
    goal :
    1) make a method or class for every possible move the AI could make.
    2) then make it so the AI CAN make those moves by interacting with the console (automatically) (method call).
    3) then make it so that the AI is fed the input of the END RESULT of the game.
    4) if that result is a loss for the AI, add a negative multiplier to the moves it made, if it's a win add a positive multiplier
    5) train it (?)
     */

    /* breakdown:
    to do step 1 determine if I should use methods or classes, if I use classes should they extend a main move class, should they extend AI
    to do step 2 step 1 has to be finished, and, the preexisting code for hexapawn has to be condensed into more callable methods so that a method may be made for the AI to be able to participate in the game
    to do step 3 there has to be an indicator of wins / losses, local variable perhaps
    to do step 4 there is a lot that must be done after step 3, a way to track moves made by the AI must be made, a way to record the board state it chose to make those moves with must be made, variables that influence the odds of a certain move being made must be implemented.
    to do step 5, pray
    */

    //benefits of methods over classes: less messy SRC folder and UHP diagram
    //cons of methods over classes: possibly harder to track
    //if I use classes, they should all extend a central move class which is where we can hold local variables such as identifiers for the move, and board states (?)
    //going to try extended classes...
}
