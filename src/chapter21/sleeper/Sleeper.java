package chapter21.sleeper;

import java.util.concurrent.TimeUnit;

public class Sleeper {
	public static void sleep() throws InterruptedException {
		TimeUnit.SECONDS.sleep(240);
	}
}
