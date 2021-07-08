import java.util.Random;

// @author Viren Khandal

public class Player{
    private String name;
    private int index;
    private Position position;
    private int balance;
    private Property[] properties;
    public String get_name(){
        return name;
    }
    public int get_index(){
        return index;
    }
    public Position get_position(){
        return position;
    }
    public int get_balance(){
        return balance;
    }
    public Property[] get_properties(){
        return properties;
    }
    public int roll_dice(){
        Random rand = new Random();
        int roll = rand.nextInt(11) + 2;
        return roll;
    }
    public boolean buy_property(){
        return true;
    }
    public void set_balance(int amount){
        balance = amount;
    }
}

