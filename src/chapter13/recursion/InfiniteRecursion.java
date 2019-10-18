package chapter13.recursion;

public class InfiniteRecursion
{
	@Override
	public String toString()
	{
		return this.getClass().getSimpleName() + ": " + Integer.toHexString(hashCode());
	}
}
