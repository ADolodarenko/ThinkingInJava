package chapter21.geiger;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class RemoteSensor implements Runnable {

	private Random random;
	private Counter counter;

	public RemoteSensor(Counter counter) {
		counter.addSensor();

		this.counter = counter;

		random = new Random(47);
	}

	@Override
	public void run() {
		while (!counter.isCancelled()) {
			counter.putValue(random.nextInt(100));

			try {
				TimeUnit.MILLISECONDS.sleep(100);
			}
			catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
