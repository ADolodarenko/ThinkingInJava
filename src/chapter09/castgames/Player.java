package chapter09.castgames;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Player
{
	private static final String PROMPT_TEXT = "Enter a number for playing. 0 - Coin, 1 - Die: ";
	private static final String PROMPT_AGAIN_TEXT = "Wanna try again? [Y/N]: ";
	private static final String WRONG_NUMBER_TEXT = "Wrong number. Try again.";
	private static final String EXIT_WORD = "exit";
	private static final String AGAIN_WORD = "y";

	private BufferedReader reader;
	private GameFactory factory;

	public Player()
	{
		reader = new BufferedReader(new InputStreamReader(System.in));
		factory = new GameFactory();
	}

	public void start()
	{
		String input;
		boolean end;

		try
		{
			do
			{
				System.out.print(PROMPT_TEXT);
				input = reader.readLine().trim().toLowerCase();
				end = input.equals(EXIT_WORD);

				if (!end)
					try
					{
						int gameNumber = Integer.parseInt(input);

						play(gameNumber);
					}
					catch (NumberFormatException e)
					{
						System.out.println(WRONG_NUMBER_TEXT);
					}
			}
			while (!end);

			reader.close();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}

	private void play(int gameNumber)
	{
		Game theGame = factory.getGame(gameNumber);
		String input;
		boolean end = false;

		do
		{
			theGame.cast();
			System.out.println(theGame.getMessage());

			System.out.print(PROMPT_AGAIN_TEXT);

			try
			{
				input = reader.readLine().trim().toLowerCase();

				end = !input.equals(AGAIN_WORD);
			}
			catch (IOException e)
			{}
		}
		while (!end);
	}
}
