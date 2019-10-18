package chapter15.covariance;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main
{
	private final int x;

	private Main(int x)
	{
		this.x = x;
	}

	public static void main(String[] args)
	{
		Number[] numbers = new Integer[3];

		for (int i = 0; i < numbers.length; i++)
			numbers[i] = i;

		System.out.println(Arrays.toString(numbers));

		List<? extends Number> numberList = new ArrayList<Integer>();

		/*for (int i = 0; i < 3; i++)
			numberList.add(new Integer(i));*/

		System.out.println(numberList.toString());
	}
}
