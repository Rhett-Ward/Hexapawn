// Rhett Ward created / started February 23, 2024
public class Win_or_Lose {
    //this class is going to be my attempt at writing a method(s) that determine if a skill check is
    //successful or a failure

    //Method that rolls a d20 for the skill check
    public int rollD20(){
        return ((int) (Math.random() * 20) + 1);
    }

    //Method that rolls a d4 for the skill check
    public int rollD4(){
        return ((int) (Math.random() * 4) + 1);
    }

    //Method that rolls a d6 for the skill check
    public int rollD6(){
        return ((int) (Math.random() * 6) + 1);
    }

    //Method that rolls a d8 for the skill check
    public int rollD8(){
        return ((int) (Math.random() * 8) + 1);
    }

    //Method that rolls a d10 for the skill check
    public int rollD10(){
        return ((int) (Math.random() * 10) + 1);
    }

    //Method that rolls a d12 for the skill check
    public int rollD12(){
        return ((int) (Math.random() * 12) + 1);
    }

    //runs a skillcheck and returns a string saying whether you passed or failed.
    public String Skill_Check(){
        int urRoll = rollD20();
        if(urRoll >= /*will be replaced with wtv system we use for determining the check but for right now im just gonna generate it per run */
                ((int) (Math.random() * 30) + 1)){
            return ("You passed the skill check");
        }
        else {
            return ("Skill Check Failed");
        }

    }
}
