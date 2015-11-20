package com.weatherfish.pool;

/**
* Descript：
* @auther：weatherfish
* Create time：2015年11月17日 上午10:22:13
* @version
*/

public class Task implements Runnable{

    volatile boolean stop = false;
    private int runCount = 0;
    private int taskId;
    public Task(int taskId) {
        this.taskId = taskId;
        System.out.println("Create Task - " + this.taskId);
    }
    
    @Override
    public void run() {
        while(!stop){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("Task Interrupted");
            }
            if(++runCount == 3){
                stop = true;
                System.out.println(Thread.currentThread().toString() + taskId + "---" + runCount);
            }
        }
    }

}


