package root;

import GUI.*;

public class Main implements Runnable{

	public static void main(String[] args) {
		Main m = new Main();
		Thread mainThread = new Thread(m);
		
		mainThread.run();
	}

	@Override
	public void run() {
		
		SetupWindow w1 = new SetupWindow();
		
	}

}
