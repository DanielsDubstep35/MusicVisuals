package ie.tudublin;

public class TetrisBoard {

    int bottomborder = 20 * 40;
    int leftborder = 0;
    int rightborder = 10 * 40;
    int topborder = 0;

    public void DrawBoard(MainController mc) {

        // moves the board to the center of the screen
        mc.translate((mc.pixelWidth / 2) - 200, 0);

        mc.background(0);
        // mc.rectMode(mc.CORNER);
        // This is the tetris piece from another class

        // Draws the board on the x axis
        for (int i = 0; i < 10; i++) 
        {
            // Draws the board on the y axis
            for (int j = 0; j < 20; j++) 
            {
                // This makes the board

                // gray
                mc.stroke(100);
                mc.fill(0);
                mc.rect(i * 40, j * 40, 38, 38);
            }
        }
        
        // Draws a border around the board
        mc.stroke(255);
        mc.line(0, 0, 0, 20 * 40);
        mc.line(10 * 40, 0, 10 * 40, 20 * 40);
        mc.line(0, 20 * 40, 10 * 40, 20 * 40);

    }

/*     // lock piece to the map
    public Void lockPiece(MainController mc) {

        for (int i = 0; i < 20; i++) {
            for (int j = 0; j < 10; j++) {
                
            }
        }
        
        return 0;
        
    } */

}
