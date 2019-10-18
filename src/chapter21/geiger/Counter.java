package chapter21.geiger;

import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Counter implements Runnable {
	private int sensorsQnt;
	private int rentgensQnt;
	private int seconds;
	private boolean cancelled;

	public void addSensor() {
		sensorsQnt++;
	}

	public synchronized void putValue(int rentgens) {
		rentgensQnt += rentgens;
	}

	public synchronized boolean isCancelled() {
		return cancelled;
	}

	public synchronized void cancel() {
		cancelled = true;
	}

	private synchronized int rentgensPerSecond() {
		double average = rentgensQnt / sensorsQnt;

		return (int) (average / seconds);
	}

	@Override
	public void run() {
		long startMillis = new Date().getTime();

		while (!cancelled) {
			try {
				TimeUnit.SECONDS.sleep(1);
			}
			catch (InterruptedException e) {
				e.printStackTrace();
			}

			seconds = (int) ((new Date().getTime() - startMillis) / 1000.0);

			System.out.println(rentgensPerSecond() + " rentgens per second.");
		}
	}
}
