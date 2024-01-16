package chess.pieces;

import chess.ChessPiece;
import boardgame.Board;
import chess.Color;

public class King extends ChessPiece {
    
    public King(Color color, Board board) {
        super(color, board);
    }
    
    @Override
    public String toString() {
        return "K";
    }
}
