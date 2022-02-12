package ie.tudublin;

// AudioSettings
import ddf.minim.AudioBuffer;
import ddf.minim.AudioInput;
import ddf.minim.AudioPlayer;
import ddf.minim.Minim;

import processing.core.PApplet;

public class MainController extends PApplet
{
    Minim minim;
    AudioPlayer ap;
    AudioInput ai;
    AudioBuffer ab;

    int mode = 0;

    float[] lerpedBuffer;
    float y = 0;
    float smoothedY = 0;
    float smoothedAmplitude = 0;

    float halfH = pixelHeight / 2;
    float halfW = pixelWidth / 2;

    // This is used to highlight a selected MenuOption
    Boolean OptionSelected = false;
    int MenuOption = 100;
    int Start = 0;
    int Option = 0;
    int Exit = 0;

    public void settings() 
    {
        fullScreen();
    }

    public void setup() 
    {
        colorMode(HSB);

        background(0);

        minim = new Minim(this);
        ap = minim.loadFile("java/data/heroplanet.mp3", 512);
        ab = ap.mix;

        lerpedBuffer = new float[width];

        rectMode(CENTER);
    }

    public void keyPressed() 
    {

        if (keyCode == 'd' || keyCode == DOWN) 
        {
            MenuOption = MenuOption + 1;
            MenuOption = MenuOption % 3;
            System.out.println("D: MenuOption is: " + MenuOption);
        }
        else if (keyCode == 'w'  || keyCode == UP) 
        {
            MenuOption = MenuOption - 1;
            MenuOption = MenuOption % 3;
            System.out.println("W: MenuOption is: " + MenuOption);
        }

        if (keyCode == ' ') {
            if (ap.isPlaying()) {
                ap.pause();
            } else {
                ap.rewind();
                ap.play();
            }
        }

    }

    public void draw() 
    {   
        Start = 0;
        Option = 0;
        Exit = 0;
        if (OptionSelected == false) 
        {
            StartMenu();
        }
        else if (OptionSelected == true && MenuOption == 0) 
        {
            LightTunnel();
        }
        //LightTunnel();
        //GnoPiece();
    }

    public void StartMenu() 
    {

        if (MenuOption == 0 && OptionSelected == false) 
        {
            Start = 255;
            if (keyCode == RIGHT || keyCode == LEFT) {
                OptionSelected = true;
                background(0);
            }
        }
        else if ((MenuOption == 1 || MenuOption == -2) && OptionSelected == false) 
        {
            Option = 200;
        }
        else if (MenuOption == 2 || MenuOption == -1 && OptionSelected == false) 
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
            fill(Option, Option, Option);
            rect(pixelWidth / 2, pixelHeight - 250, 150, 75);
            fill(255);
            text("Options", pixelWidth / 2, pixelHeight - 250);

            stroke(255);
            fill(Exit, Exit, Exit);
            rect(pixelWidth / 2, pixelHeight - 150, 150, 75);
            fill(255);
            text("Exit", pixelWidth / 2, pixelHeight - 150);
        }
    }
    
    public void GnoPiece()
    {
        // Traveler
    }

    public void LightTunnel() 
    {
        ap.play();

        float average = 0;
        float sum = 0;

        for (int i = 0; i < ab.size(); i++) {
            sum += abs(ab.get(i));
            lerpedBuffer[i] = lerp(lerpedBuffer[i], ab.get(i), 1.0f);
        }
        average = sum / (float) ab.size();

        smoothedAmplitude = lerp(smoothedAmplitude, average, 0.2f);

        switch (mode) {
            case 0:
                for (int i = 0; i < ab.size() / 100; i++) {
                    float cx = map(i * 100, 0, ab.size(), 0, 255);

                    stroke(cx, 255, 255);
                    float f = lerpedBuffer[i] * (height / 2) * 500.0f;
                    line(0, (height / 2) + f, width, (height / 2) - f);

                    // Circle
                    stroke(cx, 255, 255);
                    fill(0, 0, 0);
                    //ellipseMode(CENTER);
                    //ellipse(width / 2, height / 2, (height / 2) + f , (height / 2) - f);
                }

                break;
        
            default:
                break;
        }
    }
}
