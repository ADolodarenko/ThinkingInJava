package chapter15.characters;

public abstract class StoryCharacter
{
	private static long counter = 0;

	private final long id = counter++;

	@Override
	public String toString()
	{
		return getClass().getSimpleName() + "-" + getDescription() + "-" + id;
	}

	protected abstract String getDescription();
}
