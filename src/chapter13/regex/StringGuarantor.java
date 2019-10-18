package chapter13.regex;

public class StringGuarantor
{
	private static final String REGEX_SENTECE = "^[A-Z]*.$";

	public static boolean isSentence(String expression)
	{
		if (expression == null || expression.isEmpty())
			return false;

		return expression.matches(REGEX_SENTECE);
	}
}
