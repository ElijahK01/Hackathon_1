package root;
import  GUI.*;

/*
 * Project for ACMW Hackathon - University of Toledo, 3/28/2021
 * 
 * Team Members:
 *  	- Elijah Karl   --- Frsheman, CSE
 * 		- Andrew Scheid --- Senior, CSE
 * 
 */

public class Main implements Runnable{


	public static void main(String[] args) 
	{
		Main m = new Main();
		Thread mainThread = new Thread(m);
		
		mainThread.run();
	}


	@Override
	public void run() {
		javafx.application.Application.launch(SetupWindow.class);
	}
}
