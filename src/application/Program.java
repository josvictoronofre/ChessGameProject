package application;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import boardgame.Board;
import chess.*;
import application.UI;

public class Program {
    public static void main(String[] args) {
        ChessMatch match = new ChessMatch();
        List<ChessPiece> captured = new ArrayList<>();
        Scanner sc = new Scanner (System.in);
        
        while (!match.getCheckMate()) {
            try {
                UI.clearScreen();
                UI.printMatch(match, captured);
                System.out.println();
                System.out.print("Source: ");
                ChessPosition source = UI.readChessPosition(sc);

                boolean[][] possibleMoves = match.possibleMoves(source);
                UI.clearScreen();
                UI.printBoard(match.getPieces(), possibleMoves);
                 System.out.println();
                System.out.print("Target :");
                ChessPosition target = UI.readChessPosition(sc);
        
                ChessPiece capturedPiece = match.performChessMove(source, target);
                if (capturedPiece != null) {
                    captured.add(capturedPiece);
                }
                if (match.getPromoted() != null) {
                    System.out.print("Enter piece for promotion (B/N/R/Q): ");
                    String type = sc.nextLine().toUpperCase();
                    while (!type.equals("B") && !type.equals("N") && !type.equals("Q") && type.equals("R")) {
                        System.out.print("Invalid value! Enter piece for promotion (B/N/R/Q): ");
                        type = sc.nextLine().toUpperCase();
                    }
                    match.replacePromotedPiece(type);
                }
            } catch (ChessException e) {
                System.out.println(e.getMessage());
                sc.nextLine();
            } catch (InputMismatchException e) {
                System.out.println(e.getMessage());
                sc.nextLine();
            }
        }
        UI.clearScreen();
        UI.printMatch(match, captured);
    }
}