/**
 * Created by Jaime on 3/26/2017.
 */
public class Game {
    private Space[] board;

    public Game(Space[] board){
        this.board = board;
    }

    public Space[] getBoard() {
        return board;
    }

    public void setBoard(Space[] board) {
        this.board = board;
    }
}
