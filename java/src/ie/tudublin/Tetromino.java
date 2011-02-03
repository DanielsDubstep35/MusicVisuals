package ie.tudublin;

// import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Tetromino {

    // Each piece is an array that has the coordinates of each block
    // These are the pieces:

    // The x 40 is used to make the pieces fit on the board
    int Lblock[][] = { { 0 * 40, 0 * 40 }, { 0 * 40, 1 * 40 }, { 0 * 40, 2 * 40 }, { 1 * 40, 2 * 40 } };
    int Jblock[][] = { { 0 * 40, 0 * 40 }, { 0 * 40, 1 * 40 }, { 0 * 40, 2 * 40 }, { -1 * 40, 2 * 40 } };
    int Sblock[][] = { { 0 * 40, 0 * 40 }, { 0 * 40, 1 * 40 }, { 1 * 40, 1 * 40 }, { 1 * 40, 2 * 40 } };
    int Zblock[][] = { { 0 * 40, 0 * 40 }, { 0 * 40, 1 * 40 }, { -1 * 40, 1 * 40 }, { -1 * 40, 2 * 40 } };
    int Tblock[][] = { { 0 * 40, 0 * 40 }, { 0 * 40, 1 * 40 }, { 0 * 40, 2 * 40 }, { 1 * 40, 1 * 40 } };
    int Oblock[][] = { { 0 * 40, 0 * 40 }, { 0 * 40, 1 * 40 }, { 1 * 40, 0 * 40 }, { 1 * 40, 1 * 40 } };
    int Iblock[][] = { { 0 * 40, 0 * 40 }, { 0 * 40, 1 * 40 }, { 0 * 40, 2 * 40 }, { 0 * 40, 3 * 40 } };

    // enumerator for random pieces
    /* 
    public enum Piece {
        Lblock, Jblock, Sblock, Zblock, Tblock, Oblock, Iblock;

        public static Piece getRandom() {
            Random random = new Random();
            return values()[random.nextInt(values().length)];
        }
    }
    */

    // The next variables is information that the game uses

    // Initiallized to Iblock, just for a default piece
    int currentPiece[][] = Lblock;

    int currentX;
    int currentY;
    int currentRotation;
    int ghostPiece[][];
    int ghostRotation;
    int nextPiece[][];

    /*
    // We need a constructor to get the currently used piece, and some other things like the current rotation, or the next piece
    public Tetromino(int currentPiece, int currentRotation, int nextPiece) {
        this.currentPiece = currentPiece;
        this.currentRotation = currentRotation;
        this.nextPiece = nextPiece;
    }
    */

    // This will draw the piece, as well as handle the movement of the piece
    public void DrawTetromino(MainController mc) {
        
        // This is the current piece on the board
        // currentPiece = Lblock;

        // draws a piece
        for (int i = 0; i < 4; i++) {
            // This just colors and fills the piece
            mc.stroke(0);
            mc.fill(255, 200, 200);

            // This is the piece
            mc.rect(currentPiece[i][0] + currentX, currentPiece[i][1] + currentY, 38, 38);
        }

    }

    // This will update the Pieces coordinates by sending the coordinates from maincontroller to this classes coordinate system
    public void PieceMovement(int currex, int currey) {
        this.currentX = currex;
        this.currentY = currey;

    }

    // Generates a random piece from the random block array
    // We also use this to generate a piece initially for currentPiece
    public void getRandomPiece(MainController mc) {
        
        int RandomNumber = ThreadLocalRandom.current().nextInt(0, 7);

        switch (RandomNumber) {
            case 0:
                currentPiece = Lblock;
                break;
            case 1:
                currentPiece = Jblock;
                break;
            case 2:
                currentPiece = Sblock;
                break;
            case 3:
                currentPiece = Zblock;
                break;
            case 4:
                currentPiece = Tblock;
                break;
            case 5:
                currentPiece = Oblock;
                break;
            case 6:
                currentPiece = Iblock;
                break;
            default:
                break;
        }
        
        //currentPiece = RandomBlock[ (ThreadLocalRandom.current().nextInt(0, 6 + 1)) ];
        // mc.noLoop();
    }

}
