package chapter21.toastomatic;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Toaster implements Runnable {
	private ToastQueue toastQueue;
	private int count = 0;
	private Random random = new Random(47);

	public Toaster(ToastQueue toastQueue) {
		this.toastQueue = toastQueue;
	}

	@Override
	public void run() {
		try {
			while (!Thread.interrupted()) {
				TimeUnit.MILLISECONDS.sleep(100 + random.nextInt(500));

				Toast toast = new Toast(count++);
				System.out.println(toast);
				toastQueue.put(toast);
			}
		} catch (InterruptedException e) {
			System.out.println(getClass().getSimpleName() + " interrupted");
		}

		System.out.println(getClass().getSimpleName() + " off");
	}
}
