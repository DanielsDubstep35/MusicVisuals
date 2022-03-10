package ie.tudublin;

import processing.core.PApplet;
import processing.core.PImage;

public class Gno extends PApplet 
{
    public void settings() 
    {
        // size(x-axis, y-axis)
        size(1080, 1920);
    }

    public void setup() 
    {
        size(1080, 1920);
		background(0);
        PImage img = createImage(1080, 1920, RGB);
        img = loadImage("java/src/ie/tudublin/p8.png");

        // image(image variable, x-axis, y-axis)
        image(img, 0, 0);
    }

    public void draw() 
    {
        GnoPiece();
    }

    public void GnoPiece()
    {

    }
}
