package chapter21.toastomatic;

public class Eater2 implements Runnable {
	private ToastQueue finishedQueue;
	private int count = 0;

	public Eater2(ToastQueue finishedQueue) {
		this.finishedQueue = finishedQueue;
	}

	@Override
	public void run() {
		try {
			while (!Thread.interrupted()) {
				Toast toast = finishedQueue.take();

				if ( toast.getId() == count++
						&& (toast.getStatus() == Toast.Status.PEANUTBUTTERED || toast.getStatus() == Toast.Status.JELLIED) )
					System.out.println("Chomp! " + toast);
				else {
					System.out.println(">>>> Error: " + toast);
					System.exit(1);
				}
			}
		} catch (InterruptedException e) {
			System.out.println(getClass().getSimpleName() + " interrupted");
		}

		System.out.println(getClass().getSimpleName() + " off");
	}
}
