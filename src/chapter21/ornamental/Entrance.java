package chapter21.ornamental;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Entrance implements Runnable {
	private static Count count = new Count();
	private static List<Entrance> entrances = new ArrayList<>();

	public static int getTotalCount() {
		return count.value();
	}

	public static int sumEntrances() {
		int sum = 0;
		for (Entrance entrance : entrances)
			sum += entrance.getValue();

		return sum;
	}

	private int number = 0;
	private final int id;

	public Entrance(int id) {
		this.id = id;

		entrances.add(this);
	}

	@Override
	public void run() {
		while (!Thread.interrupted()) {
			synchronized (this) {
				++number;
			}

			System.out.println(this + " Total: " + count.increment());

			try {
				TimeUnit.MILLISECONDS.sleep(100);
			} catch (InterruptedException e) {
				System.out.println("sleep interrupted");
				break;
			}
		}

		System.out.println("Stopping " + this);
	}

	public synchronized int getValue() {
		return number;
	}

	public String toString() {
		return "Entrance " + id + ": " + getValue();
	}
}
