package chapter21.toastomatic;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Toaster2 implements Runnable {
	private ToastQueue toastQueue;
	private Counter counter;
	private Random random = new Random(47);

	public Toaster2(ToastQueue toastQueue, Counter counter) {
		this.toastQueue = toastQueue;
		this.counter = counter;
	}

	@Override
	public void run() {
		try {
			while (!Thread.interrupted()) {
				TimeUnit.MILLISECONDS.sleep(100 + random.nextInt(500));

				Toast toast = new Toast(counter.increment());
				System.out.println(toast);
				toastQueue.put(toast);
			}
		} catch (InterruptedException e) {
			System.out.println(getClass().getSimpleName() + " interrupted");
		}

		System.out.println(getClass().getSimpleName() + " off");
	}
}
