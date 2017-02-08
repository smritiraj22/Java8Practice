package com.java8.practice;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BlockingQueueLocks {
	private List queue = new LinkedList();
	private int limit = 10;
	Lock lock = new ReentrantLock();

	public BlockingQueueLocks(int limit) {
		this.limit = limit;
	}

	public synchronized void enqueue(Object item) throws InterruptedException {
		while (this.queue.size() == this.limit) {
			return;
		}
		lock.lock();
		this.queue.add(item);
		lock.unlock();
	}

	public synchronized void dequeue() throws InterruptedException {
		while (this.queue.size() == 0) {
			return;
		}
		lock.lock();
		queue.remove(0);
		lock.unlock();
	}

}
