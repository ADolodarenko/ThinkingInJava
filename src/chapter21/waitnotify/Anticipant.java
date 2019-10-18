package chapter21.waitnotify;

public class Anticipant implements Runnable {
	@Override
	public void run() {
		try {
			System.out.println(getClass().getSimpleName() + ": Waiting.");

			synchronized (this) {
				wait();
			}

			System.out.println(getClass().getSimpleName() + ": Here we are!");
		}
		catch (InterruptedException e) {
			System.out.println(getClass().getSimpleName() + ": interrupted.");
		}

	}
}
