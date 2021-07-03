public class Game{
    private Board board;
    public Board get_board(){
        return board;
    }
    public void create_game(){
        board = new Board();
    }
}