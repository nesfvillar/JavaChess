package com.chess;

import java.util.Arrays;

public class Chess {
    public static final Piece emptySpace = new EmptySpace();
    public static final Piece whitePawn = new WhitePawn();
    public static final Piece blackPawn = new BlackPawn();
    public static final Piece whiteKnight = new WhiteKnight();
    public static final Piece blackKnight = new BlackKnight();
    public static final Piece whiteBishop = new WhiteBishop();
    public static final Piece blackBishop = new BlackBishop();
    public static final Piece whiteRook = new WhiteRook();
    public static final Piece blackRook = new BlackRook();
    public static final Piece whiteQueen = new WhiteQueen();
    public static final Piece blackQueen = new BlackQueen();
    public static final Piece whiteKing = new WhiteKing();
    public static final Piece blackKing = new BlackKing();

    private final Piece[][] board = new Piece[8][8];

    public Chess() {
        clearBoard();
        for (int x = 0; x < 8; x++) {
            setPieceAt(x, 1, whitePawn);
            setPieceAt(x, 6, blackPawn);
        }
        setPieceAt(0, 0, whiteRook);
        setPieceAt(7, 0, whiteRook);
        setPieceAt(1, 0, whiteKnight);
        setPieceAt(6, 0, whiteKnight);
        setPieceAt(2, 0, whiteBishop);
        setPieceAt(5, 0, whiteBishop);
        setPieceAt(3, 0, whiteQueen);
        setPieceAt(4, 0, whiteKing);

        setPieceAt(0, 7, blackRook);
        setPieceAt(7, 7, blackRook);
        setPieceAt(1, 7, blackKnight);
        setPieceAt(6, 7, blackKnight);
        setPieceAt(2, 7, blackBishop);
        setPieceAt(5, 7, blackBishop);
        setPieceAt(3, 7, blackQueen);
        setPieceAt(4, 7, blackKing);
    }

    public void clearBoard() {
        for (int j = 0; j < 8; j++) {
            for (int i = 0; i < 8; i++) {
                removePieceAt(i, j);
            }
        }
    }

    public void setPieceAt(int x, int y, Piece piece) {
        board[y][x] = piece;
    }

    public void removePieceAt(int x, int y) {
        setPieceAt(x, y, emptySpace);
    }

    public Piece getPieceAt(int x, int y) {
        return board[y][x];
    }

    public boolean movePiece(String o, String f) {
        int[] positionO = stringToPosition(o);
        int xo = positionO[0];
        int yo = positionO[1];

        int[] positionF = stringToPosition(f);
        int xf = positionF[0];
        int yf = positionF[1];

        return movePiece(xo, yo, xf, yf);
    }

    public boolean movePiece(int xo, int yo, int xf, int yf) {
        Piece pieceO = getPieceAt(xo, yo);
        if (pieceO == emptySpace) {
            System.out.println("The selected square to move " + xo + ", " + yo + " is empty");
            return false;
        }

        Piece pieceF = getPieceAt(xf, yf);
        if (pieceO.color == pieceF.color) {
            System.out.println("The piece to capture is the same color as the moving piece");
            return false;
        }

        int[] current_movement = new int[]{xf - xo, yf - yo};
        int[][] possible_movements = pieceO.getMovements();
        if (!Arrays.stream(possible_movements).anyMatch(m -> Arrays.equals(current_movement, m))) {
            System.out.println("The selected piece cannot do the move " + Arrays.toString(current_movement));
            return false;
        }

        removePieceAt(xo, yo);
        setPieceAt(xf, yf, pieceO);
        return true;
    }

    private int[] stringToPosition(String s) {
        char x = s.charAt(0);
        char y = s.charAt(1);
        int x_num;
        int y_num;

        switch (x) {
            case 'a' -> x_num = 0;
            case 'b' -> x_num = 1;
            case 'c' -> x_num = 2;
            case 'd' -> x_num = 3;
            case 'e' -> x_num = 4;
            case 'f' -> x_num = 5;
            case 'g' -> x_num = 6;
            case 'h' -> x_num = 7;
            default -> throw new IllegalStateException("Unexpected value: " + x);
        }

        y_num = Character.digit(y, 10) - 1;

        return new int[] {x_num, y_num};
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (int j = 7; j >= 0; j--) {
            for (int i = 0; i < 8; i++) {
                result.append(getPieceAt(i, j));
            }
            if (j > 0) {
                result.append('\n');
            }
        }
        return result.toString();
    }
}
