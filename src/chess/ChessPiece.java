package chess;

import boardgame.Piece;
import boardgame.Position;
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

    protected boolean isThereOponentPiece(Position position) {
        ChessPiece p = (ChessPiece) getBoard().piece(position);
        return p != null && p.getColor() != color;
    }
}
