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
        // brown
        Property mediterranean = new Property();
        mediterranean.__init__(1, "Mediterraneann Avenue", 2, 60, "Brown");
        property_dict.put(1, mediterranean);
        Property baltic = new Property();
        baltic.__init__(2, "Baltic Avenue", 4, 60, "Brown");
        property_dict.put(2, baltic);

        // blue
        Property oriental = new Property();
        oriental.__init__(3, "Oriental Avenue", 6, 100, "Blue");
        property_dict.put(3, oriental);
        Property vermont = new Property();
        vermont.__init__(4, "Vermont Avenue", 6, 100, "Blue");
        property_dict.put(4, vermont);
        Property connecticut = new Property();
        connecticut.__init__(4, "Connecticut Avenue", 8, 120, "Blue");
        property_dict.put(4, connecticut);

        // pink
        Property st_charles = new Property();
        st_charles.__init__(5, "St. Charles Place", 10, 140, "Pink");
        property_dict.put(5, st_charles);
        Property states = new Property();
        states.__init__(6, "States Avenue", 10, 140, "Pink");
        property_dict.put(6, states);
        Property virginia = new Property();
        virginia.__init__(7, "Virginia Avenue", 12, 160, "Pink");
        property_dict.put(7, virginia);

        // orange
        Property st_james = new Property();
        st_james.__init__(8, "St. James Place", 14, 180, "Orange");
        property_dict.put(8, st_james);
        Property tennessee = new Property();
        tennessee.__init__(9, "Tennessee Avenue", 14, 180, "Orange");
        property_dict.put(9, tennessee);
        Property new_york = new Property();
        new_york.__init__(10, "New York Avenue", 16, 200, "Orange");
        property_dict.put(10, new_york);

        // red
        Property kentucky = new Property();
        kentucky.__init__(11, "Kentucky Avenue", 16, 200, "Red");
        property_dict.put(11, kentucky);
        Property indiana = new Property();
        indiana.__init__(12, "Indiana Avenue", 16, 200, "Red");
        property_dict.put(12, indiana);
        Property illinois = new Property();
        illinois.__init__(13, "Illinois Avenue", 16, 200, "Red");
        property_dict.put(13, illinois);
        
        // yellow
        Property atlantic = new Property();
        atlantic.__init__(14, "Atlantic Avenue", 16, 200, "Yellow");
        property_dict.put(14, atlantic);
        Property ventnor = new Property();
        ventnor.__init__(15, "Ventnor Avenue", 16, 200, "Yellow");
        property_dict.put(15, ventnor);
        Property marvin_gardens = new Property();
        marvin_gardens.__init__(16, "Marvin Gardens", 16, 200, "Yellow");
        property_dict.put(16, marvin_gardens);

        // green
        Property pacific = new Property();
        pacific.__init__(17, "Pacific Avenue", 16, 200, "Green");
        property_dict.put(17, pacific);
        Property north_carolina = new Property();
        north_carolina.__init__(18, "North Carolina Avenue", 16, 200, "Green");
        property_dict.put(18, north_carolina);
        Property pennsylvania = new Property();
        pennsylvania.__init__(19, "Pennsylvania Avenue", 16, 200, "Green");
        property_dict.put(19, pennsylvania);
        
        // navy
        Property park_place = new Property();
        park_place.__init__(20, "Park Place", 16, 200, "Navy");
        property_dict.put(20, park_place);
        Property boardwalk = new Property();
        boardwalk.__init__(21, "Boardwalk", 16, 200, "Navy");
        property_dict.put(21, boardwalk);

        // stations
        Property reading_railroad = new Property();
        reading_railroad.__init__(21, "Reading Railroad", 16, 200, "Station");
        property_dict.put(21, reading_railroad);
        Property pennsylvania_railroad = new Property();
        pennsylvania_railroad.__init__(21, "Pennsylvania Railroad", 16, 200, "Station");
        property_dict.put(21, pennsylvania_railroad);
        Property bno_railroad = new Property();
        bno_railroad.__init__(21, "B. & O. Railroad", 16, 200, "Station");
        property_dict.put(21, bno_railroad);
        Property short_line = new Property();
        short_line.__init__(21, "Short Line", 16, 200, "Station");
        property_dict.put(21, short_line);

        // utilities
        Property electric_company = new Property();
        electric_company.__init__(21, "Electric Company", 16, 200, "Utility");
        property_dict.put(21, electric_company);
        Property water_works = new Property();
        water_works.__init__(21, "Water Works", 16, 200, "Utility");
        property_dict.put(21, water_works);
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