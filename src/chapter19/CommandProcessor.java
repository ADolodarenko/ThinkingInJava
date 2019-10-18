package chapter19;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.EnumSet;

public class CommandProcessor {
	private static final String EXIT = "exit";
	private static final String PROMPT = "input: ";
	private static final String BYE = "Bye!";
	private static final String SHOW = "show";
	private static final String CLEAR = "clear";

	private String input;
	private EnumSet<Person> personsSet;

	public void start() throws IOException {
		personsSet = EnumSet.noneOf(Person.class);

		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));


		System.out.print(PROMPT);

		while (!EXIT.equals(input = reader.readLine())) {
			if (input != null) {
				if (SHOW.equals(input))
					showPersons();
				else if (CLEAR.equals(input))
					clearPersons();
				else
					addPerson();
			}

			System.out.print(PROMPT);
		}

		System.out.println(BYE);
	}

	private void addPerson() {
		try {
			Person person = Person.valueOf(input);

			if (person != null)
				personsSet.add(person);
		}
		catch (IllegalArgumentException e) {}
	}

	private void showPersons() {
		StringBuilder builder = new StringBuilder();

		for (Person person : personsSet) {
			if (builder.length() > 0)
				builder.append("->");

			builder.append(person.action());
		}

		if (builder.length() > 0) {
			System.out.println(builder.toString());
		}
	}

	private void clearPersons() {
		personsSet.clear();
	}
}
