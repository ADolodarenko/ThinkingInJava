package chapter21.activewaiting;

import java.util.concurrent.TimeUnit;

public class Notifier2 implements Runnable {
	@Override
	public void run() {
		System.out.println(getClass().getSimpleName() + ": sleeping.");

		try {
			TimeUnit.SECONDS.sleep(5);
		}
		catch (InterruptedException e) {}

		synchronized (Flag.class) {
			Flag.setValue(true);
			Flag.class.notify();
		}

		System.out.println(getClass().getSimpleName() + ": turned the flag on.");
	}
}
