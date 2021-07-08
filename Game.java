// @author Viren Khandal
public class Game{
    private Board board;
    private Player[] players;
    private Property[] properties;
    private Property[] available_properties;
    public Board get_board(){
        return board;
    }
    public Property[] get_properties(){
        return properties;
    }
    public Property[] get_available_properties(){
        return available_properties;
    }
    public void create_game(){
        board = new Board();
    }
    public Player[] get_players(){
        return players;
    }
    public Position[] get_player_positions(){
        Player[] game_players = get_players();
        Position[] positions = new Position[game_players.length];
        for (int i = 0; i < game_players.length; i++){
            Player current_player = players[i];
            Position current_position = current_player.get_position();
            positions[i] = current_position;
        }
        return positions;
    }
    public Property[][] get_player_properties(){
        Player[] game_players = get_players();
        Property[][] properties = new Property[game_players.length][];
        for (int i = 0; i < game_players.length; i++){
            Player current_player = game_players[i];
            Property[] current_properties = current_player.get_properties();
            properties[i] = current_properties; 
        }
        return properties;
    }
    public Player get_player_by_index(int index){
        return null;
    }
    public void make_turn(Player player){
        Position curPosition = player.get_position();
        int curr_index = curPosition.get_index();
        int dice_roll = player.roll_dice();
        Position new_position = new Position();
        new_position.set_index(curr_index + dice_roll);
        boolean can_buy = true;
        for (int i = 0; i < players.length; i++){
            Player curr_player = players[i];
            for (int j = 0; j < curr_player.get_properties().length; j++){
                Property curr_property = curr_player.get_properties()[j];
                if (new_position.get_property().equals(curr_property)){
                    player.set_balance(player.get_balance() - curr_property.get_base_rent());
                    curr_player.set_balance(curr_player.get_balance() + curr_property.get_base_rent());
                    can_buy = false;
                }
            }
        }
        if (player.buy_property() && can_buy){
            if (player.get_balance() >= new_position.get_price()){
                player.set_balance(player.get_balance() - new_position.get_price());
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