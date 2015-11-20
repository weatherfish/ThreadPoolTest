package com.weatherfish.pool;

import java.util.concurrent.ThreadFactory;

/**
* Descript：
* @auther：weatherfish
* Create time：2015年11月17日 上午10:37:25
* @version
*/

public class DaemonThreadFactory implements ThreadFactory{

    @Override
    public Thread newThread(Runnable r) {
        Thread thread = new Thread(r);
        thread.setDaemon(true);
        return thread;
    }

}


