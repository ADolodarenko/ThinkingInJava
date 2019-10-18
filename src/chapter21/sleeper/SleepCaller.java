package chapter21.sleeper;

public class SleepCaller implements Runnable {
	@Override
	public void run() {
		try {
			Sleeper.sleep();
			//TimeUnit.SECONDS.sleep(240);
		}
		catch (InterruptedException e) {
			System.out.println("Sleeping has been interrupted.");
		}
	}
}
