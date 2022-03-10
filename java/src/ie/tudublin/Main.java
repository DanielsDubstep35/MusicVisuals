package ie.tudublin;

import example.MyVisual;

public class Main
{	

	public static void gno() 
	{
		String[] a = {"MAIN"};
		processing.core.PApplet.runSketch( a, new Gno());
	}

	public void startUI()
	{
		String[] a = {"MAIN"};
        processing.core.PApplet.runSketch( a, new MyVisual());		
	}

	public static void main(String[] args)
	{
		gno();	
	}
}