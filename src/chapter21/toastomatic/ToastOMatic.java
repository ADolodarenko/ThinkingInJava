package chapter21.toastomatic;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ToastOMatic {
	public static void main(String[] args) throws InterruptedException {
		//butterAndJam();

		peanutOrJelly();
	}

	private static void butterAndJam() throws InterruptedException {
		ToastQueue dryQueue = new ToastQueue(),
				butteredQueue = new ToastQueue(),
				finishedQueue = new ToastQueue();

		ExecutorService exec = Executors.newCachedThreadPool();
		exec.execute(new Toaster(dryQueue));
		exec.execute(new Butterer(dryQueue, butteredQueue));
		exec.execute(new Jammer(butteredQueue, finishedQueue));
		exec.execute(new Eater(finishedQueue));

		TimeUnit.SECONDS.sleep(5);

		exec.shutdownNow();
	}

	private static void peanutOrJelly() throws InterruptedException {
		ToastQueue dryQueueForPeanut = new ToastQueue(),
				dryQueueForJelly = new ToastQueue(),
				finishedQueue = new ToastQueue();
		Counter counter = new Counter();

		ExecutorService exec = Executors.newCachedThreadPool();
		exec.execute(new Toaster2(dryQueueForPeanut, counter));
		exec.execute(new Toaster2(dryQueueForJelly, counter));
		exec.execute(new PeanutButterer(dryQueueForPeanut, finishedQueue));
		exec.execute(new JellyMaker(dryQueueForJelly, finishedQueue));
		exec.execute(new Eater2(finishedQueue));

		TimeUnit.SECONDS.sleep(5);

		exec.shutdownNow();
	}
}
