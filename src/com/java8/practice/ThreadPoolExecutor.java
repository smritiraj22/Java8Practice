package com.java8.practice;

public class ThreadPoolExecutor extends Thread {

    private BlockingQueue taskQueue = null;
    private boolean       isStopped = false;

	public ThreadPoolExecutor(BlockingQueue queue){
        taskQueue = queue;
    }

    public void run(){
        while(!isStopped()){
            try{
                Runnable runnable = (Runnable) taskQueue.dequeue();
                runnable.run();
            } catch(Exception e){
               e.printStackTrace();
            }
        }
    }

    public synchronized void doStop(){
        isStopped = true;
        this.interrupt(); 
    }

    public synchronized boolean isStopped(){
        return isStopped;
    }
}
