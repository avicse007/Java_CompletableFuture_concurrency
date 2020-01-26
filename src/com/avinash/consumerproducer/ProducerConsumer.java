package com.avinash.consumerproducer;

public class ProducerConsumer {
	
	private static Object lock = new Object();
	
	private static int[] buffer;
	private static int count;
	
	static class Producer{
		
		void produce() throws InterruptedException {
			synchronized (lock) {
			if(isFull(buffer)) 
			{
				lock.wait();
			}
				buffer[count++]=1;
				System.out.println("Producing is done with count "+count);
				lock.notify();
		}
		}
		
	}
	
	static class Consumer{
		
		void consume() throws InterruptedException {
			synchronized (lock) {
			if(isEmpty(buffer)) 
			{
				lock.wait();
			}
				buffer[--count]=0;
				System.out.println("Done consuming with count "+count);
				lock.notify();
		}
		}
	}
	
	static public boolean isFull(int [] buffer) {
	   return count==buffer.length;
	}
	
	static public boolean isEmpty(int [] buffer) {
		return count==0;
	}
	
	public static void main(String[] args) throws InterruptedException {
		buffer =new int[10];
		count = 0;
		
		Producer producer = new Producer();
		Consumer consumer = new Consumer();
		
		Runnable producerTask = ()->{
			for(int i=0;i<50;i++) {
				try {
					producer.produce();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			System.out.println("Done Producing");
		};
		
		Runnable consumerTask = ()->{
			for(int i=0;i<50;i++) {
				try {
					consumer.consume();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			System.out.println("Done Consuming");
		};
		
		Thread producerThread = new Thread(producerTask);
		Thread consumerThread = new Thread(consumerTask);
		
		
		producerThread.start();
		consumerThread.start();
		
		producerThread.join();
		consumerThread.join();
		
		
		System.out.println("Data in the buffer "+count);
	}

}
