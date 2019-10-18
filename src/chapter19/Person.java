package chapter19;

public enum Person {
	SMUGGLER {
		@Override
		String action() {
			return "Brought some narcotics";
		}
	},
	KILLER {
		@Override
		String action() {
			return "Killed a whore";
		}
	},
	DETECTIVE {
		@Override
		String action() {
			return "Found a bastard";
		}
	};

	abstract String action();
}
