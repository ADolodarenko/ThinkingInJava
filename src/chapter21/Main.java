package chapter21;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Main {
	public static void main(String[] args) {
		sleepingTest(Integer.parseInt(args[0]));
	}

	static void sleepingTest(int quantity) {
		ExecutorService service = Executors.newCachedThreadPool();

		for (int i = 0; i < quantity; i++)
			service.execute(new RandomSleeper());

		service.shutdown();
	}

	static void fibonacci2Test() {
		ExecutorService executorService = Executors.newCachedThreadPool();
		List<Future<Integer>> results = new ArrayList<>();

		for (int i = 0; i < 10; i++)
			results.add(executorService.submit(new Fibonacci2(i * 3 + 2)));

		for (Future<Integer> result : results)
			try {
				System.out.println(result.get());
			}
			catch (InterruptedException e) {
				e.printStackTrace();
				return;
			}
			catch (ExecutionException e) {
				e.printStackTrace();
				return;
			}
			finally {
				executorService.shutdown();
			}
	}

	static void speakerAndFibonacciExecTest() {
		speakerTest(Executors.newCachedThreadPool());
		speakerTest(Executors.newFixedThreadPool(2));
		speakerTest(Executors.newSingleThreadExecutor());

		fibonacciTest(Executors.newCachedThreadPool());
		fibonacciTest(Executors.newFixedThreadPool(2));
		fibonacciTest(Executors.newSingleThreadExecutor());
	}

	static void speakerTest() {
		for (int i = 0; i < 5; i++) {
			Thread thread = new Thread(new Speaker(i + 1, 3));
			thread.start();
		}
	}

	static void speakerTest(ExecutorService executorService) {
		for (int i = 0; i < 5; i++)
			executorService.execute(new Speaker(i + 1, 3));

		executorService.shutdown();
	}

	static void fibonacciTest() {
		for (int i = 0; i < 5; i++)
			new Thread(new Fibonacci(i * 2 + 1)).start();
	}

	static void fibonacciTest(ExecutorService executorService) {
		for (int i = 0; i < 5; i++)
			executorService.execute(new Fibonacci(i * 2 + 1));

		executorService.shutdown();
	}
}
