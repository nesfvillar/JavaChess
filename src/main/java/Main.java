import com.chess.Chess;


public class Main {
    public static void main(String[] args) {
        Chess chess = new Chess();
        System.out.println(chess + "\n");
        chess.movePiece(4, 2, 4, 3); // Error: Selected square is empty
        System.out.println(chess + "\n");
        chess.movePiece(4, 1, 4, 5); // Error: Pawn cannot move 3 spaces like that
        System.out.println(chess + "\n");
        chess.movePiece(2, 0, 3, 1); // Error: Piece cannot capture a piece with the same color
        System.out.println(chess + "\n");
        chess.movePiece(4, 1, 4, 3); // Ok
        System.out.println(chess);
    }
}
