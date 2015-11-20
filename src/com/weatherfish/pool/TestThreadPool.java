package com.weatherfish.pool;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
* Descript：
* @auther：weatherfish
* Create time：2015年11月15日 下午12:17:03
* @version
*/

public class TestThreadPool {

    private static int produceTaskSleepTime = 2;  
    private static int produceTaskMaxNumber = 10;  
    
    public static class ThreadPoolTask implements Runnable{
         private Object data;
         public ThreadPoolTask(Object data) {
             this.data = data;
         }

        @Override
        public void run() {
            System.out.println("start .." + data);  
            try {
                Thread.sleep(2000);
            } catch (Exception e) {
                e.printStackTrace();
            }   
            System.out.println("stop .." + data); 
            data = null;
        }
        public Object getTask() {
            return this.data;
        }
    }
    public static void main(String[] args) {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(2, 4, 3, TimeUnit.SECONDS, new ArrayBlockingQueue<Runnable>(3), new ThreadPoolExecutor.DiscardOldestPolicy());
        for (int i = 0; i < produceTaskMaxNumber; i++) {
            try {
                String task = "task @ " +i;
                System.out.println("put " + task);
                
                executor.execute(new ThreadPoolTask(task));
                
                Thread.sleep(produceTaskSleepTime);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    
    }
    
}


