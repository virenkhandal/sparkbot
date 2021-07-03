public class Game{
    private Board board;
    private Player[] players;
    public Board get_board(){
        return board;
    }
    public void create_game(){
        board = new Board();
    }
    public Player[] get_players(){
        return players;
    }
}