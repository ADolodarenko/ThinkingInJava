package chapter21.restaurant2;

import java.util.concurrent.SynchronousQueue;

public class Customer implements Runnable {
    private static int counter = 0;

    private final int id = counter++;
    private final WaitPerson waitPerson;

    private SynchronousQueue<Plate> placeSetting = new SynchronousQueue<>();

    public Customer(WaitPerson waitPerson) {
        this.waitPerson = waitPerson;
    }

    public void deliver(Plate plate) throws InterruptedException {
        placeSetting.put(plate);
    }

    @Override
    public void run() {
        for (Course course : Course.values()) {
            Food food = course.randomSelection();

            try {
                waitPerson.placeOrder(this, food);

                System.out.println(this + " eating " + placeSetting.take());
            } catch (InterruptedException e) {
                System.out.println(this + " waiting for " + course + " interrupted");

                break;
            }
        }

        System.out.println(this + " finished meal, leaving");
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + " " + id;
    }
}
