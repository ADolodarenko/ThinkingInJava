package chapter17.maps;

public class Main
{
	public static void main(String[] args)
	{
		SlowMap<String, String> map = new SlowMap<>();

		for (int i = 1; i < 11; i++)
			map.put("Key #" + i, "Value #" + i);

		System.out.println(map);
		System.out.println(map.get("Key #5"));
		System.out.println(map.entrySet());
	}
}
