import java.util.Random;

// @author Viren Khandal
public class Player{
    private Position position;
    public Position get_position(){
        return position;
    }
    public int roll_dice(){
        Random rand = new Random();
        int roll = rand.nextInt(11) + 2;
        return roll;
    }
}