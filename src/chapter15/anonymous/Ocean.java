package chapter15.anonymous;

import java.util.*;

public class Ocean
{
	public static void eat(BigFish eater, LittleFish meat)
	{
		System.out.println(eater + " is eating " + meat);
	}

	public static void main(String[] args)
	{
		Random random = new Random(47);

		Queue<LittleFish> mealQueue = new LinkedList<>();
		//Generators.fill(mealQueue, LittleFish.generator(), 115);

		List<BigFish> eaters = new ArrayList<>();
		//Generators.fill(eaters, BigFish.generator, 20);

		for (LittleFish meal : mealQueue)
			eat(eaters.get(random.nextInt(eaters.size())), meal);
	}
}
