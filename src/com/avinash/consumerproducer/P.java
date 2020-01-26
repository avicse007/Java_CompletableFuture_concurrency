package com.avinash.consumerproducer;

public class P {
	private Object lock;
	private int buffer[];
	private int count;
	public void producer(int buffer[],int count) throws InterruptedException {
		synchronized (lock) {
		if(count==buffer.length) {
			lock.wait();
		}
		buffer[count++]=1;
		System.out.println("Done Producing with count "+count);
		lock.notify();
	}
	}

	public Object getLock() {
		return lock;
	}

	public void setLock(Object lock) {
		this.lock = lock;
	}

	public int[] getBuffer() {
		return buffer;
	}

	public void setBuffer(int buffer[]) {
		this.buffer = buffer;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}
	
}
