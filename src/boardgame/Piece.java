package boardgame;

import boardgame.Position;
import boardgame.Board;

public class Piece {
    protected Position position;
    private Board board;

    public Piece() {}

    public Piece(Board board) {
        this.board = board;
        position = null;
    }

    protected Board getBoard() {
        return board;
    }
}
