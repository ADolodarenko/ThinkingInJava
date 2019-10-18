package chapter12.ctors;

public class Main
{
	public static void main(String[] args)
	{
		//test01();

		test02();
	}

	private static void test02()
	{
		try
		{
			FailingConstructor ctor = new FailingConstructor(10);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	public static void test01()
	{
		try
		{
			SuccessorClass cl = new SuccessorClass();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
}
