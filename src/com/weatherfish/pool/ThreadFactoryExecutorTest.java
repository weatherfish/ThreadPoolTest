package com.weatherfish.pool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
* Descript：
* @auther：weatherfish
* Create time：2015年11月17日 上午10:40:04
* @version
*/

public class ThreadFactoryExecutorTest {
    
    public static void main(String[] args) {
        try {
            ExecutorService defaultES = Executors.newCachedThreadPool();
            ExecutorService deamonES = Executors.newCachedThreadPool(new DaemonThreadFactory());
            ExecutorService maxPriorityES = Executors.newCachedThreadPool(new MaxPriorityThreadFactory());
            ExecutorService minPriorityES = Executors.newCachedThreadPool(new MinPriorityThreadFactory());
            
            for (int i = 0; i < 10; i++) {
                deamonES.execute(new Task(i));
            }
            for (int j = 10; j < 20; j++) {
                if(j==10)
                    maxPriorityES.execute(new Task(j));
                else if (j == 11) {
                    minPriorityES.execute(new Task(j));
                }else {
                    defaultES.execute(new Task(j));
                }
            }
        } catch (Exception e) {
            // TODO: handle exception
        }
    }
}


