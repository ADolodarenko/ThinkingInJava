package chapter21;

public class Fibonacci implements Runnable {
	private int n;

	public Fibonacci(int n) {
		this.n = n;
	}

	@Override
	public void run() {
		System.out.println("Fibonacci(" + n + "): " + fib(n));
	}

	private int fib(int n)
	{
		if (n < 2) return 1;

		return fib(n - 2) + fib(n - 1);
	}
}
