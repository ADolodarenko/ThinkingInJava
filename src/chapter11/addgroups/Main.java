package chapter11.addgroups;

import java.util.*;

public class Main
{
	public static void main(String[] args)
	{
		/*
		Arrays.asList() returns a pared ArrayList, declared as a static class in the class Arrays.
		There is no implementation of the add() method in this class, for example, so it ends up with executing
		AbstractList.add() variant with its UnsupportedOperationException(). "Amazing", isn't it?
		 */
		List<Integer> list = Arrays.asList(1, 2, 3, 4);

		System.out.println(list.getClass().getName());

		list.set(1, 22);
		list.add(5);
	}
}
