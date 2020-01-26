package com.avinash.consumerproducer;

public class C {
	private Object lock;
	private int buffer[];
	private int count;
	public void consumer(int buffer[],int count) throws InterruptedException {
		synchronized (lock) {
		if(count==0)
			lock.wait();
		buffer[count--]=0;
		System.out.println("Done Consuming with count "+count);
		lock.notify();
		this.notify();
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
