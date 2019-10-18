package chapter12.hierarchy;

public class B extends A
{
	@Override
	public void doSomething() throws ExA
	{
		throw new ExB();
	}
}
