package chapter21.activewaiting;

import java.util.concurrent.TimeUnit;

public class Notifier implements Runnable {

	@Override
	public void run() {
		System.out.println(getClass().getSimpleName() + ": sleeping.");

		try {
			TimeUnit.SECONDS.sleep(5);
		}
		catch (InterruptedException e) {}

		Flag.setValue(true);
		System.out.println(getClass().getSimpleName() + ": turned the flag on.");
	}
}
