package chapter21.waitnotify;

import java.util.concurrent.TimeUnit;

public class Notifier implements Runnable {
	private Anticipant anticipant;

	public Notifier(Anticipant anticipant) {
		this.anticipant = anticipant;
	}

	@Override
	public void run() {
		try {
			TimeUnit.SECONDS.sleep(3);

			System.out.println(getClass().getSimpleName() + ": notifying.");

			synchronized (anticipant) {
				anticipant.notify();
			}
		}
		catch (InterruptedException e) {
			System.out.println(getClass().getSimpleName() + ": interrupted.");
		}
	}
}
