package chapter21.toastomatic;

public class Eater implements Runnable {
	private ToastQueue finishedQueue;
	private int count = 0;

	public Eater(ToastQueue finishedQueue) {
		this.finishedQueue = finishedQueue;
	}

	@Override
	public void run() {
		try {
			while (!Thread.interrupted()) {
				Toast toast = finishedQueue.take();

				if (toast.getId() != count++ || toast.getStatus() != Toast.Status.JAMMED) {
					System.out.println(">>>> Error: " + toast);
					System.exit(1);
				}
				else
					System.out.println("Chomp! " + toast);
			}
		} catch (InterruptedException e) {
			System.out.println(getClass().getSimpleName() + " interrupted");
		}

		System.out.println(getClass().getSimpleName() + " off");
	}
}
