import com.chess.Chess;


public class Main {
    public static void main(String[] args) {
        Chess chess = new Chess();
        System.out.println(chess + "\n");
        chess.movePiece("e3", "e4"); // Error: Selected square is empty
        System.out.println(chess + "\n");
        chess.movePiece("e2", "e5"); // Error: Pawn cannot move 3 spaces like that
        System.out.println(chess + "\n");
        chess.movePiece("c1", "d2"); // Error: Piece cannot capture a piece with the same color
        System.out.println(chess + "\n");
        chess.movePiece("e2", "e4"); // Ok
        System.out.println(chess);
    }
}
