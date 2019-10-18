package chapter21.toastomatic;

public class JellyMaker implements Runnable {
	private ToastQueue dryQueue, finishedQueue;

	public JellyMaker(ToastQueue dryQueue, ToastQueue finishedQueue) {
		this.dryQueue = dryQueue;
		this.finishedQueue = finishedQueue;
	}

	@Override
	public void run() {
		try {
			while (!Thread.interrupted()) {
				Toast toast = dryQueue.take();
				toast.jelly();

				System.out.println(toast);
				finishedQueue.put(toast);
			}
		} catch (InterruptedException e) {
			System.out.println(getClass().getSimpleName() + " interrupted");
		}

		System.out.println(getClass().getSimpleName() + " off");
	}
}
