package com.java8.practice;

import java.util.ArrayList;
import java.util.List;

public class ThreadPool {
	private BlockingQueue taskQueue = null;
	private List<ThreadPoolExecutor> threads = new ArrayList<ThreadPoolExecutor>();
	private boolean isStopped = false;

	public ThreadPool(int noOfThreads, int maxNoOfTasks) {
		taskQueue = new BlockingQueue(maxNoOfTasks);

		for (int i = 0; i < noOfThreads; i++) {
			threads.add(new ThreadPoolExecutor(taskQueue));
		}
		threads.forEach(t -> t.start());
	}

	public synchronized void execute(Runnable task) throws Exception {
		if (this.isStopped)
			throw new IllegalStateException("ThreadPool is stopped");

		this.taskQueue.enqueue(task);
	}

	public synchronized void stop() {
		this.isStopped = true;
		threads.forEach(t -> t.doStop());
	}
}
