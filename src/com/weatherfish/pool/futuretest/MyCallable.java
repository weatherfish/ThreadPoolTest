package com.weatherfish.pool.futuretest;

import java.util.concurrent.Callable;

/**
* Descript：
* @auther：weatherfish
* Create time：2015年11月15日 下午12:17:24
* @version
*/

public class MyCallable implements Callable<String>{
    
    private long waitTime;
    
    public MyCallable(long timeInMillis) {
        this.waitTime = timeInMillis;
    }

    @Override
    public String call() throws Exception {
        Thread.sleep(waitTime);
        return Thread.currentThread().getName();
    }

}


