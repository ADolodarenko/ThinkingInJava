package chapter15.inheritbounds;

public class Main
{
	static <T extends Eater> void eat(T eater)
	{
		eater.eat();
	}

	static <T extends Hunter> void hunt(T hunter)
	{
		hunter.hunt();
	}

	public static void main(String[] args)
	{
		Human human = new Human();

		eat(human);
		hunt(human);
	}
}
