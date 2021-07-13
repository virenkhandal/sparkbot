import java.util.ArrayList;
import java.util.Dictionary;
import java.util.Hashtable;

// @author Viren Khandal
public class Game{
    private Board board;
    private ArrayList<Player> players;
    private ArrayList<Property> all_properties;
    private ArrayList<Property> available_properties;
    private ArrayList<Property> owned_properties;
    Dictionary<Integer, Property> property_dict = new Hashtable<Integer, Property>();
    Dictionary<Integer, Player> player_dict = new Hashtable<Integer, Player>();
    public Board get_board(){
        return board;
    }
    public ArrayList<Property> get_properties(){
        return all_properties;
    }
    public ArrayList<Property> get_available_properties(){
        return available_properties;
    }
    public ArrayList<Property> get_owned_properties(){
        return owned_properties;
    }
    public void create_game(){
        board = new Board();
    }
    public ArrayList<Player> get_players(){
        return players;
    }
    public Dictionary<Player, Property> get_player_positions(){
        ArrayList<Player> players = get_players();
        Dictionary<Player, Property> player_positions = new Hashtable<Player, Property>();
        for (int i = 0; i < players.size(); i++){
            Player curr_player = players.get(i);
            Property current_position = curr_player.get_position();
            player_positions.put(curr_player, current_position);
        }
        return player_positions;
    }

    public Dictionary<Player, ArrayList<Property>> get_player_properties(){
        ArrayList<Player> game_players = get_players();
        Dictionary<Player, ArrayList<Property>> player_properties = new Hashtable<Player, ArrayList<Property>>();
        for (int i = 0; i < game_players.size(); i++){
            Player current_player = game_players.get(i);
            ArrayList<Property> current_properties = current_player.get_properties();
            player_properties.put(current_player, current_properties);
        }
        return player_properties;
    }
    public Player get_player_by_index(int index){
        return player_dict.get(index);
    }
    public Property get_property_by_index(int index){
        return property_dict.get(index);
    }
    public void initialize_map(){
        Property baltic_ave = new Property();
        baltic_ave.__init__(1, "Baltic Avenue", 2, 40, "Brown");
        property_dict.put(1, baltic_ave);
    }
    public void start_game(){
        for (int i = 0; i < players.size(); i++){
            Player current_player = players.get(i);
            current_player.set_index(i);
            player_dict.put(i, current_player);
        }
        initialize_map();
    }
    public void make_turn(Player player){
        Property curPosition = player.get_position();
        int curr_index = curPosition.get_index();
        int dice_roll = player.roll_dice();
        Property new_property = get_property_by_index(curr_index + dice_roll);
        boolean can_buy = true;
        for (int i = 0; i < players.size(); i++){
            Player curr_player = players.get(i);
            for (int j = 0; j < curr_player.get_properties().size(); j++){
                Property curr_property = curr_player.get_properties().get(j);
                if (new_property.equals(curr_property)){
                    player.set_balance(player.get_balance() - curr_property.get_base_rent());
                    curr_player.set_balance(curr_player.get_balance() + curr_property.get_base_rent());
                    can_buy = false;
                }
            }
        }
        if (player.buy_property() && can_buy){
            if (player.get_balance() >= new_property.get_price()){
                player.set_balance(player.get_balance() - new_property.get_price());
                for (int i = 0; i < available_properties.size(); i++){
                    if (available_properties.get(i).equals(new_property)){
                        // remove new_property from available properties
                    }
                }
            }
            else{
                // raise error for lack of funds
            }
        } else {
            int current_index = player.get_index();
            Player next_player = get_player_by_index(current_index + 1);
            make_turn(next_player);
        }
    }
}