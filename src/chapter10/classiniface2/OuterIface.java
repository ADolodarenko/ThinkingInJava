package chapter10.classiniface2;

public interface OuterIface
{
	int getInt();

	class InnerClass
	{
		static void print(OuterIface iface)
		{
			System.out.println("Result is: " + iface.getInt());
		}
	}
}
