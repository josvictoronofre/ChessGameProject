package application;

import java.util.InputMismatchException;
import java.util.Scanner;

import boardgame.Board;
import chess.*;
import application.UI;

public class Program {
    public static void main(String[] args) {
        ChessMatch match = new ChessMatch();
        Scanner sc = new Scanner (System.in);
        
        while (true) {
            try {
                UI.clearScreen();
                UI.printBoard(match.getPieces());
                System.out.println();
                System.out.print("Source: ");
                ChessPosition source = UI.readChessPosition(sc);

                System.out.println();
                System.out.print("Target :");
                ChessPosition target = UI.readChessPosition(sc);
        
                ChessPiece capturedPiece = match.performChessMove(source, target);
            } catch (ChessException e) {
                System.out.println(e.getMessage());
                sc.nextLine();
            } catch (InputMismatchException e) {
                System.out.println(e.getMessage());
                sc.nextLine();
            }
        }
        
    }
}