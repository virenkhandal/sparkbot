// @author Viren Khandal
public class Position{
    private int index;
    private String name;
    private int rent;
    private int price;
    private Property property;
    public int get_index(){
        return index;
    }
    public String get_name(){
        return name;
    }
    public int get_rent(){
        return rent;
    }
    public int get_price(){
        return price;
    }
    public Property get_property(){
        return property;
    }
    public void set_index(int new_index){
        index = new_index;
    }
}