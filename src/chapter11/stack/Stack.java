package chapter11.stack;

import java.util.LinkedList;

public class Stack<T>
{
	private LinkedList<T> storage = new LinkedList<>();

	public void push(T value)
	{
		storage.addFirst(value);
	}

	public T peek()
	{
		return storage.getFirst();
	}

	public T pop()
	{
		return storage.removeFirst();
	}

	public boolean empty()
	{
		return storage.isEmpty();
	}

	@Override
	public String toString()
	{
		return storage.toString();
	}
}
