package chapter21.toastomatic;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Counter {
	private int count;
	private Lock lock;

	public Counter() {
		count = 0;
		lock = new ReentrantLock();
	}

	public int increment() {
		lock.lock();
		try {
			return count++;
		} finally {
			lock.unlock();
		}
	}
}
