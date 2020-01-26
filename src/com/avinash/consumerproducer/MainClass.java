package com.avinash.consumerproducer;

public class MainClass {
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-genDjerated method stub
		//MainClass obj = new MainClass();
		Object lock = new Object();
		int buffer[]=new int[10];
		int count =0;
		P producer = new P();
		C consumer = new C();
		producer.setLock(lock);
		producer.setBuffer(buffer);
		producer.setCount(count);
		consumer.setLock(lock);
		consumer.setBuffer(buffer);
		consumer.setCount(count);
		Runnable r1 = ()->{
			try {
				producer.producer(buffer,count);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		};
		Runnable r2 = ()->{
			try {
				consumer.consumer(buffer, count);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		};
		Thread t1 = new Thread(r1);
		Thread t2 = new Thread(r2);
		t1.start();
		t2.start();
		t1.join();
		t2.join();
		System.out.println("Done");

	}

}
