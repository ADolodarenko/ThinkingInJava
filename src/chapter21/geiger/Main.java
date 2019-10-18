package chapter21.geiger;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
	public static void main(String[] args) {
		Counter geigerCounter = new Counter();

		ExecutorService executorService = Executors.newCachedThreadPool();
		for (int i = 0; i < 5; i++)
			executorService.execute(new RemoteSensor(geigerCounter));
		executorService.execute(geigerCounter);

		try {
			TimeUnit.SECONDS.sleep(10);
		}
		catch (InterruptedException e) {
			e.printStackTrace();
		}

		geigerCounter.cancel();
		executorService.shutdown();

		try {
			if (!executorService.awaitTermination(3, TimeUnit.SECONDS))
				System.out.println("Cant' stop the counter!");
		}
		catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
