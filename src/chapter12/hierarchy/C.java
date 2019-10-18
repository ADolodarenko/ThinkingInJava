package chapter12.hierarchy;

public class C extends B
{
	@Override
	public void doSomething() throws ExA
	{
		throw new ExC();
	}
}
