package com.chess;

public class Piece {
    public final Kind kind;
    public final Color color;

    public Piece() {
        kind = Kind.EMPTY;
        color = Color.EMPTY;
    }

    public Piece(Kind kind, Color color) {
        this.kind = kind;
        this.color = color;
    }

    @Override
    public String toString() {
        switch (kind) {
            case PAWN -> {
                return "P";
            }
            case KNIGHT -> {
                return "N";
            }
            case BISHOP -> {
                return "B";
            }
            case ROOK -> {
                return "R";
            }
            case QUEEN -> {
                return "Q";
            }
            case KING -> {
                return "K";
            }
            default -> {
                return ".";
            }
        }
    }

    public enum Kind {
        EMPTY,
        PAWN,
        KNIGHT,
        BISHOP,
        ROOK,
        QUEEN,
        KING
    }

    public enum Color {
        EMPTY,
        WHITE,
        BLACK
    }
}

class Pawn extends Piece {
    Pawn(Color color) {
        super(Kind.PAWN, color);
    }
}

class WhitePawn extends Pawn {
    WhitePawn() {
        super(Color.WHITE);
    }
}

class BlackPawn extends Pawn {
    BlackPawn() {
        super(Color.BLACK);
    }
}

class Knight extends Piece {
    Knight(Color color) {
        super(Kind.KNIGHT, color);
    }
}

class WhiteKnight extends Knight {
    WhiteKnight() {
        super(Color.WHITE);
    }
}

class BlackKnight extends Knight {
    BlackKnight() {
        super(Color.BLACK);
    }
}

class Bishop extends Piece {
    Bishop(Color color) {
        super(Kind.BISHOP, color);
    }
}

class WhiteBishop extends Bishop {
    WhiteBishop() {
        super(Color.WHITE);
    }
}

class BlackBishop extends Bishop {
    BlackBishop() {
        super(Color.BLACK);
    }
}

class Rook extends Piece {
    Rook(Color color) {
        super(Kind.ROOK, color);
    }
}

class WhiteRook extends Rook {
    WhiteRook() {
        super(Color.WHITE);
    }
}

class BlackRook extends Rook {
    BlackRook() {
        super(Color.BLACK);
    }
}

class Queen extends Piece {
    Queen(Color color) {
        super(Kind.QUEEN, color);
    }
}

class WhiteQueen extends Queen {
    WhiteQueen() {
        super(Color.WHITE);
    }
}

class BlackQueen extends Queen {
    BlackQueen() {
        super(Color.BLACK);
    }
}

class King extends Piece {
    King(Color color) {
        super(Kind.KING, color);
    }
}

class WhiteKing extends King {
    WhiteKing() {
        super(Color.WHITE);
    }
}

class BlackKing extends King {
    BlackKing() {
        super(Color.BLACK);
    }
}
