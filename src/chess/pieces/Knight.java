package chess.pieces;

import chess.ChessPiece;
import boardgame.Board;
import boardgame.Position;
import chess.Color;

public class Knight extends ChessPiece {
    
    public Knight(Color color, Board board) {
        super(color, board);
    }

    private boolean canMove(Position position) {
        ChessPiece p = (ChessPiece) getBoard().piece(position);
        return p == null || p.getColor() != getColor();
    }

    @Override
    public String toString() {
        return "N";
    }

    @Override
    public boolean[][] possibleMoves() {
        boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getColumns()];
        Position p = new Position(0, 0);

        //2U1R
        p.setValues(position.getRow() - 2, position.getColumn() + 1);
        if (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) { 
            mat[p.getRow()][p.getColumn()] = true;
        }
        else if (getBoard().positionExists(p) && isThereOponentPiece(p)) {
            mat[p.getRow()][p.getColumn()] = true;
        }

        //2R1U
        p.setValues(position.getRow() - 1, position.getColumn() + 2);
        if (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) { 
            mat[p.getRow()][p.getColumn()] = true;
        }
        else if (getBoard().positionExists(p) && isThereOponentPiece(p)) {
            mat[p.getRow()][p.getColumn()] = true;
        }

        //2R1D
        p.setValues(position.getRow() + 1, position.getColumn() + 2);
        if (getBoard().positionExists(p) && canMove(p)) { 
            mat[p.getRow()][p.getColumn()] = true;
        }
        //2D1R
        p.setValues(position.getRow() + 2, position.getColumn() + 1);
        if (getBoard().positionExists(p) && canMove(p)) { 
            mat[p.getRow()][p.getColumn()] = true;
        }

        //2U1L
        p.setValues(position.getRow() + 2, position.getColumn() - 1);
        if (getBoard().positionExists(p) && canMove(p)) { 
            mat[p.getRow()][p.getColumn()] = true;
        }

        //2L1D
        p.setValues(position.getRow() + 1, position.getColumn() - 2);
        if (getBoard().positionExists(p) && canMove(p)) { 
            mat[p.getRow()][p.getColumn()] = true;
        }

        //2L1U
        p.setValues(position.getRow() - 1, position.getColumn() - 2);
        if (getBoard().positionExists(p) && canMove(p)) { 
            mat[p.getRow()][p.getColumn()] = true;
        }

        //2U1L
        p.setValues(position.getRow() - 2, position.getColumn() - 1);
        if (getBoard().positionExists(p) && canMove(p)) { 
            mat[p.getRow()][p.getColumn()] = true;
        }

        return mat;
    }
}
