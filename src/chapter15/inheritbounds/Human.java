package chapter15.inheritbounds;

public class Human implements Hunter, Eater
{
	@Override
	public void eat()
	{
		System.out.println("Slurp!");
	}

	@Override
	public void hunt()
	{
		System.out.println("Boom!");
	}
}
