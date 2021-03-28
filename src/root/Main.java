package root;
import  GUI.*;

public class Main implements Runnable{


	public static void main(String[] args) 
	{
		Main m = new Main();
		Thread mainThread = new Thread(m);
		
		mainThread.run();
	}


	public void run() {
		javafx.application.Application.launch(SetupWindow.class);
	}
}
