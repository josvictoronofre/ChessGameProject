package application;

import boardgame.Board;
import chess.ChessMatch;
import application.UI;

public class Program {
    public static void main(String[] args) {
        ChessMatch match = new ChessMatch();
        UI.printBoard(match.getPieces());
    }
}