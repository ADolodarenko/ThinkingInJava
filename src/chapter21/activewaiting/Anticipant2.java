package chapter21.activewaiting;

public class Anticipant2 implements Runnable {
	@Override
	public void run() {
		System.out.println(getClass().getSimpleName() + ": whaiting for the flag.");

		synchronized (Flag.class) {
			try {
				while (!Flag.getValue())
					Flag.class.wait();

				Flag.setValue(false);

				System.out.println(getClass().getSimpleName() + ": got the flag. Turned it off.");
			}
			catch (InterruptedException e) {
				System.out.println(getClass().getSimpleName() + ": interrupted.");
			}
		}
	}
}
