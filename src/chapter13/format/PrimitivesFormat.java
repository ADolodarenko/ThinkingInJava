package chapter13.format;

public class PrimitivesFormat
{
	private int intNumber;
	private long longNumber;
	private float floatNumber;
	private double doubleNumber;

	public PrimitivesFormat(int intNumber, long longNumber, float floatNumber, double doubleNumber)
	{
		this.intNumber = intNumber;
		this.longNumber = longNumber;
		this.floatNumber = floatNumber;
		this.doubleNumber = doubleNumber;
	}

	@Override
	public String toString()
	{
		return String.format("%s: %10d, %10d, %10.2f, %10.2f",
				getClass().getSimpleName(),
				intNumber, longNumber, floatNumber, doubleNumber);
	}
}
