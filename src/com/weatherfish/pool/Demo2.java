package com.weatherfish.pool;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/**
* Descript：
* @auther：weatherfish
* Create time：2015年11月20日 下午1:50:23
* @version
*/

public class Demo2 {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        List<Future<String>> list = new ArrayList<>();
        ExecutorService es = Executors.newFixedThreadPool(10);
        for (int i = 0; i < 100; i++) {
            list.add(es.submit(new MyCallable(0)));
        }
        for (Future<String> future : list) {
            System.out.println(future.get()+"");
        }
        es.shutdown();
    }
}


