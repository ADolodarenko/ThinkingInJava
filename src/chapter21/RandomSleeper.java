package chapter21;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class RandomSleeper implements Runnable {
	private static final Random RANDOM;

	private int seconds;

	static {
		RANDOM = new Random(47);
	}

	public RandomSleeper() {
		seconds = RANDOM.nextInt(10) + 1;
	}

	@Override
	public void run() {
		try {
			TimeUnit.SECONDS.sleep(seconds);

			System.out.println("Slept for " + seconds + " second(s)");
		}
		catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
