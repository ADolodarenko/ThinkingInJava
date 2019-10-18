package chapter12.hierarchy;

public class Main
{
	public static void main(String[] args)
	{
		C c = new C();

		try
		{
			((A)c).doSomething();
		}
		catch (ExA exA)
		{
			exA.printStackTrace();
		}
	}
}
