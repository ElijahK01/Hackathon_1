package root;

<<<<<<< HEAD
public class Main implements Runnable
{
=======
import GUI.*;

public class Main implements Runnable{
>>>>>>> branch 'master' of https://github.com/ElijahK01/Hackathon_1

	public static void main(String[] args) 
	{
		Main m = new Main();
		Thread mainThread = new Thread(m);
		
		mainThread.run();
	}

	@Override
<<<<<<< HEAD
	public void run() 
	{
=======
	public void run() {
		
		SetupWindow w1 = new SetupWindow();
		javafx.application.Application.launch(SetupWindow.class);
>>>>>>> branch 'master' of https://github.com/ElijahK01/Hackathon_1
		
	}
}
