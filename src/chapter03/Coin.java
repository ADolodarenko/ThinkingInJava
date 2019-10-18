package chapter03;

import java.util.Random;

public class Coin
{
	private Random random;

	public Coin()
	{
		random = new Random();
	}

	public boolean flip()
	{
		int nextResult = random.nextInt(10);

		return nextResult > 4;
	}
}
