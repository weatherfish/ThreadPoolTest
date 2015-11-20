
package com.weatherfish.pool.futuretest;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * Descript：
 * 
 * @auther：weatherfish Create time：2015年11月15日 下午12:19:42
 * @version
 */

public class FutureTaskTest {

    public static void main(String[] args) {
        MyCallable callable1 = new MyCallable(2000);
        MyCallable callable2 = new MyCallable(4000);

        FutureTask<String> task1 = new FutureTask<>(callable1);
        FutureTask<String> task2 = new FutureTask<>(callable2);

        ExecutorService executorService = Executors.newFixedThreadPool(2);

        executorService.execute(task1);
        executorService.execute(task2);

        while (true) {
            try {
                if (task1.isDone() && task2.isDone()) {
                    System.out.println("DONE");
                    executorService.shutdown();
                    return;
                }
                if (!task1.isDone()) {
                    System.out.println("wait for task1 finish");
                }
                if (!task1.isDone()) {
                    System.out.println("task1 output = " + task1.get());
                }
                System.out.println("wait for task2 finish");
                String str = task2.get(200L, TimeUnit.MILLISECONDS);
                if (str != null) {
                    System.out.println("task2 output=" + str);
                }
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            } catch (TimeoutException e) {
                System.out.println("TimeoutException e");
            }
        }
    }

}
