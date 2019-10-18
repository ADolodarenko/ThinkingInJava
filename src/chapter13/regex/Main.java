package chapter13.regex;

public class Main
{
	private static final String KNIGHTS = "Then, when you have found the shrubbery, you must " +
			"cut down the mightiest tree in the forest... " +
			"with... a herring!";

	public static void main(String[] args)
	{
		//checkSentence();
		//splitTheKnights();

		replaceInKnights();
	}

	static void checkSentence()
	{
		String expression = "X.";

		System.out.println(StringGuarantor.isSentence(expression));
	}

	static void splitTheKnights()
	{
		String[] words = KNIGHTS.split("the|you");

		for (String word : words)
			System.out.println(word);
	}

	static void replaceInKnights()
	{
		System.out.println(KNIGHTS.replaceAll("[aeiou]", "_"));
	}
}
