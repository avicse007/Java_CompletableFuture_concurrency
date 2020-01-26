package com.avinash.deadlock;

public class MainClass {


	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		DeadLock deadlock = new DeadLock();
		Runnable r1 = ()->deadlock.a();
		Runnable r2 = ()->deadlock.b();
		
		Thread t1 = new Thread(r1);
		
		Thread t2 = new Thread(r2);
		
		t1.start();
		t2.start();
		t1.join();
		t2.join();

	}

}
