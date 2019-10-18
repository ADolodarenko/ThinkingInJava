package chapter09.castgames;

import java.util.Random;

public class DieGame implements Game
{
	private static final String MESSAGE = "The die is cast. Result: ";

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
		result = random.nextInt(6) + 1;
	}
}
