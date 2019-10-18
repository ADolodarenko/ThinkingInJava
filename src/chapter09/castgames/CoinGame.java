package chapter09.castgames;

import java.util.Random;

public class CoinGame implements Game
{
	private static final String MESSAGE = "The coin is cast. Result: ";

	private Random random = new Random(47);
	private int result;

	@Override
	public String getMessage()
	{
		return MESSAGE + result;
	}

	@Override
	public void cast()
	{
		result = random.nextInt(10) > 4 ? 1 : 0;
	}
}
