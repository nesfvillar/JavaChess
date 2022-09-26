package com.chess;

public abstract class Piece {
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

    public abstract int[][] getMovements();

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

class EmptySpace extends Piece {
    public EmptySpace() {
        super();
    }

    @Override
    public int[][] getMovements() {
        return null;
    }
}

abstract class Pawn extends Piece {
    Pawn(Color color) {
        super(Kind.PAWN, color);
    }
}

class WhitePawn extends Pawn {
    WhitePawn() {
        super(Color.WHITE);
    }

    @Override
    public int[][] getMovements() {
        return new int[][]{{-1, 1}, {0, 1}, {0, 2}, {1, 1}};
    }
}

class BlackPawn extends Pawn {
    BlackPawn() {
        super(Color.BLACK);
    }

    @Override
    public int[][] getMovements() {
        return new int[][]{{-1, -1}, {0, -1}, {0, -2}, {1, -1}};
    }
}

class Knight extends Piece {
    Knight(Color color) {
        super(Kind.KNIGHT, color);
    }

    @Override
    public int[][] getMovements() {
        return new int[][]{{2, 1}, {1, 2}, {-1, 2}, {-2, 1}, {-2, -1}, {-1, -2}, {1, -2}, {2, -1}};
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

    @Override
    public int[][] getMovements() {
        return new int[][]{
                {7, 7}, {6, 6}, {5, 5}, {4, 4}, {3, 3}, {2, 2}, {1, 1},
                {-7, 7}, {-6, 6}, {-5, 5}, {-4, 4}, {-3, 3}, {-2, 2}, {-1, 1},
                {-7, -7}, {-6, -6}, {-5, -5}, {-4, -4}, {-3, -3}, {-2, -2}, {-1, -1},
                {7, -7}, {6, -6}, {5, -5}, {4, -4}, {3, -3}, {2, -2}, {1, -1}};
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

    @Override
    public int[][] getMovements() {
        return new int[][]{
                {7, 0}, {6, 0}, {5, 0}, {4, 0}, {3, 0}, {2, 0}, {1, 0},
                {0, 7}, {0, 6}, {0, 5}, {0, 4}, {0, 3}, {0, 2}, {0, 1},
                {-7, 0}, {-6, 0}, {-5, 0}, {-4, 0}, {-3, 0}, {-2, 0}, {-1, 0},
                {0, -7}, {0, -6}, {0, -5}, {0, -4}, {0, -3}, {0, -2}, {0, -1},
        };
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

    @Override
    public int[][] getMovements() {
        return new int[][]{
                {7, 0}, {6, 0}, {5, 0}, {4, 0}, {3, 0}, {2, 0}, {1, 0},
                {0, 7}, {0, 6}, {0, 5}, {0, 4}, {0, 3}, {0, 2}, {0, 1},
                {-7, 0}, {-6, 0}, {-5, 0}, {-4, 0}, {-3, 0}, {-2, 0}, {-1, 0},
                {0, -7}, {0, -6}, {0, -5}, {0, -4}, {0, -3}, {0, -2}, {0, -1},
                {7, 7}, {6, 6}, {5, 5}, {4, 4}, {3, 3}, {2, 2}, {1, 1},
                {-7, 7}, {-6, 6}, {-5, 5}, {-4, 4}, {-3, 3}, {-2, 2}, {-1, 1},
                {-7, -7}, {-6, -6}, {-5, -5}, {-4, -4}, {-3, -3}, {-2, -2}, {-1, -1},
                {7, -7}, {6, -6}, {5, -5}, {4, -4}, {3, -3}, {2, -2}, {1, -1}};
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

    @Override
    public int[][] getMovements() {
        return new int[][]{{1, 0}, {2, 0}, {1, 1}, {0, 1}, {-1, 1}, {-1, 0}, {-2, 0}, {-1, -1}, {0, -1}, {1, -1}};
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
