package chapter09.castgames;

public class GameFactory
{
	public Game getGame(int gameNumber)
	{
		if (gameNumber == Game.COIN_GAME)
			return new CoinGame();
		else
			return new DieGame();
	}
}
