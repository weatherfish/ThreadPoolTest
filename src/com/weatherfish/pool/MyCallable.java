
package com.weatherfish.pool;

import java.util.concurrent.Callable;

/**
 * Descript：
 * 
 * @auther：weatherfish Create time：2015年11月20日 下午1:45:08
 * @version
 */

public class MyCallable implements Callable<String> {

    private int flag = 0;

    public MyCallable(int flag) {
        this.flag = flag;
    }

    @Override
    public String call() throws Exception {
        if (this.flag == 0) {
            Thread.sleep(2000);
            //System.out.println("log 0:  " + Thread.currentThread().getId());
            return "0:  " + Thread.currentThread().getId();
        }
        if (this.flag == 1) {
            try {
                while (true) {
                    System.out.println("LOOPING ..." + flag);
                    Thread.sleep(2000);
                }
            } catch (InterruptedException e) {
                System.out.println("Interrrupted");
            }
            return "1:  " + Thread.currentThread().getId();
        } else {
            throw new Exception("Bad flag value");
        }
    }

}
