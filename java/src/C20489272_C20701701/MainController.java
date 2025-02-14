package C20489272_C20701701;

// import java.security.Key;

// AudioSettings
import ddf.minim.AudioBuffer;
import ddf.minim.AudioInput;
import ddf.minim.AudioPlayer;
import ddf.minim.Minim;

import processing.core.PApplet;

public class MainController extends PApplet
{
    // This is used for the audio visualisation
    float[] lerpedBuffer;
    float y = 0;
    float smoothedY = 0;
    float smoothedAmplitude = 0;
    float halfH = pixelHeight / 2;
    float halfW = pixelWidth / 2;
    Minim minim;
    AudioPlayer ap;
    AudioInput ai;
    AudioBuffer ab;
    int modes = 0;

    // This is used to highlight a selected MenuOption
    Boolean OptionSelected = false;
    int MenuOption = 100;
    int Start = 0;
    int Option = 0;
    int Exit = 0;
    int mode = 0;

    // This is used for Tetris
    int[][] board = new int[10][20];
    int[][] next = new int[4][4];
    int[][] hold = new int[4][4];
    int currX = 0;
    int currY = 0;
    boolean Pause = false;
    int TetrisInit = 0;

    // Player Character

    public void settings() 
    {
        fullScreen();
    }

    public void setup() 
    {
        frameRate(60);
        colorMode(HSB);
        background(0);

        minim = new Minim(this);
        ap = minim.loadFile("java/data/jjdmario.mp3", 512);
        ab = ap.mix;

        lerpedBuffer = new float[width];

        rectMode(CENTER);
    }

    public void keyPressed() 
    {
        if (OptionSelected == false) 
        {

            if (keyCode == 's' || keyCode == DOWN) 
            {
                MenuOption = MenuOption + 1;
                MenuOption = MenuOption % 2;
            }
            else if (keyCode == 'w'  || keyCode == UP) 
            {
                MenuOption = MenuOption - 1;
                MenuOption = MenuOption % 2;
            }

        }

        if (keyCode == '0') {
            mode = 0;
        }
        if (keyCode == '1') {
            mode = 1;
        }
        if (keyCode == '2') {
            mode = 2;
        }
        if (keyCode == '3') {
            mode = 3;
        }
        if (keyCode == '4') {
            mode = 4;
        }
        if (keyCode == '5') {
            mode = 5;
        }
        if (keyCode == '6') {
            mode = 6;
        }
        if (keyCode == '7') {
            mode = 7;
        }
        if (keyCode == '8') {
            mode = 8;
        }
        if (keyCode == '9') {
            mode = 9;
        }

    }   

    public void draw() 
    {   

        // these are variables that are needed for the programs
        // float halfH = height / 2;
        float average = 0;
        float sum = 0;
        // float off = 0;
        // off += 1;
        // Calculate sum and average of the samples
        // Also lerp each element of buffer;
        for(int i = 0 ; i < ab.size() ; i ++)
        {
            sum += abs(ab.get(i));
            lerpedBuffer[i] = lerp(lerpedBuffer[i], ab.get(i), 0.05f);
        }
        average= sum / (float) ab.size();
        smoothedAmplitude = lerp(smoothedAmplitude, average, 0.1f);
        // float cx = width / 2;
        // float cy = height / 2;

        Start = 0;
        Exit = 0;
        if (OptionSelected == false) 
        {
            StartMenu();
        }
        else if (OptionSelected == true && MenuOption == 0) 
        {
            
            FinalVersion();
            //noLoop();
        }
        //LightTunnel();
        //GnoPiece();
    }

    public void StartMenu() 
    {
        if (MenuOption == 0 && OptionSelected == false) 
        {
            Start = 150;
            if (keyCode == RIGHT || keyCode == LEFT) {
                OptionSelected = true;
                background(255);
            }
        }
        else if (MenuOption == 1 || MenuOption == -1 && OptionSelected == false) 
        {
            Exit = 150;
            if (keyCode == RIGHT || keyCode == LEFT) {
                exit();
            }
        }

        if (OptionSelected == false) 
        {
            textSize(22);
            textAlign(CENTER, CENTER);

            stroke(255);
            fill(Start, Start, Start);
            rect(pixelWidth / 2, pixelHeight - 350, 150, 75);
            fill(255);
            text("Start", pixelWidth / 2, pixelHeight - 350);

            stroke(255);
            fill(Exit, Exit, Exit);
            rect(pixelWidth / 2, pixelHeight - 250, 150, 75);
            fill(255);
            text("Exit", pixelWidth / 2, pixelHeight - 250);

        }
    }

    public void LightTunnel() 
    {
        // ap.play();

        float average = 0;
        float sum = 0;

/*         
        for (int i = 0; i < ab.size(); i++) {
            sum += abs(ab.get(i));
            lerpedBuffer[i] = lerp(lerpedBuffer[i], ab.get(i), 1.0f);
        }
        */

        average = sum / (float) ab.size();

        smoothedAmplitude = lerp(smoothedAmplitude, average, 0.2f);

        background(0);

        for (int i = 0; i < ab.size() / 100; i++) {
                   
            // This block of code makes lines that shoot out from the center in different colors
            float cx = map(i * 50, 0, ab.size(), 0, 255);
            stroke(cx, 255, 255);
            float f = lerpedBuffer[i] * (height / 2) * 100.0f;
            line(0, (height / 2) + f, width, (height / 2) - f);

            cx = map(i * 25, 0, ab.size(), 0, 255);
            stroke(cx, 255, 255);
            line(0, (height / 2) - f, width, (height / 2) + f);

            // Circle
            //stroke(cx, 255, 255);
            //fill(0, 0, 0);
            //ellipseMode(CENTER);
            //ellipse(width / 2, height / 2, (height / 20) + f , (height / 20) - f);
        }
        
    }

    // This is the final version of the assignment
    // instead of a tetris game, or a mario themed visualizer
    // I will just make as much cool and colourful shapes as possible
    public void FinalVersion()
    {

        ap.play();

        // this is a switch
        switch (mode) {

            // This case creates a bunch of random squares and circles in different colors
			case 0:
                background(0);
                for(int i = 0 ; i < ab.size() ; i ++) {
                    
                    // map c to the range of 0 to 255
                    float c = map(i * 2, 0, ab.size(), 0, 255);
                    stroke(c, 255, 255);
                    float f = lerpedBuffer[i] * (height / 2) * 50.0f;

                    // make a square with location and color based on the amplitude
                    // fill(c, 255, 255);
                    // rect(i * 10, height / 2 + f, 10, 10);

                    // make a triangle with location and color based on the amplitude
                    triangle(i * 10, height + f, i * 10, 0 - f, i * 10, height);

                }
                break;

            // This case runs the LightTunnel() method
            case 1:
                LightTunnel();
                break;
            
            
            case 2:
                background(0);
                for(int i = 0 ; i < ab.size() ; i ++) {
                    
                    // map c to the range of 0 to 255
                    float c = map(i * 2, 0, ab.size(), 0, 255);

                    float f = lerpedBuffer[i] * (height / 2) * 50.0f;

                    // make a square with location and color based on the amplitude
                    stroke(c, 255, 255);
                    fill(0, 255, 0);
                    rect(i * 10, height / 2 + f, 10, 10);
                    rect(i * 10, height / 2 - f, 10, 10);
                }
                break;

            case 3:
                background(0);
                for(int i = 0 ; i < ab.size() ; i ++) {
                    
                    // map c to the range of 0 to 255
                    float c = map(i * 2, 0, ab.size(), 0, 255);

                    // set the stroke to the value of c
                    stroke(c, 255, 255);

                    // set the fill to black
                    fill(0, 0, 0);

                    // draw a square at the center of the screen
                    rect(0, 0, 50, 50);

                    translate(width/2, height/2);

                    stroke(c, 255, 255);
                    fill(0, 0, 0);
                    ellipse(0, 0, 50, 50);

                    translate(width/2, height/2);

                    stroke(c, 255, 255);
                    fill(0, 0, 0);
                    rect(0, 0, 50, 50);

                    // moves the square to the center of the screen by using translate()
                    translate(width/2, height/2);

                    // rotate the square based on the music
                    rotate(lerpedBuffer[i] * 100.0f);
                }
                break;

            case 4:
                background(0);
                for(int i = 0 ; i < ab.size() ; i ++) {
                        
                    // map c to the range of 0 to 255
                    float c = map(i * 2, 0, ab.size(), 0, 255);
                    float f = lerpedBuffer[i] * (height / 2) * 20.0f;
                    // make a circle with location and color based on the amplitude
                    stroke(c, 255, 255);
                    fill(0, 0, 0);
                    ellipse(i * 10, height / 2 + f, 10 + i, 10 + i);
                }
                break;

            case 5:
                background(0);
                for(int i = 0 ; i < ab.size() ; i ++) {

                    // map c to the range of 0 to 255
                    float c = map(i * 2, 0, ab.size(), 0, 255);
                    float f = lerpedBuffer[i] * (height / 2) * 20.0f;

                    stroke(c, 200, 200);
                    fill(0, 0, 0);
                    ellipse(i * 10, height / 2, 10 + i, 10 + i);
                    rect(i * 10, height / 2, 10 + i, 10 + f);
                    
                }
                break;

            case 6:
                background(0);
                for (int i = 0; i < ab.size(); i++) {

                    // map c to the range of 0 to 255
                    float c = map(i * 2, 0, ab.size(), 0, 255);
                    float f = lerpedBuffer[i] * (height / 2) * 10.0f;

                    stroke(c, 255, 255);
                    fill(0, 0, 0);
                    ellipse(i * 10 + f, height, 50, 50);

                    stroke(c, 255, 255);
                    fill(0, 0, 0);
                    ellipse(i * 10 + f, 0, 50, 50);

                    stroke(c, 255, 255);
                    fill(0, 0, 0);
                    ellipse(width, i * 10 + f, 50, 50);

                    stroke(c, 255, 255);
                    fill(0, 0, 0);
                    ellipse(0, i * 10 + f, 50, 50);

                    c = map(i / 2, 0, ab.size(), 0, 255);
                    stroke(c, 255, 255);
                    fill(0, 0, 0);
                    ellipse(width / 2, height / 2, 25 + f, 25 + f);
                    
                }
                break;

            case 7:
                background(0);
                for (int i = 0; i < ab.size(); i++) {

                    // map c to the range of 0 to 255
                    float c = map(i * 2, 0, ab.size(), 0, 255);
                    float f = lerpedBuffer[i] * (height / 2) * 20.0f;

                    stroke(c, 255, 255);
                    fill(c, 255, 255);
                    rect(width / 2, height + f, 2, 2);

                    stroke(c, 255, 255);
                    fill(c, 255, 255);
                    rect(width + f, height / 2, 2, 2);

                    stroke(c, 255, 255);
                    fill(c, 255, 255);
                    rect(width / 2, 0 + f, 2, 2);

                    stroke(c, 255, 255);
                    fill(c, 255, 255);
                    rect(0 + f, height / 2, 2, 2);

                    c = map(i , 0, ab.size(), 0, 255);

                    stroke(c, 255, 255);
                    fill(c, 255, 255);
                    ellipse( (width / 2) + f, height , 25, 25);

                    stroke(c, 255, 255);
                    fill(c, 255, 255);
                    ellipse( width , (height / 2) + f, 25, 25);

                    stroke(c, 255, 255);
                    fill(c, 255, 255);
                    ellipse( (width / 2) + f, 0 , 25, 25);

                    stroke(c, 255, 255);
                    fill(c, 255, 255);
                    ellipse( 0 , (height / 2) + f, 25, 25);

                }
                break;

            case 8:
                background(0);
                for (int i = 0; i < ab.size(); i++) {

                    // map c to the range of 0 to 255
                    float c = map(i, 0, ab.size(), 0, 255);
                    float f = lerpedBuffer[i] * (height / 2) * 20.0f;

                    stroke(c, 255, 255);
                    fill(0, 0, 0);
                    triangle( width / 2 - f, height / 2 + f, width / 2, height/2 + f, width / 2 + f, height / 2 + f);
                }
                break;

            case 9:
                background(0);
                rectMode(CENTER);
                for (int i = 0; i < ab.size(); i++) {

                    // map c to the range of 0 to 255
                    float c = map(i, 0, ab.size(), 0, 255);
                    float f = lerpedBuffer[i] * (height / 2) * 20.0f;

                    stroke(c, 255, 255);
                    fill(0, 0, 0);
                    curve(width / 2, height / 2, width / 2, height / 2 + f, width / 2 + f, height / 2 + f, width / 2 + f, height / 2);
                    
                    stroke(c, 255, 255);
                    fill(0, 0, 0);
                    bezier(width / 2, height / 2, width / 2, height / 2 + f, width / 2 + f, height / 2 + f, width / 2 + f, height / 2);
                }
                break;

            default:
                break;

        }

    }
    // This runs a version of Tetris
    /* 
    public void Tetris() 
    {
        Tetromino tPiece = new Tetromino();
        TetrisBoard tBoard = new TetrisBoard();
        BoardState tState = new BoardState();

        tBoard.DrawBoard(this);

        // If statement to only run stuff once in a game
        if (TetrisInit == 0) 
        {
            tPiece.getRandomPiece(this);
            TetrisInit++;
        }

        tPiece.PieceMovement(currX, currY);
        tPiece.DrawTetromino(this);

        // if half a second has passed (15 frames per second), and the block is not past the bottom of the board, move it down
        if ( (currY < 17 * 40) & (frameCount % (15 * 1) == 0)) 
        {
            // move the block down by 1 block size
            currY = currY + 40;
        }

        // if the block is past the bottom of the board, or if the block is touching the bottom of the board, log the board state
        if (currY >= 17 * 40) 
        {
            // The current board state is logged
            // For every block at the bottom of the board, log the block's x and y coordinates
            for (int i = 0; i < 4; i++) 
            {
                for (int j = 0; j < 4; j++) 
                {
                    if (tPiece.currentPiece[i][j] == 1) 
                    {
                        tState.BoardCoordinates[i + currX][j + currY] = true;
                    }
                }
            }
            currX = 0;
            currY = 0;
        }
    }

    // Runs Tetris functions only once

    /*
    public void TetrisInit_Once() 
    {
        Tetromino tPiece = new Tetromino();
        TetrisBoard tBoard = new TetrisBoard();

        tBoard.DrawBoard(this);
        tPiece.PieceMovement(currX, currY);
        tPiece.getRandomPiece(this);
        stop();
    }
    */

} 
