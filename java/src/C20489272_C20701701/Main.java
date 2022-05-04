package C20489272_C20701701;

import example.MyVisual;

public class Main
{	

	public static void maincontroller() 
	{
		String[] a = {"MAIN"};
		processing.core.PApplet.runSketch( a, new MainController());
	}

	public static void startUI()
	{
		String[] a = {"MAIN"};
        processing.core.PApplet.runSketch( a, new MyVisual());		
	}

	public static void main(String[] args)
	{
		maincontroller();	
	}
}