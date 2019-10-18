package chapter21.restaurant;

public class WaitPerson implements Runnable {
	private Restaurant restaurant;

	public WaitPerson(Restaurant restaurant) {
		this.restaurant = restaurant;
	}

	@Override
	public void run() {
		try {
			while (!Thread.interrupted()) {
				restaurant.lock.lock();
				try {
					while (restaurant.meal == null)
						restaurant.condition.await();
				} finally {
					restaurant.lock.unlock();
				}

				System.out.println(getClass().getSimpleName() + " got " + restaurant.meal);

				restaurant.lock.lock();
				try {
					restaurant.meal = null;
					restaurant.condition.signalAll();
				} finally {
					restaurant.lock.unlock();
				}
			}
		}
		catch (InterruptedException e) {
			System.out.println(getClass().getSimpleName() + " interrupted");
		}
	}
}
