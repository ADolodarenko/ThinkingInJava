package chapter11.stack;

public class PhraseCalc
{
	private Stack<String> stack;

	public PhraseCalc()
	{
		stack = new Stack<>();
	}

	public void calculate(String phrase)
	{
		if (phrase != null && !phrase.isEmpty())
		{
			char[] charsArray = phrase.toCharArray();
			int i = 0;

			while (i < charsArray.length)
			{
				if (charsArray[i] == '+')
				{
					i++;

					if (i < charsArray.length)
						stack.push(String.valueOf(charsArray[i]));
				}
				else if (charsArray[i] == '-')
				{
					System.out.print(stack.pop());
				}

				i++;
			}
		}
	}
}
