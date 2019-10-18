package chapter10.classiniface;

public interface OuterIface
{
	void doSomething();

	class InnerClass
	{
		void print()
		{
			System.out.println("OuterIface.InnerClass.print()");
		}
	}
}
