package chapter15.iterable;

import java.util.Iterator;

public class IterableFibonacci implements Iterable<Integer>
{
	private Fibonacci fibonacci;
	private int n;

	public IterableFibonacci(int count)
	{
		n = count;

		fibonacci = new Fibonacci();
	}

	@Override
	public Iterator<Integer> iterator()
	{
		return new Iterator<Integer>()
		{
			@Override
			public boolean hasNext()
			{
				return n > 0;
			}

			@Override
			public Integer next()
			{
				n--;

				return fibonacci.next();
			}
		};
	}

	public static void main(String[] args)
	{
		for (int i : new IterableFibonacci(18))
			System.out.print(i + " ");
	}
}
