package chapter21.restaurant;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Restaurant {
	public static void main(String[] args) {
		new Restaurant();
	}

	Meal meal;
	WaitPerson waitPerson = new WaitPerson(this);
	Chef chef = new Chef(this);
	ExecutorService exec = Executors.newCachedThreadPool();
	Lock lock = new ReentrantLock();
	Condition condition = lock.newCondition();

	public Restaurant() {
		exec.execute(chef);
		exec.execute(waitPerson);
	}
}
