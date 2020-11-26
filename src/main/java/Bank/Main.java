package Bank;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.LongAdder;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        LongAdder sum = new LongAdder();
        final Runnable shop1 = new Count(sum);
        final Runnable shop2 = new Count(sum);
        final Runnable shop3 = new Count(sum);

        ExecutorService executorService = Executors.newFixedThreadPool(3);

        executorService.submit(shop1);
        executorService.submit(shop2);
        executorService.submit(shop3);

        executorService.awaitTermination(5, TimeUnit.SECONDS);

        System.out.println("Результат: " + sum.sum());
        executorService.shutdown();
    }
}
