package com.weatherfish.pool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
* Descript：
* @auther：weatherfish
* Create time：2015年11月17日 上午10:35:44
* @version
*/

public class FixThreadPoolTest {
    public static void main(String[] args) {
        try {
            ExecutorService executorService = Executors.newFixedThreadPool(2);
            for(int i=0;i<6;i++){
                executorService.execute(new Task(i));
            }
            executorService.shutdown();
        } catch (Exception e) {
            // TODO: handle exception
        }
    }
}


