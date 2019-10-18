package chapter03;

public class HandWithCoin
{
	public static void main(String[] args)
	{
		Coin coin = new Coin();

		for (int i = 0; i < 10; i++)
			System.out.println(coin.flip());
	}
}
