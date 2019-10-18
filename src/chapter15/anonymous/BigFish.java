package chapter15.anonymous;

import chapter15.iterable.Generator;

public class BigFish
{
	private static long counter = 1;

	public static Generator<BigFish> generator = new Generator<BigFish>()
		{
			@Override
			public BigFish next()
			{
				return new BigFish();
			}
		};

	private final long id = counter++;

	private BigFish(){}

	@Override
	public String toString()
	{
		return getClass().getSimpleName() + " " + id;
	}
}
