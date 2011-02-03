package ie.tudublin;

public class BoardState {
    
    boolean BoardCoordinates[][] = new boolean[10][20];

    // Initialise the board to have no blocks
    public BoardState() {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 20; j++) {
                BoardCoordinates[i][j] = false;
            }
        }
    }



}
