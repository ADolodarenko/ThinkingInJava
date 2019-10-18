package chapter15.anonymous;

import chapter15.iterable.Generator;

public class LittleFish
{
	private static long counter = 1;

	public static Generator<LittleFish> generator()
	{
		return new Generator<LittleFish>()
		{
			@Override
			public LittleFish next()
			{
				return new LittleFish();
			}
		};
	}

	private final long id = counter++;

	private  LittleFish(){}

	@Override
	public String toString()
	{
		return getClass().getSimpleName() + " " + id;
	}
}
