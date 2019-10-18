package chapter21.restaurant;

import java.util.concurrent.TimeUnit;

public class Chef implements Runnable {
	private Restaurant restaurant;
	private int count = 0;

	public Chef(Restaurant restaurant) {
		this.restaurant = restaurant;
	}

	@Override
	public void run() {
		try {
			while (!Thread.interrupted()) {
				restaurant.lock.lock();
				try {
					while (restaurant.meal != null)
						restaurant.condition.await();
				} finally {
					restaurant.lock.unlock();
				}

				if (++count == 10) {
					System.out.println("Out of food, closing");
					restaurant.exec.shutdownNow();
				}

				System.out.println("Order up!");

				restaurant.lock.lock();
				try {
					restaurant.meal = new Meal(count);
					restaurant.condition.signalAll();
				} finally {
					restaurant.lock.unlock();
				}

				TimeUnit.MILLISECONDS.sleep(100);
			}
		}
		catch (InterruptedException e) {
			System.out.println(getClass().getSimpleName() + " interrupted");
		}
	}
}
