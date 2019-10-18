package chapter06.base;

public class Dog
{
	private Cat theCat;

	public Dog(Cat theCat)
	{
		this.theCat = theCat;
	}

	public void biteTheCat()
	{
		theCat.meouw();
	}
}
