package chapter13.regex;

import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Groups
{
	public static final String POEM =
			"Twas brilling, and the slithy toves\n" +
					"Did gyre and gimble in the wabe.\n" +
					"All mimsy were the borogoves,\n" +
					"And the mome raths outgrabe.";

	public static void main(String[] args)
	{
		Set<String> words = new HashSet<>();

		Matcher matcher = Pattern.compile("\\b[a-z]\\w+\\b").matcher(POEM);

		while (matcher.find())
			words.add(matcher.group());

		System.out.println(words.size());

		for (String word : words)
		{
			System.out.println(word);
		}
	}
}
