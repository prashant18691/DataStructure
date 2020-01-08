package com.test.prs.java.doubts.threads;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicBoolean;

public class ThreadPool {
    private int nThreads;
    private LinkedBlockingQueue queue;// no need to synchronize
    private WorkerThreads[] poolWorkers;
    private AtomicBoolean exit;

    public ThreadPool(int nThreads) {
        this.nThreads = nThreads;
        queue = new LinkedBlockingQueue();
        exit = new AtomicBoolean(false);
        this.poolWorkers = new WorkerThreads[nThreads];
        for (int i = 0; i < nThreads ; i++) {
            this.poolWorkers[i] = new WorkerThreads();
            this.poolWorkers[i].setName("T"+(i+1));
            this.poolWorkers[i].start();
        }
    }

    public void shutdown(){
        this.exit.set(true);
    }

    public static void main(String[] args) {
        ThreadPool pool = new ThreadPool(3);
        for (int i = 1; i <= 4; i++) {
            pool.execute(new Task(i));
        }
        pool.shutdown();
    }

    public void execute(Runnable task){
        synchronized (queue){
            queue.add(task);
            queue.notify();
        }
    }

    private class WorkerThreads extends Thread{
        @Override
        public void run() {
            Runnable task = null;
            while (!exit.get()){
                synchronized (queue){
                    while (queue.isEmpty()) {
                        try {
                            queue.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    task = (Runnable) queue.poll();
                    task.run();
                }
            }
        }
    }
}

class Task implements Runnable{

    private int num;

    public Task(int num) {
        this.num = num;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+" :: Task "+num+" is running.");
    }
}
