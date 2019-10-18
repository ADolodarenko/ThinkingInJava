package chapter21.activewaiting;

public class Flag {
	private static boolean value = false;

	public static synchronized void setValue(boolean value) {
		Flag.value = value;
	}

	public static synchronized boolean getValue() {
		return Flag.value;
	}
}
