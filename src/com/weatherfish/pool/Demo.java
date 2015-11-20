package com.weatherfish.pool;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
* Descript：
* @auther：weatherfish
* Create time：2015年11月20日 下午1:50:23
* @version
*/

public class Demo {
    public static void main(String[] args) {
        MyCallable task1 = new MyCallable(0);
        MyCallable task2 = new MyCallable(1);
        MyCallable task3 = new MyCallable(2);
        
        ExecutorService es = Executors.newFixedThreadPool(3);
        Future<String> future2 = null;
        try {
            Future<String> future1 = es.submit(task1);
            System.out.println("task1  " + future1.get());
            System.out.println("task1 isDone " + future1.isDone());
            
            future2 = es.submit(task2);
            System.out.println("task2  " + future2.get(5, TimeUnit.SECONDS));
            System.out.println("------------");
            System.out.println("task2 cancel " + future2.cancel(true));
            
            System.out.println("task2 isCanceled "+ future2.isCancelled());
            
            
            Future<String> future3 = es.submit(task3);
            System.out.println("task3  " + future3.get());
            
        }catch(TimeoutException e){
            e.printStackTrace();
            System.out.println("++++++++++++++++++");
            System.out.println("+++task2 cancel " + future2.cancel(true));
            
            System.out.println("+++task2 isCanceled "+ future2.isCancelled());
            
            Future<String> future3 = es.submit(task3);
            try {
                System.out.println("+++task3  " + future3.get());
            } catch (InterruptedException | ExecutionException e1) {
                e1.printStackTrace();
            }
            
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
        es.shutdown();
    }
}


