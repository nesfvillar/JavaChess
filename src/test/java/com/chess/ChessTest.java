package com.chess;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ChessTest {
    private Chess chess;

    @BeforeEach
    void setUp() {
        chess = new Chess();
    }

    @Test
    void clearBoard() {
        Assertions.assertNotEquals(Chess.emptySpace, chess.getPieceAt(0, 0));
        chess.clearBoard();
        Assertions.assertEquals(Chess.emptySpace, chess.getPieceAt(0, 0));
    }

    @Test
    void setPieceAt() {
        Assertions.assertEquals(Chess.emptySpace, chess.getPieceAt(2, 2));
        chess.setPieceAt(2, 2, Chess.whiteKnight);
        Assertions.assertEquals(Chess.whiteKnight, chess.getPieceAt(2, 2));
    }

    @Test
    void removePieceAt() {
        Assertions.assertEquals(Chess.blackKing, chess.getPieceAt(4, 7));
        chess.removePieceAt(4, 7);
        Assertions.assertEquals(Chess.emptySpace, chess.getPieceAt(4, 7));
    }

    @Test
    void getPieceAt() {
        Assertions.assertEquals(Chess.blackKing, chess.getPieceAt(4, 7));
    }

    @Test
    void movePieceString() {
        // Error: Selected square is empty
        Assertions.assertFalse(chess.movePiece("e3", "e4"));

        // Error: Pawn cannot move 3 spaces like that
        Assertions.assertFalse(chess.movePiece("e2", "e5"));

        // Error: Piece cannot capture a piece with the same color
        Assertions.assertFalse(chess.movePiece("c1", "d2"));

        Assertions.assertTrue(chess.movePiece("e2", "e4"));
    }

    @Test
    void movePieceInteger() {
        // Error: Selected square is empty
        Assertions.assertFalse(chess.movePiece(4, 2, 4, 3));

        // Error: Pawn cannot move 3 spaces like that
        Assertions.assertFalse(chess.movePiece(4,1 , 4, 4));

        // Error: Piece cannot capture a piece with the same color
        Assertions.assertFalse(chess.movePiece(2, 0, 3,1));

        Assertions.assertTrue(chess.movePiece(4, 1, 4, 3));
    }
}