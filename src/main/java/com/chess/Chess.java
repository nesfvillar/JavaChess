package com.chess;

public class Chess {
    public static final Piece emptySpace = new Piece();
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

    private Piece[][] board = new Piece[8][8];

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

    public boolean movePiece(int xo, int yo, int xf, int yf) {
        Piece pieceO = getPieceAt(xo, yo);
        Piece pieceF = getPieceAt(xf, yf);
        if (pieceO != emptySpace && pieceO.color != pieceF.color) {
            removePieceAt(xo, yo);
            setPieceAt(xf, yf, pieceO);
            return true;
        }
        return false;
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
