package chapter15.characters;

import chapter15.iterable.Generator;

import java.util.Iterator;
import java.util.Random;

public class StoryCharacterGenerator
		implements Generator<StoryCharacter>, Iterable<StoryCharacter>
{
	private static Random random = new Random(47);

	private Class[] types = { TheGod.class, Noah.class, Methuselah.class, Ham.class };
	private int size = 0;

	public StoryCharacterGenerator(){}

	public StoryCharacterGenerator(int size)
	{
		this.size = size;
	}

	@Override
	public StoryCharacter next()
	{
		try
		{
			return (StoryCharacter)types[random.nextInt(types.length)].newInstance();
		}
		catch (Exception e)
		{
			throw new RuntimeException(e);
		}
	}

	@Override
	public Iterator<StoryCharacter> iterator()
	{
		return new StoryCharacterIterator();
	}

	class StoryCharacterIterator implements Iterator<StoryCharacter>
	{
		int count = size;

		@Override
		public boolean hasNext()
		{
			return count > 0;
		}

		@Override
		public StoryCharacter next()
		{
			count--;

			return StoryCharacterGenerator.this.next();
		}
	}

	public static void main(String[] args)
	{
		StoryCharacterGenerator generator = new StoryCharacterGenerator();
		for (int i = 0; i < 5; i++)
			System.out.println(generator.next());

		for (StoryCharacter character : new StoryCharacterGenerator(5))
			System.out.println(character);
	}
}
