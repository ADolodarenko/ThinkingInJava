package chapter21;

import java.util.concurrent.Callable;

public class Fibonacci2 implements Callable<Integer> {
	private int n;

	public Fibonacci2(int n) {
		this.n = n;
	}

	@Override
	public Integer call() throws Exception {
		return fib(n);
	}

	private int fib(int n)
	{
		if (n < 2) return 1;

		return fib(n - 2) + fib(n - 1);
	}
}
