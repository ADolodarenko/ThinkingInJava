package chapter13.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TestRegularExpression
{
	public static void main(String[] args)
	{
		/*if (args.length < 2)
		{
			System.out.println("Usage:\njava TestRegularExpression " +
					"characterSequence regularExpression+");

			System.exit(0);
		}*/

		/*String[] words = {"Java now has regular expressions",
							"^Java",
							"\\Breg.*",
							"n.w\\s+h(a|i)s",
							"s?",
							"s*",
							"s+",
							"s{4}",
							"s{1}.",
							"s{0,3}"};*/

		String[] words = {"Arline ate eight apples and one orange while Anita hadn't any",
				"(?i)((^[aeiou])|(\\s+[aeiou]))\\w+?[aeiou]\\b"
		};

		System.out.println("Input: \"" + words[0] + "\"");

		for (String word : words)
		{
			System.out.println("Regular expression: \"" + word + "\"");

			Pattern pattern = Pattern.compile(word);
			Matcher matcher = pattern.matcher(words[0]);

			while (matcher.find())
				System.out.println("Match \"" + matcher.group() + "\" at positions " +
						matcher.start() + "-" + (matcher.end() - 1));
		}
	}
}
