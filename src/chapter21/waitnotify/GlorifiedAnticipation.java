package chapter21.waitnotify;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class GlorifiedAnticipation {
	public static void main(String[] args) {
		Anticipant anticipant = new Anticipant();
		Notifier notifier = new Notifier(anticipant);

		ExecutorService exec = Executors.newCachedThreadPool();
		exec.execute(anticipant);
		exec.execute(notifier);

		exec.shutdown();
	}
}
