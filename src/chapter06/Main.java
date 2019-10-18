package chapter06;

import chapter06.base.Cat;
import chapter06.base.Dog;

public class Main
{
	public static void main(String[] args)
	{
		new BlackCat().react();

		new Dog(new Cat()).biteTheCat();
	}
}
