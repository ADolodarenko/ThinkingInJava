package chapter09.castgames;

public interface Game
{
	int COIN_GAME = 0, DIE_GAME = 1;

	String getMessage();
	void cast();
}
