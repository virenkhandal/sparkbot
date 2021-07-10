// @author Viren Khandal
public class Property{
    private int index;
    private String name;
    private int base_rent;
    private int price;
    private String color;
    public void __init__(int set_index, String set_name, int set_base_rent, int set_price, String set_color){
        index = set_index;
        name = set_name;
        base_rent = set_base_rent;
        price = set_price;
        color = set_color;
    }
    public int get_index(){
        return index;
    }
    public String get_name(){
        return name;
    }
    public int get_base_rent(){
        return base_rent;
    }
    public String get_color(){
        return color;
    }
    public int get_price(){
        return price;
    }
}