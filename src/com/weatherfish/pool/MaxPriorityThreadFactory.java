package com.weatherfish.pool;

import java.util.concurrent.ThreadFactory;

/**
* Descript：
* @auther：weatherfish
* Create time：2015年11月17日 上午10:38:46
* @version
*/

public class MaxPriorityThreadFactory implements ThreadFactory{

    @Override
    public Thread newThread(Runnable r) {
        Thread thread = new Thread(r);
        thread.setPriority(Thread.MAX_PRIORITY);
        return thread;
    }

}


