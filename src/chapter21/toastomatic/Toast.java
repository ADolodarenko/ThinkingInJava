package chapter21.toastomatic;

public class Toast {
	public enum Status { DRY, BUTTERED, JAMMED, PEANUTBUTTERED, JELLIED };

	private Status status = Status.DRY;
	private final int id;

	public Toast(int id) {
		this.id = id;
	}

	public void butter() {
		status = Status.BUTTERED;
	}

	public void peanutButter() {
		status = Status.PEANUTBUTTERED;
	}

	public void jam() {
		status = Status.JAMMED;
	}

	public void jelly() {
		status = Status.JELLIED;
	}

	public Status getStatus() {
		return status;
	}

	public int getId() {
		return id;
	}

	@Override
	public String toString() {
		return getClass().getSimpleName() + " " + id + ": " + status;
	}
}
