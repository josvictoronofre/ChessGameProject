package chess;

import boardgame.Piece;
import chess.Color;
import boardgame.Board;

public abstract class ChessPiece extends Piece {
    private Color color;

    public ChessPiece() {}

    public ChessPiece(Color color, Board board) {
        super(board);
        this.color = color;
    }

    public Color getColor() {
        return color;
    }
}
