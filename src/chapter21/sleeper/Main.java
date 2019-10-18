package chapter21.sleeper;

import java.util.concurrent.TimeUnit;

public class Main {
	public static void main(String[] args) {
		Thread t = new Thread(new SleepCaller());
		t.start();

		try {
			TimeUnit.SECONDS.sleep(3);
		}
		catch (InterruptedException e) {
			e.printStackTrace();
		}

		t.interrupt();
	}
}
