package chapter21.restaurant2;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Chef implements Runnable {
    private static int counter = 0;
    private static Random random = new Random(47);

    private final int id = counter++;
    private final Restaurant restaurant;

    public Chef(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                Order order = restaurant.orders.take();
                Food requestedItem = order.item();

                TimeUnit.MILLISECONDS.sleep(random.nextInt(500));

                Plate plate = new Plate(order, requestedItem);
                order.getWaitPerson().filledOrders.put(plate);
            }
        } catch (InterruptedException e) {
            System.out.println(this + " interrupted");
        }

        System.out.println(this + " off duty");
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + " " + id;
    }
}
