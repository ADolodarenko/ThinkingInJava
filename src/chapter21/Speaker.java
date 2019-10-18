package chapter21;

public class Speaker implements Runnable {
	private static final String START_TEMPLATE = "Task %d started.";
	private static final String WORK_TEMPLATE = "Task %d is working.";
	private static final String END_TEMPLATE = "Task %d ended.";

	private int taskNumber;
	private int speakIterations;

	public Speaker(int taskNumber, int speakIterations) {
		this.taskNumber = taskNumber;
		this.speakIterations = speakIterations;

		speak(String.format(START_TEMPLATE, this.taskNumber));
	}

	@Override
	public void run() {
		for (int i = 0; i < speakIterations; i++) {
			speak(String.format(WORK_TEMPLATE, taskNumber));

			Thread.yield();
		}

		speak(String.format(END_TEMPLATE, taskNumber));
	}

	private void speak(String message) {
		System.out.println(message);
	}
}
