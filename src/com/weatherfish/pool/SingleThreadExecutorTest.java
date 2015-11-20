package com.weatherfish.pool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
* Descript：
* @auther：weatherfish
* Create time：2015年11月17日 上午10:28:07
* @version
*/

public class SingleThreadExecutorTest {
    public static void main(String[] args) {
        try {
            ExecutorService executorService = Executors.newSingleThreadExecutor();
            for(int i=0;i<=3;i++){
                executorService.execute(new Task(i));
            }
            executorService.shutdown();
        } catch (Exception e) {
            // TODO: handle exception
        }
    }
}


