import com.chess.Chess;


public class Main {
    public static void main(String[] args) {
        Chess chess = new Chess();
        System.out.println(chess + "\n");
        chess.movePiece(4, 1, 4, 3);
        System.out.println(chess);
    }
}
