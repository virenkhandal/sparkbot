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
}