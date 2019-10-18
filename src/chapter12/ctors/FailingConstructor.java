package chapter12.ctors;

public class FailingConstructor
{
	private FailTester tester;
	private FailTester anotherTester;

	public FailingConstructor(int i) throws Exception
	{
		tester = new FailTester();

		if (i == 10)
			throw new Exception();

		anotherTester = new FailTester();
	}
}
