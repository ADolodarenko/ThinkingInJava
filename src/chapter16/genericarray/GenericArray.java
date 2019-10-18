package chapter16.genericarray;

public class GenericArray<T>
{
	public T[] getArray(int size)
	{
		Object[] objArray = new Object[size];

		objArray[0] = "ZZ";

		return (T[]) objArray;
	}
}
