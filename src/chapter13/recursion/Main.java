package chapter13.recursion;

import java.util.ArrayList;
import java.util.List;

public class Main
{
	public static void main(String[] args)
	{
		List<InfiniteRecursion> list = new ArrayList<>();

		for (int i = 0; i < 10; i++)
			list.add(new InfiniteRecursion());

		System.out.println(list);
	}
}
