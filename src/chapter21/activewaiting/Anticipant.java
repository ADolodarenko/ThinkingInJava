package chapter21.activewaiting;

public class Anticipant implements Runnable {

	@Override
	public void run() {
		System.out.println(getClass().getSimpleName() + ": whaiting for the flag.");
		while (!Flag.getValue());

		Flag.setValue(false);
		System.out.println(getClass().getSimpleName() + ": got the flag. Turned it off.");
	}
}
