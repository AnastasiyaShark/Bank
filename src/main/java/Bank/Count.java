package Bank;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.atomic.LongAdder;

public class Count implements Runnable {
    LongAdder sum;

    public Count(LongAdder sum) {
        this.sum = sum;
    }

    @Override
    public void run() {
        int recordsNumber = 10;
        int bound = 2000;
        Random random = new Random();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < recordsNumber; i++) {
            int rand = random.nextInt(bound);
            list.add(rand);
        }
        System.out.printf("%s get %s%n", Thread.currentThread().getName(), list.toString());
        for (Integer i : list) {
            sum.add(i);
        }
    }
}
