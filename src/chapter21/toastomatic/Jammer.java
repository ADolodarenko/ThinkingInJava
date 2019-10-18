package chapter21.toastomatic;

public class Jammer implements Runnable {
	private ToastQueue butteredQueue, finishedQueue;

	public Jammer(ToastQueue butteredQueue, ToastQueue finishedQueue) {
		this.butteredQueue = butteredQueue;
		this.finishedQueue = finishedQueue;
	}

	@Override
	public void run() {
		try {
			while (!Thread.interrupted()) {
				Toast toast = butteredQueue.take();
				toast.jam();

				System.out.println(toast);
				finishedQueue.put(toast);
			}
		} catch (InterruptedException e) {
			System.out.println(getClass().getSimpleName() + " interrupted");
		}

		System.out.println(getClass().getSimpleName() + " off");
	}
}
