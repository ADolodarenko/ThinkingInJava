package chapter10.classiniface;

public class OuterClass implements OuterIface
{
	@Override
	public void doSomething()
	{
		new InnerClass().print();
	}
}
