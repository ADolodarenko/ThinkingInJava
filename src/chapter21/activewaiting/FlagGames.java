package chapter21.activewaiting;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class FlagGames {
	public static void main(String[] args) {
		ExecutorService exec = Executors.newCachedThreadPool();
		exec.execute(new Anticipant2());
		exec.execute(new Notifier2());
		exec.shutdown();
	}
}
