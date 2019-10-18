package chapter16.genericarray;

import java.util.Arrays;

public class Main
{
	public static void main(String[] args)
	{
		Integer[] intArray = new GenericArray<Integer>().getArray(10);

		System.out.println(Arrays.toString(intArray));
	}
}
