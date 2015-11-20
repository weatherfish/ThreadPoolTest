
package com.weatherfish.pool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Descript：
 * 
 * @auther：weatherfish Create time：2015年11月15日 下午8:23:00
 * @version
 */

public class ExecutorsTest {
    private static void doSomething(int id) {
        System.out.println("start do" + id + "task");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("finish do" + id + "task");
    }
    
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        executorService.submit(new Runnable() {
            @Override
            public void run() {
                doSomething(1);
            }
        });

    }
}
